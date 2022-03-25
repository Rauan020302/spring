package spring.test.mockito.demo.service;

import spring.test.mockito.demo.model.Product;

import java.util.List;

public interface ProductService {
    Product create(Product product);
    List<Product> getProducts();
    void deleteProduct(Long id);
    Product updateProduct(Product product,Long id);
    Product getProductById(Long id);

}
