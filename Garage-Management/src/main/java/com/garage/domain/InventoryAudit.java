package com.garage.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "InventoryAudit")
@Builder
@Data
public class InventoryAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int auditID;
    
    @ManyToOne
    @JoinColumn(name = "PartID", nullable = false)
    private Part part;
    
    private String changeType;
    private int changeQty;
    private Timestamp changeDate;
    private String notes;
    
    // Getters and Setters
}
