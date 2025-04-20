package com.fabianMartinez.store_product.service;

import com.fabianMartinez.store_product.entity.Category;
import com.fabianMartinez.store_product.entity.Product;
import com.fabianMartinez.store_product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService{



   private final ProductRepository productRepository;


    @Override
    public List<Product> listAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        product.setStatus("Create");
        product.setCreateAt(new Date());
        return productRepository.save(product);
    }

    @Override
    public Product upDateProduct(Product product) {
        Product productBd = getProduct(product.getId());
        if(null == productBd){
            return null;
        }
        productBd.setName(product.getName());
        productBd.setPrice(product.getPrice());
        productBd.setCategory(product.getCategory());
        productBd.setDescription(product.getDescription());
        return productRepository.save(productBd);
    }

    @Override
    public Product deleteProduct(Long id) {
        Product productBd = getProduct(id);
        if (null == productBd){
            return null;
        }
        productBd.setStatus("DELETE");
        return productRepository.save(productBd) ;
    }

    @Override
    public List<Product> findByCategory(Category category) {

        return productRepository.findByCategory(category);
    }

    @Override
    public Product upDateStock(Long id, Double quantity) {
        Product productBd = getProduct(id);
        if (null == productBd){
            return null;
        }
        Double stock = productBd.getStock() + quantity;
        productBd.setStock(stock);
        return productRepository.save(productBd);
    }
}
