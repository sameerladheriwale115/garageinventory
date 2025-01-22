package com.garage.notification.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Part {
    private int partID;
    
    private String partName;
    
    private Supplier supplier;
    
    private int thresholdLimit;
    
    private int availableQty;
    
    private int minOrderQty;
    
    private Timestamp createdAt;
    private Timestamp updatedAt;
    
    // Getters and Setters
}