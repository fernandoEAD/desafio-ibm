package com.example.dummyjson.controller;

import com.example.dummyjson.dto.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetAllProducts() {
        ResponseEntity<Product[]> response = restTemplate.getForEntity("/api/products", Product[].class);
        Product[] products = response.getBody();

        assertNotNull(products, "Products should not be null");
        
        // Atualize a expectativa de acordo com o que é retornado pela API real
        assertEquals(1, products.length, "Expected size of the products list is 1");
    }

    @Test
    public void testGetProductById() {
        ResponseEntity<Product> response = restTemplate.getForEntity("/api/products/1", Product.class);
        Product product = response.getBody();

        assertNotNull(product, "Product should not be null");
        
        // Atualize a expectativa de acordo com o título real do produto retornado
        assertEquals("Essence Mascara Lash Princess", product.getTitle(), "Expected product title is 'Essence Mascara Lash Princess'");
    }
}
