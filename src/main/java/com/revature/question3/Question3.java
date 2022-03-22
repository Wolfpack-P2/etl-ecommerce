package com.revature.question3;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name = "researchq3")
public class Question3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_txn_id")
    private Integer paymentTxnId;
    
    private Double price;

    private Integer qty;

    @Column(name = "payment_txn_success")
    private String paymentTxnSuccess;

    // No args constructor
    public Question3() {
        super();
    }

    // All args constructor
    public Question3(Integer paymentTxnId, Double price, Integer qty, String paymentTxnSuccess) {
        this.paymentTxnId = paymentTxnId;
        this.price = price;
        this.qty = qty;
        this.paymentTxnSuccess = paymentTxnSuccess;
    }

    // Getters and setters
    public Integer getPaymentTxnId() {
        return paymentTxnId;
    }

    public void setPaymentTxnId(Integer paymentTxnId) {
        this.paymentTxnId = paymentTxnId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getPaymentTxnSuccess() {
        return paymentTxnSuccess;
    }

    public void setPaymentTxnSuccess(String paymentTxnSuccess) {
        this.paymentTxnSuccess = paymentTxnSuccess;
    }

    // toString
    @Override
    public String toString() {
        return "Question3 [paymentTxnId=" + paymentTxnId + ", price=" + price + ", qty=" + qty + ", paymentTxnSuccess=" + paymentTxnSuccess + "]";
    }
}
