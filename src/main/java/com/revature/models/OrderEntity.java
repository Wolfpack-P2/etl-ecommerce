package com.revature.models;

import lombok.*;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "order_table")
@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
@Data
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
    private Integer qty;

    @Column(name="payment_txn_id")
    private Integer paymentTxnId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getEcomWeb() {
        return ecomWeb;
    }

    public void setEcomWeb(String ecomWeb) {
        this.ecomWeb = ecomWeb;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(productName, that.productName) && Objects.equals(ecomWeb, that.ecomWeb) && Objects.equals(orderDate, that.orderDate) && Objects.equals(price, that.price) && Objects.equals(qty, that.qty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, productName, ecomWeb, orderDate, price, qty);
    }
}
