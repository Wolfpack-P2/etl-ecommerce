package com.revature.models;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = "research")
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "day_of_week")
    private Double dayOfWeek;
}