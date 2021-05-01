package com.example.demo.controller;

import com.example.demo.entity.Album;
import com.example.demo.repository.AlbumRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;



    @PostMapping("/add")
    public String addPhoto(
            @RequestParam("nomAlbum") String nomAlbum,
            @RequestParam("annee") Integer annee,
            @RequestParam("nomArtist") String nomArtist,
            @RequestParam("prix") Float prix,
            @RequestParam Optional<MultipartFile>  image,
            @RequestParam Optional<String> id,
            Model model)throws IOException {

        Album album = new Album();
        album.setNom(nomAlbum);
        album.setAnneeDeSortie(annee);
        album.setArtist(nomArtist);
        album.setPrix(prix);

        if(image.isPresent())
        {
            album.setImage(new Binary(BsonBinarySubType.BINARY, image.get().getBytes()));
        }

        if(id.isPresent())
        {
            album.setId(id.get());
            albumRepository.save(album);
            return "redirect:/albums/list";
        }

        albumRepository.insert(album);

        return "redirect:/albums/list";
    }




    @RequestMapping(
            value = "/list",
            method = RequestMethod.GET
    )
    public String recherche
            (
                    final ModelMap model ,
                    @RequestParam (defaultValue = "0")      Integer page,
                    @RequestParam (defaultValue = "5")     Integer size,
                    @RequestParam (defaultValue = "artist")    String sortProperty,
                    @RequestParam (defaultValue = "ASC")    String sortDirection
            )
    {

        List<Sort.Order> orders = new ArrayList<Sort.Order>();
        Sort.Order order = new Sort.Order(Sort.Direction.ASC, "prix");
        Sort.Order order2 = new Sort.Order(Sort.Direction.ASC, "nom");
        orders.add(order);
        orders.add(order2);

        PageRequest pageRequest = PageRequest.of(page,size, Sort.by(orders));

        Page<Album> albumPage = albumRepository.findAll(pageRequest);

        model.put("listeAlbum",albumPage);

        return "listeAlbum";
    }



    @RequestMapping(value = "/image/{album_id}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable("album_id") String album_id) throws IOException {

        Binary binary = (albumRepository.findById(album_id)).get().getImage();
        byte[] imageContent =binary.getData();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
    }



    @RequestMapping(value = "/{album_id}")
    public String detailAlbum(
            final ModelMap model ,
            @PathVariable("album_id") String album_id
    ) throws IOException {

        Album album = albumRepository.findById(album_id).get();
        model.put("album",album);

        return "album";
    }



}
