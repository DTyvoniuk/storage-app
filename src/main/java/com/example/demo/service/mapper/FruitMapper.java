package com.example.demo.service.mapper;

import com.example.demo.dto.request.FruitRequestDtoWithPrice;
import com.example.demo.dto.response.FruitResponseDto;
import com.example.demo.model.Fruit;
import org.springframework.stereotype.Component;

@Component
public class FruitMapper {
    public FruitResponseDto parseToDto(Fruit fruit) {
        FruitResponseDto responseDto = new FruitResponseDto();
        responseDto.setId(fruit.getId());
        responseDto.setName(fruit.getName());
        responseDto.setQuantity(fruit.getQuantity());
        responseDto.setPrice(fruit.getPrice());
        return responseDto;
    }

    public Fruit parseToModel(FruitRequestDtoWithPrice requestDto) {
        Fruit fruit  = new Fruit();
        fruit.setName(requestDto.getName());
        fruit.setQuantity(requestDto.getQuantity());
        fruit.setPrice(requestDto.getPrice());
        return fruit;
    }
}
