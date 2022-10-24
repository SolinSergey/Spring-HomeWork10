package ru.gb.homework10.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.homework10.dto.ProductDto;
import ru.gb.homework10.entities.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartPosition {
    private Long id;
    private String title;
    private int price;
    private int amount;
}
