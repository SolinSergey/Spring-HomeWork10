package ru.gb.homework10.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.homework10.cart.Cart;
import ru.gb.homework10.dto.CartPositionDto;
import ru.gb.homework10.dto.ProductDto;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@AllArgsConstructor
public class CartController {
    private final Cart cart;

    @GetMapping()
    public List<CartPositionDto> showAllPosition() {
        return cart.getAllPosition();
    }

    @PostMapping()
    public ResponseEntity<?> addPositionToCart(@RequestBody ProductDto productDto) {
        cart.addPositionToCart(productDto);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePositionFromCartByIdProduct(@PathVariable Long id) {
        cart.deletePositionFromCartByIdProduct(id);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @DeleteMapping("/clear")
    public ResponseEntity<?> clearCart() {
        cart.clearCart();
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
}
