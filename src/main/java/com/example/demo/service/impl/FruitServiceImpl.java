package com.example.demo.service.impl;

import java.util.List;
import com.example.demo.model.Fruit;
import org.springframework.stereotype.Service;
import com.example.demo.repository.FruitRepository;
import com.example.demo.service.FruitService;

@Service
public class FruitServiceImpl implements FruitService {
    private final FruitRepository fruitRepository;

    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public List<Fruit> getAll() {
        return fruitRepository.findAll();
    }

    @Override
    public Fruit getByName(String name) {
        return fruitRepository.getFruitsByName(name);
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }


}
