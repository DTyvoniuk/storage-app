package com.example.demo.service;

import java.util.List;
import com.example.demo.dto.request.FruitRequestDto;
import com.example.demo.dto.request.FruitRequestDtoWithPrice;
import com.example.demo.model.Fruit;

public interface FruitService {
    List<Fruit> getAll();

    Fruit getByName(String name);

    Fruit save(Fruit fruit);
}
