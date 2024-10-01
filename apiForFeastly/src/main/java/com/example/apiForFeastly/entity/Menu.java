package com.example.apiForFeastly.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    @Id
    private String id;
    private String imageUrl;
    private String name;
    private String description;
    private Double price;
}
