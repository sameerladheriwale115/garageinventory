package com.garage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garage.domain.InventoryAudit;
import com.garage.service.InventoryAuditService;

@RestController
@RequestMapping("/api/inventory-audits")
public class InventoryAuditController {
    @Autowired
    private InventoryAuditService inventoryAuditService;

    @PostMapping
    public InventoryAudit createInventoryAudit(@RequestBody InventoryAudit inventoryAudit) {
        return inventoryAuditService.saveInventoryAudit(inventoryAudit);
    }

    @GetMapping("/{id}")
    public InventoryAudit getInventoryAuditById(@PathVariable int id) {
        return inventoryAuditService.getInventoryAuditById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteInventoryAudit(@PathVariable int id) {
        inventoryAuditService.deleteInventoryAudit(id);
    }
}
