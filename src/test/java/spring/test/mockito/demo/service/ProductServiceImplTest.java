package spring.test.mockito.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import spring.test.mockito.demo.model.Product;
import spring.test.mockito.demo.repository.ProductRepo;
import spring.test.mockito.demo.test.SpringUnitTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ProductServiceImplTest extends SpringUnitTest {
    @InjectMocks
    ProductServiceImpl productService;

    @Mock
    Product product;

    @Mock
    ProductRepo productRepo;

    @BeforeEach
    public void init(){
        Mockito.when(product.getId()).thenReturn(1L);
        Mockito.when(product.getProductName()).thenReturn("T-Shirt");
        Mockito.when(product.getProductPrice()).thenReturn(500.00);
        Mockito.when(product.getProductCategory()).thenReturn("Clothing");
    }
    @Test
    public void testCreateProduct(){
        Mockito.when(productRepo.save(Mockito.any())).thenReturn(product);
        Product createdItem = productService.create(product);
        assertEquals("T-Shirt",createdItem.getProductName());
    }
    @Test
    public void testGetProducts(){
        Mockito.when(productRepo.findAll()).thenReturn(Arrays.asList(product));

        List<Product> productItems=productService.getProducts();
        assertEquals(1, productItems.size());
    }
    @Test
    public void testUpdateProduct() {
        Mockito.when(product.getProductName()).thenReturn("Shirt");
        Mockito.when(productRepo.save(Mockito.any())).thenReturn(product);

        Product updatedItem=productService.updateProduct(product, product.getId());
        assertEquals("Shirt", updatedItem.getProductName());

    }

    @Test
    @Timeout(value = 1000)
    public void testdeleteProduct() {
        Mockito.doNothing().when(productRepo).delete(Mockito.any());
        Mockito.when(productRepo.findById(1L)).thenReturn(Optional.of(product));
        ProductServiceImpl service=mock(ProductServiceImpl.class);

        service.deleteProduct(1L);
        verify(service).deleteProduct(Mockito.anyLong());

    }

}
