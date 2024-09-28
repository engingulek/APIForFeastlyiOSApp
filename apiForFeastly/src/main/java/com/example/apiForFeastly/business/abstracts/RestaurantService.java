package com.example.apiForFeastly.business.abstracts;

import org.springframework.http.ResponseEntity;

import com.example.apiForFeastly.core.results.Result;

public interface RestaurantService {
    ResponseEntity<Result> findAll();
}
