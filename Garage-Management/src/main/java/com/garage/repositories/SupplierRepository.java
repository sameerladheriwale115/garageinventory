package com.garage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garage.domain.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
	
}
