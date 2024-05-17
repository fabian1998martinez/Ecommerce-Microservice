package fabianmartinez.ecommerce.microservice.controller;

import fabianmartinez.ecommerce.microservice.entity.Category;
import fabianmartinez.ecommerce.microservice.entity.Product;
import fabianmartinez.ecommerce.microservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<Product>> listProduct(@RequestParam(name="categoryId",required = false) Long categotyId){

        List<Product> products = new ArrayList<>();
        if(categotyId == null){
            products = productService.listAllProduct();
           if(products.isEmpty()){
               return ResponseEntity.noContent().build();
           }
        }else {
            products = productService.findByCategory(Category.builder().id(categotyId).build());
            if(products.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.ok(products);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> get_Product(@PathVariable("id") Long id){
         Product product = productService.getProduct(id);
         if(product == null){
             return ResponseEntity.noContent().build();
         }
        return ResponseEntity.ok(product);
    }
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product  createProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createProduct);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id,@RequestBody Product product){
        product.setId(id);
        Product productBd = productService.upDateProduct(product);
        if(productBd == null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productBd);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id){

        Product productDelete = productService.deleteProduct(id);

        if(productDelete == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productDelete);
    }
    @PutMapping(value = "/{id}/stock")
    public ResponseEntity<Product> updateStockProduct(@PathVariable Long id ,@RequestParam(name = "quantity",required = true) double quantity){

        Product product = productService.upDateStock(id,quantity);
        if (product == null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

}
