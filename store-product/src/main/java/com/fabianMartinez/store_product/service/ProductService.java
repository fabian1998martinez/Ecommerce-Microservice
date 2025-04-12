package com.fabianMartinez.store_product.service;

import com.fabianMartinez.store_product.entity.Category;
import com.fabianMartinez.store_product.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> listAllProduct();
    public Product getProduct(Long id);

    public Product createProduct(Product product);
    public Product upDateProduct(Product product);
    public Product deleteProduct(Long id);

    public List<Product> findByCategory(Category category);
    public Product upDateStock(Long id,Double quantity);

}
