package ch.bonapp.bonapi.services;

import ch.bonapp.bonapi.entities.both.Foodstyle;
import ch.bonapp.bonapi.repositories.BonAPI_Foodstyle_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing FoodStyle entities.
 * This class provides methods for CRUD operations and custom queries related to FoodStyles.
 */
@Service
public class BonAPI_Foodstyle_Service {

    /**
     * Repository for FoodStyle entities.
     * Used for accessing the database.
     */
    @Autowired
    private BonAPI_Foodstyle_Repository foodstyleRepository;

    /**
     * Saves or updates a FoodStyle entity in the database.
     *
     * @param foodstyle The FoodStyle entity to be saved or updated.
     * @return The saved or updated FoodStyle entity.
     * @throws IllegalArgumentException if the FoodStyle or its style is null.
     */
    public Foodstyle saveFoodstyle(Foodstyle foodstyle) {
        if (foodstyle == null || foodstyle.getStyle() == null) {
            throw new IllegalArgumentException("Foodstyle or style cannot be null.");
        }
        return foodstyleRepository.save(foodstyle);
    }

    /**
     * Retrieves all FoodStyle entities from the database.
     *
     * @return A list of all FoodStyle entities.
     */
    public List<Foodstyle> getAllFoodstyles() {
        return foodstyleRepository.findAll();
    }

    /**
     * Retrieves a FoodStyle entity by its ID.
     *
     * @param id The ID of the FoodStyle entity.
     * @return The FoodStyle entity if found.
     * @throws IllegalArgumentException if the ID is null or empty.
     * @throws RuntimeException if the FoodStyle with the given ID is not found.
     */
    public Foodstyle getFoodstyleById(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty.");
        }
        return foodstyleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Foodstyle with ID " + id + " not found."));
    }

    /**
     * Deletes a FoodStyle entity by its ID.
     *
     * @param id The ID of the FoodStyle entity to delete.
     * @throws IllegalArgumentException if the ID is null or empty.
     * @throws RuntimeException if the FoodStyle with the given ID does not exist.
     */
    public void deleteFoodstyleById(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty.");
        }
        if (!foodstyleRepository.existsById(id)) {
            throw new RuntimeException("Foodstyle with ID " + id + " does not exist.");
        }
        foodstyleRepository.deleteById(id);
    }

    /**
     * Searches for FoodStyle entities by their style.
     *
     * @param style The style to search for.
     * @return A list of matching FoodStyle entities.
     * @throws IllegalArgumentException if the style is null or empty.
     */
    public List<Foodstyle> searchByStyle(String style) {
        if (style == null || style.isEmpty()) {
            throw new IllegalArgumentException("Style cannot be null or empty.");
        }
        return foodstyleRepository.findByStyle(style);
    }
}
