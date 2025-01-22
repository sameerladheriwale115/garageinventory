package com.garage.service;

import java.util.List;

import com.garage.domain.Order;
import com.garage.domain.Part;


public interface PartService {
	List<Part> getAllParts();
    Part savePart(Part part);
    Part getPartById(int id);
    void deletePart(int id);
    Order orderPart(int partId, Integer qty);
    Part updatePart(int id, Part partDetails);
}

