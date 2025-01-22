package com.garage.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garage.domain.InventoryAudit;
import com.garage.domain.Order;
import com.garage.domain.Part;
import com.garage.repositories.AutoReorderService;
import com.garage.repositories.OrderRepository;
import com.garage.repositories.PartRepository;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class PartServiceImpl implements PartService{

    @Autowired
    private PartRepository partRepository;
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private AutoReorderService autoReorderService;
    
    @Autowired
    private InventoryAuditService inventoryAuditService;

    public Part savePart(Part part) {
    	Part response = partRepository.save(part);
        InventoryAudit inventoryAudit = InventoryAudit.builder()
				.part(part)
				.changeType("IN")
				.changeDate(new Timestamp(Instant.now().toEpochMilli()))
				.changeQty(part.getAvailableQty())
				.build();
        inventoryAuditService.saveInventoryAudit(inventoryAudit);
        return response;
    }
    public Part getPartById(int id) {
        return partRepository.findById(id).orElse(null);
    }
    public void deletePart(int id) {
        partRepository.deleteById(id);
    }

	@Override
	public Order orderPart(int partId, Integer qty) {
		Order response =null;
		int availableQuantity = 0;
		Part part = partRepository.findById(partId).orElseThrow(() -> new RuntimeException("Part not found"));
		if(qty < part.getAvailableQty()) {
			Order order = new Order();
			order.setPart(part);
			order.setOrderQty(qty);
			order.setStatus("Placed");
			order.setOrderDate(new Timestamp(Instant.now().toEpochMilli()));
			response = orderRepository.save(order);
			if (response != null) {
				availableQuantity = part.getAvailableQty() - qty;
				part.setAvailableQty(availableQuantity);
				partRepository.save(part);
				InventoryAudit inventoryAudit = InventoryAudit.builder()
												.part(part)
												.changeType("OUT")
												.changeDate(order.getOrderDate())
												.changeQty(qty)
												.build();
				inventoryAuditService.saveInventoryAudit(inventoryAudit);
				if(availableQuantity <= part.getThresholdLimit()) {
					autoReorderService.reorder(part);
				}
			}
		}else {
			log.error("Order quantity must be less that available quantity");
		}
		
		return response;
	}
	@Override
	public List<Part> getAllParts() {
		return partRepository.findAll();
	}
	
	@Override
    public Part updatePart(int id, Part partDetails) {
        Part part = partRepository.findById(id).orElseThrow(() -> new RuntimeException("Part not found"));
        part.setPartName(partDetails.getPartName());
        part.setSupplier(partDetails.getSupplier());
        part.setThresholdLimit(partDetails.getThresholdLimit());
        part.setAvailableQty(part.getAvailableQty()+partDetails.getAvailableQty());
        part.setMinOrderQty(partDetails.getMinOrderQty());
        Part response = partRepository.save(part);
        InventoryAudit inventoryAudit = InventoryAudit.builder()
				.part(part)
				.changeType("IN")
				.changeDate(new Timestamp(Instant.now().toEpochMilli()))
				.changeQty(partDetails.getAvailableQty())
				.build();
        inventoryAuditService.saveInventoryAudit(inventoryAudit);
        return response;
    }
	
}
