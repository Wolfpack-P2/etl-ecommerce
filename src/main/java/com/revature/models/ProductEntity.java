package com.revature.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="product_table")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_name")
    private String productName;

    @Column(name="product_category")
    private String productCategory;

    @Column(name="average_price")
    private Double averagePrice;

    @Override
    public String toString() {
        return "ProductEntity{" +
                "productName='" + productName + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", averagePrice=" + averagePrice +
                '}';
    }
}
