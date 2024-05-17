package fabianmartinez.ecommerce.microservice.service;

import fabianmartinez.ecommerce.microservice.entity.Category;
import fabianmartinez.ecommerce.microservice.entity.Product;
import fabianmartinez.ecommerce.microservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@RequiredArgsConstructor
@Service
public class ProductServiceImp implements ProductService {


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
        product.setStatus("CREATED");
        product.setCreateAt(new Date());
        return productRepository.save(product);
    }

    @Override
    public Product upDateProduct(Product product) {
        Product product1 = getProduct(product.getId());
        if(product1==null){
            return null;
        }
        product1.setName(product.getName());
        product1.setDescription(product.getDescription());
        product1.setCategory(product.getCategory());
        product1.setPrice(product.getPrice());

        return productRepository.save(product1) ;
    }

    @Override
    public Product deleteProduct(Long id) {
        Product product1 = getProduct(id);
        if(product1==null){
            return null;
        }
        product1.setStatus("DELETED");
        return productRepository.save(product1);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public Product upDateStock(Long id, Double quantity) {
        Product product01 = getProduct(id);
        if(product01 == null){
            return null;
        }
         double stock = product01.getStock() + quantity;
        product01.setStock(stock);
        return productRepository.save(product01);
    }
}
