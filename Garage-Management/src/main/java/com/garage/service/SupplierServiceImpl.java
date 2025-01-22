package com.garage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garage.domain.Supplier;
import com.garage.repositories.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService {
	
	@Autowired
	private SupplierRepository supplierRepository;

	@Override
	public Supplier saveSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	@Override
	public Supplier getSupplierById(int id) {
		// TODO Auto-generated method stub
		return supplierRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteSupplier(int id) {
		supplierRepository.deleteById(id);

	}

	@Override
	public List<Supplier> getAllSuppliers() {
		// TODO Auto-generated method stub
		return supplierRepository.findAll();
	}

}
