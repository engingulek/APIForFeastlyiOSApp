package com.example.apiForFeastly.dataAccess;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.apiForFeastly.entity.Restaurant;



public interface  RestaurantRepository extends MongoRepository<Restaurant,String>  {
     List<Restaurant> findByKitchensContaining(String kitchen);
}
