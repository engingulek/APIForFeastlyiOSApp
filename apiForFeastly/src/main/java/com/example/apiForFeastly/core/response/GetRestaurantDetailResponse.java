package com.example.apiForFeastly.core.response;
import java.util.List;

import com.example.apiForFeastly.entity.Menu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetRestaurantDetailResponse {
    private String id;
    private String name;
    private List<GetKitchenForRestaurant> kitchens;
    private String imageUrl;

    private Double latitude;

    private Double longitude;

    private int minWage;

    private List<Menu> menus;
}
