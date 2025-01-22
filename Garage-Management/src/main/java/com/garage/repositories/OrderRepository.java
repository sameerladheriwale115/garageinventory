package com.garage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garage.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	
}
