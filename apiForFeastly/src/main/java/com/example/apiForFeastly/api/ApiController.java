package com.example.apiForFeastly.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiForFeastly.business.abstracts.KitchenService;
import com.example.apiForFeastly.core.results.Result;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("api/feastly/")
@AllArgsConstructor
@NoArgsConstructor
public class ApiController {
    @Autowired
    private  KitchenService kitchenService;

    @GetMapping("kitchen/getAll")
    public ResponseEntity<Result> kitchenFindAll(){
        return  kitchenService.findAll();
    }
}
