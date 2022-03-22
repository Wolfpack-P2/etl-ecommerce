package com.revature.payment;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="payment_table")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_txn_id")
    private Integer paymentTxnId;

    @Column(name = "failure_reason")
    private String failureReason;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "payment_txn_success")
    private String paymentTxnSuccess;

    // No args constructor
    public Payment() {
        super();
    }

    // All args constructor
    public Payment(Integer paymentTxnId, String failureReason, String paymentType, String paymentTxnSuccess) {
        this.paymentTxnId = paymentTxnId;
        this.failureReason = failureReason;
        this.paymentType = paymentType;
        this.paymentTxnSuccess = paymentTxnSuccess;
    }

    // Getters and setters
    public Integer getPaymentTxnId() {
        return paymentTxnId;
    }

    public void setPaymentTxnId(Integer paymentTxnId) {
        this.paymentTxnId = paymentTxnId;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentTxnSuccess() {
        return paymentTxnSuccess;
    }

    public void setPaymentTxnSuccess(String paymentTxnSuccess) {
        this.paymentTxnSuccess = paymentTxnSuccess;
    }

    // toString
    @Override
    public String toString() {
        return "PaymentEntity{" +
                "paymentTxnId=" + paymentTxnId +
                ", failureReason='" + failureReason + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", paymentTxnSuccess='" + paymentTxnSuccess + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment that = (Payment) o;
        return Objects.equals(paymentTxnId, that.paymentTxnId) && Objects.equals(failureReason, that.failureReason) && Objects.equals(paymentType, that.paymentType) && Objects.equals(paymentTxnSuccess, that.paymentTxnSuccess);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentTxnId, failureReason, paymentType, paymentTxnSuccess);
    }
}
