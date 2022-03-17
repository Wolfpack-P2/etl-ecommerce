package com.revature.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "management")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Management {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "management_id")
    private Integer managementId;

    @Column(name = "payment_type")
    private String paymentType;

    private String country;

    @Column(name = "potential_revenue")
    private Double potentialRevenue;

    @Column(name = "payment_txn_success")
    private String paymentTxnSuccess;
}
