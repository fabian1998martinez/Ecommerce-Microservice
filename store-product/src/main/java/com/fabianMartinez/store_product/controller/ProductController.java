package com.fabianMartinez.store_product.controller;


import com.fabianMartinez.store_product.entity.Category;
import com.fabianMartinez.store_product.entity.Product;
import com.fabianMartinez.store_product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> listProducts(@RequestParam(name = "category",required = false) Long categoryId){

        List<Product> products = new ArrayList<>();
        if (null == categoryId){
            products = productService.listAllProduct();
            if (products.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }else {
            products = productService.findByCategory(Category.builder().id(categoryId).build());
            if (products.isEmpty()){
                return ResponseEntity.notFound().build();
            }
        }
     return ResponseEntity.ok(products);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id){
        Product productDb = productService.getProduct(id);
        if (null == productDb){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productDb);
    }

    @PostMapping()
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product createProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createProduct);

    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Product> upDateProduct( @PathVariable("id") Long id, @RequestBody Product product){
        product.setId(id);
        Product productBd = productService.upDateProduct(product);
        if(null == productBd){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productBd);
    }
    @DeleteMapping(value = "{/id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id){
        Product productBd = productService.deleteProduct(id);
        if(null==productBd){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productBd);
    }
    @GetMapping(value = "/{id}/stock")
    public ResponseEntity<Product> upDateStockProduct(@PathVariable("id") Long id , @RequestParam(name = "quantity",required = true) Double quantity){
       Product productBd = productService.upDateStock(id,quantity);
       if(null == productBd){
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(productBd);
    }

}
