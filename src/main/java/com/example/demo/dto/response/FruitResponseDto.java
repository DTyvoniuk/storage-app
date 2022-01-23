package com.example.demo.dto.response;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FruitResponseDto {
    private Long id;
    private String name;
    private Long quantity;
    private BigDecimal price;
}
