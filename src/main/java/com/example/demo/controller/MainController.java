package com.example.demo.controller;

import com.example.demo.entity.Album;
import com.example.demo.entity.Artist;
import com.example.demo.repository.AlbumRepository;
import com.example.demo.repository.ArtistRepository;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.ArrayList;

@Controller
public class MainController {


    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ArtistRepository artistRepository;


    @RequestMapping(
            value =  "/"
            , method = RequestMethod.GET
    )
    public String loginPage(Model model) {

        return "index";
    }


    @RequestMapping(
            value =  "/insertAlbum",
            method = RequestMethod.POST
    )
    public String pageAjoutAlbum(Model model) {


        return "album";
    }

    @RequestMapping(
            value =  "/insertArtist",
            method = RequestMethod.POST
    )
    public String pageAjoutArtist(Model model) {


        return "artist";
    }

    @RequestMapping(
            value =  "/insertClient",
            method = RequestMethod.POST
    )
    public String pageAjoutClient(Model model) {


        return "client";
    }


    @RequestMapping(
            value =  "/listeAlbum",
            method = RequestMethod.POST
    )
    public String pageListeAlbum(Model model) {


        return "listeAlbum";
    }


    @RequestMapping(
            value =  "/listeAlbumParAnnee",
            method = RequestMethod.POST
    )
    public String pageListeAlbumParAnnee(Model model) {

        ArrayList<Album> albumArrayList = new ArrayList<>();
        albumArrayList = (ArrayList<Album>) albumRepository.findAllByOrderByAnneeDeSortieAsc();


        model.addAttribute("albumArrayList",albumArrayList);

        return "listeAlbumParAnnee";
    }

    @RequestMapping(
            value =  "/listeArtistParNom",
            method = RequestMethod.POST
    )
    public String pageListeArtistParNom(Model model) {

        ArrayList<Artist> artistArrayList = new ArrayList<>();
        artistArrayList = (ArrayList<Artist>) artistRepository.findAllByOrderByNomAsc();


        model.addAttribute("artistArrayList",artistArrayList);

        return "listeArtistParNom";
    }




    @RequestMapping(value = "/image/{album_id}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable("album_id") String album_id) throws IOException {

        Binary binary = (albumRepository.findById(album_id)).get().getImage();
        byte[] imageContent =binary.getData();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
    }



}
