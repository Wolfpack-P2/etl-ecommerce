package com.revature.models;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

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

}
