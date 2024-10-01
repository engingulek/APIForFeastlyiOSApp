package com.example.apiForFeastly.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "restaurants")
public class Restaurant {
    @Id
    private String id;

    private String name;

    private List<String> kitchens;

    private String imageUrl;

    private Double latitude;

    private Double longitude;

    private int minWage;
    private int service;
    private  int flavor;

   private List<Menu> menus;
}
