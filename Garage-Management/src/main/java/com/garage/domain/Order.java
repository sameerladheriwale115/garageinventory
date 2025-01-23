package com.garage.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderID;
    
    @ManyToOne
    @JoinColumn(name = "PartID", nullable = false)
    private Part part;
    
    private Timestamp orderDate;
    private int orderQty;
    private String status;
   // @Column(nullable = false)
    private Long totalAmount;
    private Long discount;
    
    // Getters and Setters
}
