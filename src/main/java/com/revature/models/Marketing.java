package com.revature.models;

import lombok.*;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "marketing")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Marketing {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "marketing_id")
    private Integer marketingId;

    @Column(name = "product_category")
    private String productCategory;

    private Integer qty;

    @Column(name = "order_date")
    private Timestamp orderDate;

    private String country;

    private String city;

    @Column(name = "time_of_day")
    private Integer timeOfDay;

    private Integer months;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marketing marketing = (Marketing) o;
        return Objects.equals(marketingId, marketing.marketingId) && Objects.equals(productCategory, marketing.productCategory) && Objects.equals(qty, marketing.qty) && Objects.equals(orderDate, marketing.orderDate) && Objects.equals(country, marketing.country) && Objects.equals(city, marketing.city) && Objects.equals(timeOfDay, marketing.timeOfDay) && Objects.equals(months, marketing.months);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marketingId, productCategory, qty, orderDate, country, city, timeOfDay, months);
    }

    public Integer getMarketingId() {
        return marketingId;
    }

    public void setMarketingId(Integer marketingId) {
        this.marketingId = marketingId;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(Integer timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        this.months = months;
    }

    @Override
    public String toString() {
        return "Marketing{" +
                "marketingId=" + marketingId +
                ", productCategory='" + productCategory + '\'' +
                ", qty=" + qty +
                ", orderDate=" + orderDate +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", timeOfDay=" + timeOfDay +
                ", months=" + months +
                '}';
    }
}
