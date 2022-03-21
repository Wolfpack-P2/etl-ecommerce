package com.revature.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="fact_table1")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FactEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @OneToOne
    @JoinColumn(name="order_id")
    private OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn(name="customer_name")
    private CustomerEntity customerEntity;

    @ManyToOne
    @JoinColumn(name="product_name")
    private ProductEntity productEntity;

    @Column(name="price")
    private BigDecimal price;

    @OneToOne
    @JoinColumn(name="payment_txn_id")
    private PaymentEntity paymentEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public PaymentEntity getPaymentEntity() {
        return paymentEntity;
    }

    public void setPaymentEntity(PaymentEntity paymentEntity) {
        this.paymentEntity = paymentEntity;
    }

    @Override
    public String toString() {
        return "FactEntity{" +
                "id=" + id +
                ", orderEntity=" + orderEntity +
                ", customerEntity=" + customerEntity +
                ", productEntity=" + productEntity +
                ", price=" + price +
                ", paymentEntity=" + paymentEntity +
                '}';
    }
}
