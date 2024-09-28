package com.example.apiForFeastly.dataAccess;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.apiForFeastly.entity.Kitchen;

public interface KitchenRepository extends  MongoRepository<Kitchen, String> {
    
}
