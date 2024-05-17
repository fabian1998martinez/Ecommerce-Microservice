package fabianmartinez.ecommerce.microservice.repository;

import fabianmartinez.ecommerce.microservice.entity.Category;
import fabianmartinez.ecommerce.microservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    public List<Product> findByCategory(Category category);
}
