package com.revature.models;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
@Component
@Entity
@Table(name="payment_table")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="payment_txn_id")
    private Integer paymentTxnId;

    @Column(name="failure_reason")
    private String failureReason;

    @Column(name="payment_type")
    private String paymentType;

    @Column(name="payment_txn_success")
    private String paymentTxnSuccess;

//    public Integer getPaymentTxnId() {
//        return paymentTxnId;
//    }
//
//    public void setPaymentTxnId(Integer paymentTxnId) {
//        this.paymentTxnId = paymentTxnId;
//    }
//
//    public String getFailureReason() {
//        return failureReason;
//    }
//
//    public void setFailureReason(String failureReason) {
//        this.failureReason = failureReason;
//    }
//
//    public String getPaymentType() {
//        return paymentType;
//    }
//
//    public void setPaymentType(String paymentType) {
//        this.paymentType = paymentType;
//    }
//
//    public String getPaymentTxnSuccess() {
//        return paymentTxnSuccess;
//    }
//
//    public void setPaymentTxnSuccess(String paymentTxnSuccess) {
//        this.paymentTxnSuccess = paymentTxnSuccess;
//    }
//
//    @Override
//    public String toString() {
//        return "PaymentEntity{" +
//                "paymentTxnId=" + paymentTxnId +
//                ", failureReason='" + failureReason + '\'' +
//                ", paymentType='" + paymentType + '\'' +
//                ", paymentTxnSuccess='" + paymentTxnSuccess + '\'' +
//                '}';
//    }
}
