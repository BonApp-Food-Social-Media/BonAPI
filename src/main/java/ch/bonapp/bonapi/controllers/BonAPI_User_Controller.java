package ch.bonapp.bonapi.controllers;

import ch.bonapp.bonapi.entities.both.User;
import ch.bonapp.bonapi.services.BonAPI_User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST Controller for managing User entities.
 * Provides endpoints for CRUD operations and follower management.
 */
@RestController
@CrossOrigin(origins = "*")
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
     * @return The User entity if found, wrapped in an Optional.
     */
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable String id) {
        return Optional.ofNullable(userService.getUserById(id));
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

    /**
     * Adds a follower to a User.
     *
     * @param userId The ID of the User who is following.
     * @param followedId The ID of the User to be followed.
     * @return ResponseEntity with status.
     */
    @PostMapping("/{userId}/follow/{followedId}")
    public ResponseEntity<?> addFollower(@PathVariable String userId, @PathVariable String followedId) {
        try {
            userService.addFollower(userId, followedId);
            return ResponseEntity.ok("Follower added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    /**
     * Removes a follower from a User.
     *
     * @param userId The ID of the User who wants to unfollow.
     * @param followedId The ID of the User to be unfollowed.
     * @return ResponseEntity with status.
     */
    @DeleteMapping("/{userId}/unfollow/{followedId}")
    public ResponseEntity<?> removeFollower(@PathVariable String userId, @PathVariable String followedId) {
        try {
            userService.removeFollower(userId, followedId);
            return ResponseEntity.ok("Follower removed successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    /**
     * Retrieves all followers of a User.
     *
     * @param userId The ID of the User whose followers are to be retrieved.
     * @return A list of Users who follow the specified User.
     */
    @GetMapping("/{userId}/followers")
    public List<User> getFollowers(@PathVariable String userId) {
        return userService.getFollowers(userId);
    }

    /**
     * Retrieves all followings of a User.
     *
     * @param userId The ID of the User whose followings are to be retrieved.
     * @return A list of Users that the specified User is following.
     */
    @GetMapping("/{userId}/followings")
    public List<User> getFollowings(@PathVariable String userId) {
        return userService.getFollowings(userId);
    }
}
