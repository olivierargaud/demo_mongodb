package com.example.demo.controller;

import com.example.demo.repository.AlbumRepository;
import com.example.demo.repository.CommandeRepository;
import com.example.demo.entity.Commande;
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

@Controller
public class MainController {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @RequestMapping(
            value =  "/"
            , method = RequestMethod.GET
    )
    public String loginPage(Model model) {

        return "index";
    }

    @RequestMapping(
            value =  "/test",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public String save(Model model, Commande commande) {


        commandeRepository.insert(commande);

        return "index";
    }


//    @RequestMapping(
//            value =  "/insertArtist",
//            method = RequestMethod.POST,
//            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
//    )
//    public String saveArtist(Model model) {
//
//        Album album = new Album();
//        album.setNom("chanson de toto");
//        album.setArtist("toto");
//        album.setAnneeDeSortie(2020);
//        album.setPrix(21.5f);
//
//        albumRepository.insert(album);
//
//
//        return "index";
//    }


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
            value =  "/listeArtist",
            method = RequestMethod.POST
    )
    public String pageListeArtist(Model model) {


        return "listeArtist";
    }

    @RequestMapping(
            value =  "/listeClient",
            method = RequestMethod.POST
    )
    public String pageListeClient(Model model) {


        return "listeClient";
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
