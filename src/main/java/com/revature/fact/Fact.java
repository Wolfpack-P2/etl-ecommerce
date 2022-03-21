package com.revature.fact;

import lombok.*;

import javax.persistence.*;

import com.revature.customer.Customer;
import com.revature.order.Order;
import com.revature.payment.Payment;
import com.revature.product.Product;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="fact_table1")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Fact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @OneToOne
    @JoinColumn(name="order_id")
    private Order orderEntity;

    @ManyToOne
    @JoinColumn(name="customer_name")
    private Customer customerEntity;

    @ManyToOne
    @JoinColumn(name="product_name")
    private Product productEntity;

    @Column(name="price")
    private BigDecimal price;

    @OneToOne
    @JoinColumn(name="payment_txn_id")
    private Payment paymentEntity;

    // No args constructor
    public Fact() {
        super();
    }

    // All args constructor
    public Fact(Order orderEntity, Customer customerEntity, Product productEntity, BigDecimal price, Payment paymentEntity) {
        this.orderEntity = orderEntity;
        this.customerEntity = customerEntity;
        this.productEntity = productEntity;
        this.price = price;
        this.paymentEntity = paymentEntity;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(Order orderEntity) {
        this.orderEntity = orderEntity;
    }

    public Customer getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(Customer customerEntity) {
        this.customerEntity = customerEntity;
    }

    public Product getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(Product productEntity) {
        this.productEntity = productEntity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Payment getPaymentEntity() {
        return paymentEntity;
    }

    public void setPaymentEntity(Payment paymentEntity) {
        this.paymentEntity = paymentEntity;
    }

    // toString
    @Override
    public String toString() {
        return "Fact{" +
                "id=" + id +
                ", orderEntity=" + orderEntity +
                ", customerEntity=" + customerEntity +
                ", productEntity=" + productEntity +
                ", price=" + price +
                ", paymentEntity=" + paymentEntity +
                '}';
    }
}
