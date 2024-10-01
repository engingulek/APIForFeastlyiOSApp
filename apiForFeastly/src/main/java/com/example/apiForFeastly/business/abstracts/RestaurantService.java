package com.example.apiForFeastly.business.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.apiForFeastly.core.results.Result;

public interface RestaurantService {
    ResponseEntity<Result> findAll();
    ResponseEntity<Result> restaurantFilterByKitchen(List<String> selectedList);
    ResponseEntity<Result> findRestaurantDetail(String id);
}
