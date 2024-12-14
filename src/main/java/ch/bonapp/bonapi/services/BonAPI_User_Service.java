package ch.bonapp.bonapi.services;

import ch.bonapp.bonapi.entities.both.User;
import ch.bonapp.bonapi.repositories.BonAPI_User_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
     */
    public User saveUser(User user) {
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
     * @return An Optional containing the User entity, if found.
     */
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    /**
     * Deletes a User entity by its ID.
     *
     * @param id The ID of the User entity to delete.
     */
    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }
}
