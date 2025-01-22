package com.garage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garage.domain.InventoryAudit;

public interface InventoryAuditRepository extends JpaRepository<InventoryAudit, Integer> {}
