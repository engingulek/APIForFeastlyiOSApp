package com.example.apiForFeastly.business.concretes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.apiForFeastly.business.abstracts.RestaurantService;
import com.example.apiForFeastly.core.mapper.ModelMapperService;
import com.example.apiForFeastly.core.response.GetKitchenForRestaurant;
import com.example.apiForFeastly.core.response.GetRestaurantResponse;
import com.example.apiForFeastly.core.results.Result;
import com.example.apiForFeastly.core.results.SuccessDataResult;
import com.example.apiForFeastly.dataAccess.KitchenRepository;
import com.example.apiForFeastly.dataAccess.RestaurantRepository;
import com.example.apiForFeastly.entity.Kitchen;
import com.example.apiForFeastly.entity.Restaurant;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantManager implements RestaurantService {

    @Autowired
    private  RestaurantRepository restaurantRepository;
    @Autowired 
    private KitchenRepository kitchenRepository;
    @Autowired
    private ModelMapperService modelMapperService;
    
    
    @Override
    public ResponseEntity<Result> findAll() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        
        List<GetRestaurantResponse> getRestaurantResponses = restaurants.stream().map(restaurant -> {
            List<Kitchen> kitchens = kitchenRepository.findByIdIn(restaurant.getKitchens());
            List<GetKitchenForRestaurant> getKitchenResponses = kitchens.stream()
            .map(item -> this.modelMapperService.forResponse()
            .map(item, GetKitchenForRestaurant.class)).collect(Collectors.toList());
        
            return new GetRestaurantResponse(
                restaurant.getId(),
                restaurant.getName(),
                getKitchenResponses,
                restaurant.getImageUrl(),
                restaurant.getLatitude(),
                restaurant.getLongitude(),
                restaurant.getMinWage());
        }).collect(Collectors.toList());


        return  ResponseEntity.ok(new SuccessDataResult<>(getRestaurantResponses,true,"fetch success"));
        
       
    }



    @Override
    public ResponseEntity<Result> restaurantFilterByKitchen(List<String> selectedList) {
        List<Restaurant> restaurants = new ArrayList<>();
       // List<Restaurant> restaurantsa = restaurantRepository.findByKitchensContaining("66f70bca6313bb4e20c90206");
       selectedList.forEach(id -> {
            Restaurant result = restaurantRepository.findByKitchensContaining(id).getFirst();
            restaurants.add(result);
        });
       
        List<GetRestaurantResponse> getRestaurantResponses = restaurants.stream().map(restaurant -> {
            List<Kitchen> kitchens = kitchenRepository.findByIdIn(restaurant.getKitchens());
            List<GetKitchenForRestaurant> getKitchenResponses = kitchens.stream()
            .map(item -> this.modelMapperService.forResponse()
            .map(item, GetKitchenForRestaurant.class)).collect(Collectors.toList());
        
            return new GetRestaurantResponse(
                restaurant.getId(),
                restaurant.getName(),
                getKitchenResponses,
                restaurant.getImageUrl(),
                restaurant.getLatitude(),
                restaurant.getLongitude(),
                restaurant.getMinWage());
        }).collect(Collectors.toList());

        Set<GetRestaurantResponse> resultSet = new HashSet<>(getRestaurantResponses);
        List<GetRestaurantResponse> resultList = new ArrayList<>(resultSet);
        return  ResponseEntity.ok(new SuccessDataResult<>(resultList,true,"fetch success"));
    }

  

   

}
