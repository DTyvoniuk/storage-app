package com.example.demo.dto.request;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FruitRequestDtoWithPrice {
    private String name;
    private Long quantity;
    private BigDecimal price;
}
