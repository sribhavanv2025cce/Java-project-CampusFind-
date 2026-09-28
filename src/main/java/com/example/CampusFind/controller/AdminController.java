package com.example.CampusFind.controller;

import com.example.CampusFind.model.User;
import com.example.CampusFind.model.FoundItem;
import com.example.CampusFind.repository.UserRepository;
import com.example.CampusFind.repository.FoundItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final UserRepository userRepository;
    private final FoundItemRepository foundItemRepository;

    public AdminController(
            UserRepository userRepository,
            FoundItemRepository foundItemRepository) {

        this.userRepository = userRepository;
        this.foundItemRepository = foundItemRepository;
    }

    // GET ALL USERS
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // GET ALL FOUND ITEMS
    @GetMapping("/found-items")
    public List<FoundItem> getAllFoundItems() {
        return foundItemRepository.findAll();
    }

    // DELETE USER
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {

        if (!userRepository.existsById(id)) {
            return "User not found";
        }

        userRepository.deleteById(id);

        return "User deleted successfully";
    }

    // DELETE FOUND ITEM
    @DeleteMapping("/found-items/{id}")
    public String deleteFoundItem(@PathVariable Long id) {

        if (!foundItemRepository.existsById(id)) {
            return "Found item not found";
        }

        foundItemRepository.deleteById(id);

        return "Found item deleted successfully";
    }
}