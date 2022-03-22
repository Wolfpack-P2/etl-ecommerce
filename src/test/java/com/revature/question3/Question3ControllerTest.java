package com.revature.question3;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Question3ControllerTest {

    @Autowired
    Question3Controller question3Controller;

    @Test
    public void testGetAllQuestion() {
        List<Question3> question3s = question3Controller.getAllQuestion();
        for (Question3 q : question3s) {
            assert q.getPaymentTxnId() != null;
            assert q.getPrice() != null;
            assert q.getQty() != null;
            assert q.getPaymentTxnSuccess() != null;
        }
    }
}
