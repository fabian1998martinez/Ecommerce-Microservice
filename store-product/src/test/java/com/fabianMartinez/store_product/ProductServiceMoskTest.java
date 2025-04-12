package com.fabianMartinez.store_product;


import com.fabianMartinez.store_product.entity.Category;
import com.fabianMartinez.store_product.entity.Product;
import com.fabianMartinez.store_product.repository.ProductRepository;
import com.fabianMartinez.store_product.service.ProductService;
import com.fabianMartinez.store_product.service.ProductServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ProductServiceMoskTest {

    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        productService = new ProductServiceImp(productRepository);
        Product computer =Product.builder()
                .id(1l)
                .name("computer")
                .category(Category.builder().id(1l).build())
                .price(Double.parseDouble("12.50"))
                .stock(Double.parseDouble("5"))
                .build();
        Mockito.when(productRepository.findById(1l))
                .thenReturn(Optional.of(computer));
        Mockito.when(productRepository.save(computer)).thenReturn(computer);
    }

    @Test
    public void whenValidgetId_thenReturnProduct(){

        Product found = productService.getProduct(1l);
        Assertions.assertTrue(found.getName().equals("computer"));
    }
    @Test
    public void whenValidUpdateStock_thenReturnNewStock(){
      Product newStock = productService.upDateStock(1l,Double.parseDouble("8"));

        Assertions.assertEquals(13.0,newStock.getStock());
    }

}
