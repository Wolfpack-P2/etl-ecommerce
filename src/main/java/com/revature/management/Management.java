package com.revature.management;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "management")
public class Management {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "management_id")
    private Integer managementId;

    @Column(name = "payment_type")
    private String paymentType;

    private String country;

    @Column(name = "potential_revenue")
    private BigDecimal potentialRevenue;

    @Column(name = "payment_txn_success")
    private String paymentTxnSuccess;

    // No args constructor
    public Management() {
        super();
    }

    // All args constructor
    public Management(Integer managementId, String paymentType, String country, BigDecimal potentialRevenue, String paymentTxnSuccess) {
        this.managementId = managementId;
        this.paymentType = paymentType;
        this.country = country;
        this.potentialRevenue = potentialRevenue;
        this.paymentTxnSuccess = paymentTxnSuccess;
    }

    // Getters and setters
    public Integer getManagementId() {
        return managementId;
    }

    public void setManagementId(Integer managementId) {
        this.managementId = managementId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getPotentialRevenue() {
        return potentialRevenue;
    }

    public void setPotentialRevenue(BigDecimal potentialRevenue) {
        this.potentialRevenue = potentialRevenue;
    }

    public String getPaymentTxnSuccess() {
        return paymentTxnSuccess;
    }

    public void setPaymentTxnSuccess(String paymentTxnSuccess) {
        this.paymentTxnSuccess = paymentTxnSuccess;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Management that = (Management) o;
        return Objects.equals(managementId, that.managementId) && Objects.equals(paymentType, that.paymentType) && Objects.equals(country, that.country) && Objects.equals(potentialRevenue, that.potentialRevenue) && Objects.equals(paymentTxnSuccess, that.paymentTxnSuccess);
    }

    @Override
    public int hashCode() {
        return Objects.hash(managementId, paymentType, country, potentialRevenue, paymentTxnSuccess);
    }

    @Override
    public String toString() {
        return "Management{" +
                "managementId=" + managementId +
                ", paymentType='" + paymentType + '\'' +
                ", country='" + country + '\'' +
                ", potentialRevenue=" + potentialRevenue +
                ", paymentTxnSuccess='" + paymentTxnSuccess + '\'' +
                '}';
    }
}
