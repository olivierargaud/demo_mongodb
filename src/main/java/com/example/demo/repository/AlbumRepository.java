package com.example.demo.repository;

import com.example.demo.entity.Album;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface AlbumRepository extends MongoRepository<Album,Long> {


    Optional<Album> findById(String album_id);

    ArrayList<Album> findAllByOrderByAnneeDeSortieAsc();

}
