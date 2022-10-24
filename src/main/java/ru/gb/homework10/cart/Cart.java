package ru.gb.homework10.cart;

import org.springframework.stereotype.Component;
import ru.gb.homework10.dto.CartPositionDto;
import ru.gb.homework10.dto.ProductDto;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {
    List<CartPosition> cart=new ArrayList<>();
    private int idCart;

    public List<CartPositionDto> getAllPosition(){
        List <CartPositionDto> list=new ArrayList<>();
        for (CartPosition c:cart){
            list.add(new CartPositionDto(c.getId(),c.getTitle(),c.getPrice(),c.getAmount()));
        }
        return list;
    }

    public void addPositionToCart(ProductDto productDto){
        boolean flag=true;
        if (!cart.isEmpty()){
            for (int i=0;i<cart.size();i++){
                if (cart.get(i).getId()==productDto.getId()){
                    cart.get(i).setAmount(cart.get(i).getAmount()+1);
                    flag=false;;
                }
            }
        }
        if (flag || cart.isEmpty()){
            cart.add(new CartPosition(productDto.getId(),productDto.getTitle(),productDto.getPrice(),1));
        }
    }

    public void deletePositionFromCartByIdProduct(Long id){
        if (!cart.isEmpty()){
            for(int i=0; i<cart.size();i++){
                if (cart.get(i).getId()==id){
                    cart.remove(i);
                    break;
                }
            }
        }
    }

    public void clearCart(){
        if (!cart.isEmpty()){
            cart.clear();
        }
    }
}
