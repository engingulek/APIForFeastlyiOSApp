package com.example.apiForFeastly.dataAccess;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.apiForFeastly.entity.Kitchen;

public interface KitchenRepository extends  MongoRepository<Kitchen, String> {
    List<Kitchen> findByIdIn(List<String> ids);
}
