package com.example.apiForFeastly.core.mapper;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
 ModelMapper forResponse();
    ModelMapper forRequest();
}
