package com.example.demo.controller;

import com.example.demo.dto.request.FruitRequestDtoWithPrice;
import com.example.demo.dto.response.FruitResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.FruitService;
import com.example.demo.service.mapper.FruitMapper;

@RestController
@RequestMapping("/fruits")
public class FruitController {
    private final FruitService fruitService;
    private final FruitMapper fruitMapper;

    public FruitController(FruitService fruitService, FruitMapper fruitMapper) {
        this.fruitService = fruitService;
        this.fruitMapper = fruitMapper;
    }

    @PostMapping
    public FruitResponseDto add(@RequestBody FruitRequestDtoWithPrice fruit) {
        return fruitMapper.parseToDto(fruitService
                .save(fruitMapper.parseToModel(fruit)));
    }

    @GetMapping("/{name}")
    public FruitResponseDto getInfo(@PathVariable(value = "name") String name) {
        try {
            return fruitMapper.parseToDto(fruitService.getByName(name));
        } catch (Exception e) {
            throw new RuntimeException("Can't get fruit by name " + name, e);
        }
    }
}
