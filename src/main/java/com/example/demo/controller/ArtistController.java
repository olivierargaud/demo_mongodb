package com.example.demo.controller;

import com.example.demo.entity.Artist;
import com.example.demo.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/artists")
public class ArtistController {


    @Autowired
    ArtistRepository artistRepository;


    @RequestMapping(
            value = "/list",
            method = RequestMethod.POST
    )
    public String recherche
            (
                    final ModelMap model ,
                    @RequestParam (defaultValue = "0")      Integer page,
                    @RequestParam (defaultValue = "10")     Integer size,
                    @RequestParam (defaultValue = "nom")    String sortProperty,
                    @RequestParam (defaultValue = "ASC")    String sortDirection

            )
    {

        PageRequest pageRequest = PageRequest.of(page,size, Sort.Direction.fromString(sortDirection),sortProperty);

        Page<Artist> artistPage = artistRepository.findAll(pageRequest);

        model.put("listeArtist",artistPage);

        return "listeArtist";
    }





}
