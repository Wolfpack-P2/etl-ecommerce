package com.revature.models;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "research")
@NoArgsConstructor
@AllArgsConstructor
//@Setter
//@Getter
@Data
public class Research {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "research_id")
    private Integer researchId;

    private Integer qty;

    @Column(name = "order_date")
    private Timestamp orderDate;

    @Column(name = "payment_txn_success")
    private String paymentTxnSuccess;
    
    private String country;
    
    @Column(name = "total_price")
    private BigDecimal totalPrice;
    // Maybe: just the price, not counting the quantity

    @Column(name = "day_of_week")
    private Double dayOfWeek;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Research research = (Research) o;
        return Objects.equals(researchId, research.researchId) && Objects.equals(qty, research.qty) && Objects.equals(orderDate, research.orderDate) && Objects.equals(paymentTxnSuccess, research.paymentTxnSuccess) && Objects.equals(country, research.country) && Objects.equals(totalPrice, research.totalPrice) && Objects.equals(dayOfWeek, research.dayOfWeek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(researchId, qty, orderDate, paymentTxnSuccess, country, totalPrice, dayOfWeek);
    }

    public Integer getResearchId() {
        return researchId;
    }

    public void setResearchId(Integer researchId) {
        this.researchId = researchId;
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

    public String getPaymentTxnSuccess() {
        return paymentTxnSuccess;
    }

    public void setPaymentTxnSuccess(String paymentTxnSuccess) {
        this.paymentTxnSuccess = paymentTxnSuccess;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Double dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public String toString() {
        return "Research{" +
                "researchId=" + researchId +
                ", qty=" + qty +
                ", orderDate=" + orderDate +
                ", paymentTxnSuccess='" + paymentTxnSuccess + '\'' +
                ", country='" + country + '\'' +
                ", totalPrice=" + totalPrice +
                ", dayOfWeek=" + dayOfWeek +
                '}';
    }
}