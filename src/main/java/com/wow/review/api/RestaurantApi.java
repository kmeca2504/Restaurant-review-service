package com.wow.review.api;

import com.wow.review.api.request.CreateAndEditRestaurantRequest;
import com.wow.review.api.response.RestaurantDetailView;
import com.wow.review.api.response.RestaurantView;
import com.wow.review.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantApi {

    private  final RestaurantService restaurantService;
    @GetMapping("/restaurants")
    public  List<RestaurantView> getRestaurants(){
        return restaurantService.getAllRestaurants();
    }
    @GetMapping("/restaurant/{restaurantId}")
    public RestaurantDetailView getRestaurant(
            @PathVariable Long restaurantId
    ){
        return restaurantService.getRestaurantDetail(restaurantId);
    }

    @PostMapping("/restaurant")
    public void createRestaurant(
            @RequestBody CreateAndEditRestaurantRequest request
            ){
      restaurantService.createRestaurant(request);
    }

    @PutMapping("/restaurant/{restaurantId}")
    public void editRestaurant(
            @PathVariable Long restaurantId,
            @RequestBody CreateAndEditRestaurantRequest request
    ){
        restaurantService.editRestaurant(restaurantId,request);
    }

    @DeleteMapping("/restaurant/{restaurantId}")
    public void deleteRestaruant(
            @PathVariable Long restaurantId
    ){
        restaurantService.deleteRestaurant(restaurantId);
    }
}
