package com.example.dummyjson.service;

import com.example.dummyjson.dto.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void testGetAllProducts() {
        List<Product> products = productService.getAllProducts();
        assertNotNull(products, "Products list should not be null");
        
        // Atualize a expectativa de acordo com o que é retornado pela API real
        assertEquals(1, products.size(), "Expected size of the products list is 1");
    }

    @Test
    public void testGetProductById() {
        Product product = productService.getProductById(1L);
        assertNotNull(product, "Product should not be null");
        
        // Atualize a expectativa de acordo com o título real do produto retornado
        assertEquals("Essence Mascara Lash Princess", product.getTitle(), "Expected product title is 'Essence Mascara Lash Princess'");
    }
}
