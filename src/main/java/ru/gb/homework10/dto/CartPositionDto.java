package ru.gb.homework10.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.homework10.dto.ProductDto;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartPositionDto {
    private Long id;
    private String title;
    private int price;
    private int amount;
}
