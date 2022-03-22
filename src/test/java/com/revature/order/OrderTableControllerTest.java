package com.revature.order;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTableControllerTest {

    @Autowired
    private OrderController orderTableController;

    @Test
    public void testGetAllOrders() {
        List<Order> orders = orderTableController.getAllOrders();
        for (Order order : orders) {
            assert order.getOrderId() != null;
            assert order.getProductName() != null;
            assert order.getEcomWeb() != null;
            assert order.getOrderDate() != null;
            assert order.getPrice() != null;
            assert order.getQty() != null;
        }
    }
}
