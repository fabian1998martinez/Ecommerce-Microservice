package com.fabianMartinez.store_product;

import com.fabianMartinez.store_product.entity.Category;
import com.fabianMartinez.store_product.entity.Product;
import com.fabianMartinez.store_product.repository.ProductRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
public class ProductRepositoryMoskTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whenFindByCategory_thenResturnListProduct(){
        Product product = Product.builder()
                .name("computer")
                .category(Category.builder().id(1l).build())
                .description("")
                .stock(Double.parseDouble("10"))
                .price(Double.parseDouble("1240.9"))
                .status("Create")
                .createAt(new Date()).build();

        productRepository.save(product);

        List<Product> founds = productRepository.findByCategory(product.getCategory());
        Assertions.assertThat(founds.size()).isEqualTo(3);
    };
}
