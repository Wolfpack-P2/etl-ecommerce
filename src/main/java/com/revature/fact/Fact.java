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
    private Order order;

    @ManyToOne
    @JoinColumn(name="customer_name")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="product_name")
    private Product product;

    @Column(name="price")
    private BigDecimal price;

    @OneToOne
    @JoinColumn(name="payment_txn_id")
    private Payment payment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Fact{" +
                "id=" + id +
                ", order=" + order +
                ", customer=" + customer +
                ", product=" + product +
                ", price=" + price +
                ", payment=" + payment +
                '}';
    }
}
