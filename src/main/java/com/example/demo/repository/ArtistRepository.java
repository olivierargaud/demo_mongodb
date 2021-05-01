package com.example.demo.repository;

import com.example.demo.entity.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArtistRepository extends MongoRepository<Artist,Long> {


    Page<Artist> findArtistByNom(String nom, Pageable pageable);


}
