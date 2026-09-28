package com.example.CampusFind.service;

import com.example.CampusFind.model.FoundItem;
import com.example.CampusFind.repository.FoundItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoundItemService {

    private final FoundItemRepository foundItemRepository;

    public FoundItemService(FoundItemRepository foundItemRepository) {
        this.foundItemRepository = foundItemRepository;
    }

    public FoundItem createFoundItem(FoundItem item) {

        if (item.getStatus() == null) {
            item.setStatus("AVAILABLE");
        }

        return foundItemRepository.save(item);
    }

    public List<FoundItem> getAllFoundItems() {
        return foundItemRepository.findAll();
    }

    public FoundItem getFoundItemById(Long id) {
        return foundItemRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Found item not found with id: " + id));
    }

    public void deleteFoundItem(Long id) {
        foundItemRepository.deleteById(id);
    }

    public FoundItem claimItem(Long id) {

        FoundItem item = getFoundItemById(id);

        if (!"AVAILABLE".equals(item.getStatus())) {
            throw new RuntimeException(
                    "Only AVAILABLE items can be claimed");
        }

        item.setStatus("CLAIMED");

        return foundItemRepository.save(item);
    }

    public FoundItem returnItem(Long id) {

        FoundItem item = getFoundItemById(id);

        if (!"CLAIMED".equals(item.getStatus())) {
            throw new RuntimeException(
                    "Item must be CLAIMED before it can be RETURNED");
        }

        item.setStatus("RETURNED");

        return foundItemRepository.save(item);
    }

    public List<FoundItem> findByCategory(Long categoryId) {
        return foundItemRepository.findByCategoryId(categoryId);
    }

    public List<FoundItem> findByLocation(String location) {
        return foundItemRepository.findByLocationContainingIgnoreCase(location);
    }
}