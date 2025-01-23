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
@Table(name = "Parts")
@Data
public class Part {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int partID;
    
    @Column(nullable = false)
    private String partName;
    
    @ManyToOne
    @JoinColumn(name = "SupplierID", nullable = false)
    private Supplier supplier;
    
    @Column(nullable = false)
    private int thresholdLimit;
    
    @Column(nullable = false)
    private int availableQty;
    
    @Column(nullable = false)
    private int minOrderQty;
    
    private Timestamp createdAt;
    private Timestamp updatedAt;
   // @Column(nullable = false)
    private Long unitPrice;
    
}