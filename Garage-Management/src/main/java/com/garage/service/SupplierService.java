package com.garage.service;

import java.util.List;

import com.garage.domain.Supplier;

public interface SupplierService {
	List<Supplier> getAllSuppliers();
    Supplier saveSupplier(Supplier supplier);
    Supplier getSupplierById(int id);
    void deleteSupplier(int id);
}
