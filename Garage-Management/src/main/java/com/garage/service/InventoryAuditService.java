package com.garage.service;

import java.util.List;

import com.garage.domain.InventoryAudit;

public interface InventoryAuditService {
    InventoryAudit saveInventoryAudit(InventoryAudit inventoryAudit);
    InventoryAudit getInventoryAuditById(int id);
    void deleteInventoryAudit(int id);
    List<InventoryAudit> getAllInventory();
}
