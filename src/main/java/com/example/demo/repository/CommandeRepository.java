package com.example.demo.repository;


import com.example.demo.entity.Commande;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommandeRepository extends MongoRepository<Commande,Long> {





}
