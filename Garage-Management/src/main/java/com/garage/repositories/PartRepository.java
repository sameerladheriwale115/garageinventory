package com.garage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garage.domain.Part;

public interface PartRepository extends JpaRepository<Part, Integer> {
	
}
