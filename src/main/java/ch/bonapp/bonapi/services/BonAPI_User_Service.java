package ch.bonapp.bonapi.services;

import ch.bonapp.bonapi.entities.both.User;
import ch.bonapp.bonapi.repositories.BonAPI_User_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing User entities.
 * This class provides methods for CRUD operations and custom queries related to Users.
 */
@Service
public class BonAPI_User_Service {

    /**
     * Repository for User entities.
     * Used for accessing the database.
     */
    @Autowired
    private BonAPI_User_Repository userRepository;

    /**
     * Saves or updates a User entity in the database.
     *
     * @param user The User entity to be saved or updated.
     * @return The saved or updated User entity.
     * @throws IllegalArgumentException if the User or username is null.
     */
    public User saveUser(User user) {
        if (user == null || user.getUsername() == null) {
            throw new IllegalArgumentException("User or username cannot be null.");
        }
        return userRepository.save(user);
    }

    /**
     * Retrieves all User entities from the database.
     *
     * @return A list of all User entities.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Retrieves a User entity by its ID.
     *
     * @param id The ID of the User entity.
     * @return The User entity if found.
     * @throws IllegalArgumentException if the ID is null or empty.
     * @throws RuntimeException if the User with the given ID is not found.
     */
    public User getUserById(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty.");
        }
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with ID " + id + " not found."));
    }

    /**
     * Deletes a User entity by its ID.
     *
     * @param id The ID of the User entity to delete.
     * @throws IllegalArgumentException if the ID is null or empty.
     * @throws RuntimeException if the User with the given ID does not exist.
     */
    public void deleteUserById(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty.");
        }
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User with ID " + id + " does not exist.");
        }
        userRepository.deleteById(id);
    }

    /**
     * Retrieves a User entity by its username.
     *
     * @param username The username of the User entity.
     * @return The User entity if found.
     * @throws IllegalArgumentException if the username is null or empty.
     * @throws RuntimeException if the User with the given username is not found.
     */
    public User getUserByUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty.");
        }
        return userRepository.findByUsername(username);
    }
}
