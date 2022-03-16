package com.revature.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="payment_table")
@AllArgsConstructor
@NoArgsConstructor
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


}
