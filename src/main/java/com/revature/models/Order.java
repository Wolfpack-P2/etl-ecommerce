package com.revature.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity 
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer order_id;
    private Integer customer_id;
    private String customer_name;
    private Integer product_id;
    private String product_name;
    private String product_category;
    private String payment_type;
    private Integer qty;
    private Double price;
    private Timestamp datetime;
    private String country;
    private String city;
    private String ecommerce_website_name;
    private Character payment_txn_success;
    private String failure_reason;

    @Transient
    private int count;

}

