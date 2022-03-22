package com.revature.product;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductControllerTest {

    @Autowired
    ProductController productController;

    @Test
    public void testGetAllProducts() {
        List<Product> products = productController.getAllProducts();
        for (Product product : products) {
            assert product.getProductName() != null;
            assert product.getProductCategory() != null;
            assert product.getAveragePrice() != null;
        }
    }
}
