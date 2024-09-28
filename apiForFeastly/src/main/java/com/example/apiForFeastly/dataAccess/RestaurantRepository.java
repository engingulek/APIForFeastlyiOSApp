package com.example.apiForFeastly.dataAccess;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.apiForFeastly.entity.Restaurant;



public interface  RestaurantRepository extends MongoRepository<Restaurant,String>  {
    
}
