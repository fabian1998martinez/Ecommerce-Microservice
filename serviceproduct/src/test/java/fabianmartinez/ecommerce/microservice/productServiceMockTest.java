package fabianmartinez.ecommerce.microservice;

import fabianmartinez.ecommerce.microservice.entity.Category;
import fabianmartinez.ecommerce.microservice.entity.Product;
import fabianmartinez.ecommerce.microservice.repository.ProductRepository;
import fabianmartinez.ecommerce.microservice.service.ProductService;
import fabianmartinez.ecommerce.microservice.service.ProductServiceImp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class productServiceMockTest {
    @Mock
    private ProductRepository productRepository;

    private ProductService productService;
    @BeforeEach
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        productService = new ProductServiceImp(productRepository);

        Product computer = Product.builder()
                .id(1L)
                .name("computer")
                .category(Category.builder().id(1L).build())
                .price(Double.parseDouble("12.3"))
                .stock(Double.parseDouble("5"))
                .build();
        Mockito.when(productRepository.findById(1L))
                .thenReturn(Optional.of(computer));
        Mockito.when(productRepository.save(computer)).thenReturn(computer);

    }
    @Test
    public void wheValidGetIdID_TheReturnProduct(){
        Product found = productService.getProduct(1L);
        Assertions.assertThat(found.getName()).isEqualTo("computer");

    }
    public void whenValidUpdateStock_ThenReturnNewStock(){

        Product newStock = productService.upDateStock(1L,Double.parseDouble("@"));
        Assertions.assertThat(newStock.getStock()).isEqualTo(13);
    }
}
