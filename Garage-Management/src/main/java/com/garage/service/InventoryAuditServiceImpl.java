package com.garage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garage.domain.InventoryAudit;
import com.garage.repositories.InventoryAuditRepository;

@Service
public class InventoryAuditServiceImpl implements InventoryAuditService {
	
	@Autowired
	private InventoryAuditRepository inventoryAuditRepository;

	@Override
	public InventoryAudit saveInventoryAudit(InventoryAudit inventoryAudit) {
		return inventoryAuditRepository.save(inventoryAudit);
	}

	@Override
	public InventoryAudit getInventoryAuditById(int id) {
		return inventoryAuditRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteInventoryAudit(int id) {
		inventoryAuditRepository.deleteById(id);

	}

	@Override
	public List<InventoryAudit> getAllInventory() {
		return inventoryAuditRepository.findAll();
	}

}
