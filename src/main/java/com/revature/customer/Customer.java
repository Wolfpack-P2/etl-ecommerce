package com.revature.customer;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "customer_info")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Customer {

    @Column(name = "customer_id")
    private Integer customerId;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    //No args constructor
    public Customer() {
        super();
    }

    //All args constructor
    public Customer(Integer customerId, String customerName, String country, String city) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.country = country;
        this.city = city;
    }

    //Getters and setters
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    // toString
    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

