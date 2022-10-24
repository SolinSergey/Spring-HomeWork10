package ru.gb.homework10.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.homework10.dto.ProductDto;
import ru.gb.homework10.entities.Product;
import ru.gb.homework10.repositories.ProductRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductService() {
    }

    public List<ProductDto> findAll() {
        List<Product> productList=productRepository.findAll();
        List<ProductDto> products=new ArrayList<>();
        for(Product p:productList){
            products.add(new ProductDto(p.getId(),p.getTitle(),p.getPrice()));
        }
        return products;
    }

    public ProductDto findById(Long id) {
        Product product=null;
        if (productRepository.findById(id).isPresent()){
            product=productRepository.findById(id).get();
        }
        ProductDto productDto=new ProductDto(product.getId(),product.getTitle(),product.getPrice());
        return productDto;
    }


    public void addProduct(ProductDto product) {
        Product product1=new Product();
        product1.setPrice(product.getPrice());
        product1.setTitle(product.getTitle());
        productRepository.save(product1);
    }

    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findProductByMoreMaxPrice(int maxPrice){
        return productRepository.findAllByMoreMaxPrice(maxPrice);
    }

    public List<Product> findProductByLessMaxPrice(int maxPrice){
        return productRepository.findAllByLessMaxPrice(maxPrice);
    }

    public List<Product> findProductByPriceBetween(int minPrice, int maxPrice){
        return productRepository.findProductByPriceBetween(minPrice,maxPrice);
    }

    public void saveProduct (Product product){
        productRepository.save(product);
    }
}
