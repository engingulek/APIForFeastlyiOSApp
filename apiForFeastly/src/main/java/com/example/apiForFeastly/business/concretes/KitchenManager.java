package com.example.apiForFeastly.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.apiForFeastly.business.abstracts.KitchenService;
import com.example.apiForFeastly.core.mapper.ModelMapperService;
import com.example.apiForFeastly.core.response.GetKitchenResponse;
import com.example.apiForFeastly.core.results.Result;
import com.example.apiForFeastly.core.results.SuccessDataResult;
import com.example.apiForFeastly.dataAccess.KitchenRepository;
import com.example.apiForFeastly.entity.Kitchen;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class KitchenManager implements  KitchenService {
    @Autowired
    private KitchenRepository kitchenRepository;
     @Autowired
    private ModelMapperService modelMapperService;
    @Override
    public ResponseEntity<Result> findAll() {
        List<Kitchen> kitches = kitchenRepository.findAll();
        

        List<GetKitchenResponse> getKitchenResponses = kitches.stream().map(item -> this.modelMapperService.forResponse()
        .map(item, GetKitchenResponse.class)).collect(Collectors.toList());

        return  ResponseEntity.ok(new SuccessDataResult<>(getKitchenResponses,true,"fetch success"));
    }
    
}
