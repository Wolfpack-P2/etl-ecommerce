package com.revature.product;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="product_table")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_name")
    private String productName;

    @Column(name="product_category")
    private String productCategory;

    @Column(name="average_price")
    private Double averagePrice;

    // No args constructor
    public Product() {
        super();
    }

    // All args constructor
    public Product(String productName, String productCategory, Double averagePrice) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.averagePrice = averagePrice;
    }

    // Getters and setters
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public Double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product that = (Product) o;
        return Objects.equals(productName, that.productName) && Objects.equals(productCategory, that.productCategory) && Objects.equals(averagePrice, that.averagePrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, productCategory, averagePrice);
    }

    // toString
    @Override
    public String toString() {
        return "ProductEntity{" +
                "productName='" + productName + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", averagePrice=" + averagePrice +
                '}';
    }
}
