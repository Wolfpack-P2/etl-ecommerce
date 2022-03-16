package com.revature.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="product_table")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_name")
    private String productName;

    @Column(name="product_category")
    private String productCategory;

    @Column(name="average_price")
    private Double averagePrice;

}
