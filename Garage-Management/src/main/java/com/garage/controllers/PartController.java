package com.garage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.garage.domain.Order;
import com.garage.domain.Part;
import com.garage.service.PartService;

@RestController
@RequestMapping("/api/parts")
public class PartController {
    
    @Autowired
    private PartService partService;

    @PostMapping
    public Part createPart(@RequestBody Part part) {
        return partService.savePart(part);
    }

    @GetMapping("/{id}")
    public Part getPartById(@PathVariable int id) {
        return partService.getPartById(id);
    }
    
    @GetMapping
    public List<Part> getAllParts() {
        return partService.getAllParts();
    }

    @DeleteMapping("/{id}")
    public void deletePart(@PathVariable int id) {
        partService.deletePart(id);
    }

    @PostMapping("/order/{id}")
    public Order orderPart(@PathVariable int id, @RequestParam Integer qty) {
        return partService.orderPart(id, qty);
    }
    @PutMapping("/{id}")
    public Part updatePart(@PathVariable int id, @RequestBody Part part) {
        return partService.updatePart(id, part);
    }    
}