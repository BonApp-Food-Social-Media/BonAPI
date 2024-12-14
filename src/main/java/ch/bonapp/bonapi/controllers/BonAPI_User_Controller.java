package ch.bonapp.bonapi.controllers;

import ch.bonapp.bonapi.entities.both.User;
import ch.bonapp.bonapi.services.BonAPI_User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST Controller for managing User entities.
 * Provides endpoints for CRUD operations.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class BonAPI_User_Controller {

    /**
     * Service for User entities.
     * Used to interact with the database through the service layer.
     */
    @Autowired
    private BonAPI_User_Service userService;

    /**
     * Retrieves all User entities.
     *
     * @return A list of all User entities.
     */
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Retrieves a User entity by its ID.
     *
     * @param id The ID of the User entity.
     * @return The User entity if found.
     */
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    /**
     * Creates a new User entity.
     *
     * @param user The User entity to create.
     * @return The created User entity.
     */
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    /**
     * Updates an existing User entity.
     *
     * @param id   The ID of the User entity to update.
     * @param user The updated User entity.
     * @return The updated User entity.
     */
    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        user.setId(id);
        return userService.saveUser(user);
    }

    /**
     * Deletes a User entity by its ID.
     *
     * @param id The ID of the User entity to delete.
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUserById(id);
    }
}
