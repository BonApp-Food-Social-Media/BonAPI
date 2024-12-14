package ch.bonapp.bonapi.services;

import ch.bonapp.bonapi.entities.both.Food;
import ch.bonapp.bonapi.repositories.BonAPI_Food_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
     * @return An Optional containing the Food entity, if found.
     */
    public Optional<Food> getFoodById(String id) {
        return foodRepository.findById(id);
    }

    /**
     * Deletes a Food entity by its ID.
     *
     * @param id The ID of the Food entity to delete.
     */
    public void deleteFoodById(String id) {
        foodRepository.deleteById(id);
    }
}
