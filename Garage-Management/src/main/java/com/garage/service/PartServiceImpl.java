package com.garage.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalTime;
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

    private static final BigDecimal discountPercent = new BigDecimal(10);
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
			order.setTotalAmount(calculateTotalAmount(qty, part));
			order.setDiscount(calculateDiscountAmount(qty, part));
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
	private Long calculateTotalAmount(Integer qty, Part part) {
		// TODO Auto-generated method stub
		return Math.multiplyExact(qty, part.getUnitPrice())-calculateDiscountAmount(qty, part);
	}
	private long calculateDiscountAmount(Integer qty, Part part) {
		if(part.getSupplier().getSupplierID()==1 || !isDiscountApplicable(part.getSupplier().getSupplierID())) {
			return 0;
		}
		Long totalBillAmount = Math.multiplyExact(qty, part.getUnitPrice());
        BigDecimal totalDecimal = BigDecimal.valueOf(totalBillAmount);
        return totalDecimal.multiply(discountPercent).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP).longValue();
	}
	public static boolean isDiscountApplicable(int supplierId) {
        LocalTime now = LocalTime.now();
        LocalTime startTime = LocalTime.of(0, 0);  // 12:00 AM
        LocalTime endTime = LocalTime.of(1, 0);    // 01:00 AM

        if (supplierId == 2) {
            return now.isAfter(startTime) && now.isBefore(endTime);
        }
        return false;  // Supplier-A can be ordered anytime
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
