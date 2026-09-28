package com.example.CampusFind.controller;

import com.example.CampusFind.model.FoundItem;
import com.example.CampusFind.service.FoundItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/found")
public class FoundItemController {

    private final FoundItemService foundItemService;

    public FoundItemController(FoundItemService foundItemService) {
        this.foundItemService = foundItemService;
    }

    // CREATE FOUND ITEM
    @PostMapping
    public FoundItem createFoundItem(
            @RequestBody FoundItem item) {

        return foundItemService.createFoundItem(item);
    }

    // GET ALL FOUND ITEMS
    @GetMapping
    public List<FoundItem> getAllFoundItems() {
        return foundItemService.getAllFoundItems();
    }

    // GET FOUND ITEM BY ID
    @GetMapping("/{id}")
    public FoundItem getFoundItemById(
            @PathVariable Long id) {

        return foundItemService.getFoundItemById(id);
    }

    // DELETE FOUND ITEM
    @DeleteMapping("/{id}")
    public String deleteFoundItem(
            @PathVariable Long id) {

        foundItemService.deleteFoundItem(id);

        return "Found item deleted successfully";
    }

    // CLAIM ITEM
    @PutMapping("/{id}/claim")
    public FoundItem claimItem(
            @PathVariable Long id) {

        return foundItemService.claimItem(id);
    }

    // RETURN ITEM
    @PutMapping("/{id}/return")
    public FoundItem returnItem(
            @PathVariable Long id) {

        return foundItemService.returnItem(id);
    }

    // SEARCH BY CATEGORY
    @GetMapping("/category/{categoryId}")
    public List<FoundItem> findByCategory(
            @PathVariable Long categoryId) {

        return foundItemService.findByCategory(categoryId);
    }

    // SEARCH BY LOCATION
    @GetMapping("/location/{location}")
    public List<FoundItem> findByLocation(
            @PathVariable String location) {

        return foundItemService.findByLocation(location);
    }
}