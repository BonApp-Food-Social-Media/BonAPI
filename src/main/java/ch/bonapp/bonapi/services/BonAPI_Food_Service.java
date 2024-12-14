package ch.bonapp.bonapi.services;

import ch.bonapp.bonapi.entities.both.Food;
import ch.bonapp.bonapi.repositories.BonAPI_Food_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing Food entities.
 * This class provides methods for CRUD operations and custom queries related to Food.
 */
@Service
public class BonAPI_Food_Service {

    /**
     * Repository for Food entities.
     * Used for accessing the database.
     */
    @Autowired
    private BonAPI_Food_Repository foodRepository;

    /**
     * Saves or updates a Food entity in the database.
     *
     * @param food The Food entity to be saved or updated.
     * @return The saved or updated Food entity.
     */
    public Food saveFood(Food food) {
        if (food == null || food.getName() == null) {
            throw new IllegalArgumentException("Food or food name cannot be null.");
        }
        return foodRepository.save(food);
    }

    /**
     * Retrieves all Food entities from the database.
     *
     * @return A list of all Food entities.
     */
    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    /**
     * Retrieves a Food entity by its ID.
     *
     * @param id The ID of the Food entity.
     * @return The Food entity if found.
     * @throws IllegalArgumentException if the ID is null or empty.
     * @throws RuntimeException if the Food with the given ID is not found.
     */
    public Food getFoodById(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty.");
        }
        return foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food with ID " + id + " not found."));
    }

    /**
     * Deletes a Food entity by its ID.
     *
     * @param id The ID of the Food entity to delete.
     * @throws IllegalArgumentException if the ID is null or empty.
     * @throws RuntimeException if the Food with the given ID does not exist.
     */
    public void deleteFoodById(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty.");
        }
        if (!foodRepository.existsById(id)) {
            throw new RuntimeException("Food with ID " + id + " does not exist.");
        }
        foodRepository.deleteById(id);
    }

    /**
     * Searches for Food entities by their name.
     *
     * @param name The name to search for.
     * @return A list of matching Food entities.
     * @throws IllegalArgumentException if the name is null or empty.
     */
    public List<Food> searchByName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        return foodRepository.findByName(name);
    }
}
