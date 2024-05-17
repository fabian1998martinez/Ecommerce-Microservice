package fabianmartinez.ecommerce.microservice.service;

import fabianmartinez.ecommerce.microservice.entity.Category;
import fabianmartinez.ecommerce.microservice.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    public List<Product> listAllProduct();
    public Product getProduct(Long id);
    public Product createProduct(Product product);
    public Product upDateProduct(Product product);
    public Product deleteProduct(Long id);
    public List<Product> findByCategory(Category category);
    public Product upDateStock(Long id , Double quantity);

}
