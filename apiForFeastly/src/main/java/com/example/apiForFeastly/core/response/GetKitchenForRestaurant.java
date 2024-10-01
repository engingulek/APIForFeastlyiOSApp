package com.example.apiForFeastly.core.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetKitchenForRestaurant {
    private String id;
    private String name;
}
