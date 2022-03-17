package com.revature.models;

import lombok.*;

import javax.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "order_table")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "ecommerce_website_name")
    private String ecomWeb;

    @Column(name = "order_date")
    private Timestamp orderDate;

    @Column(name = "price")
    private Double price;

    @Column(name="qty")
    private int qty;

    @Override
    public String toString() {
        return "OrderEntity{" +
                "orderId=" + orderId +
                ", productName='" + productName + '\'' +
                ", ecomWeb='" + ecomWeb + '\'' +
                ", orderDate=" + orderDate +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }
}
