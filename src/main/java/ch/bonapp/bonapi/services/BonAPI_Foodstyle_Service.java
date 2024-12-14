package ch.bonapp.bonapi.services;

import ch.bonapp.bonapi.entities.both.Foodstyle;
import ch.bonapp.bonapi.repositories.BonAPI_Foodstyle_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
     */
    public Foodstyle saveFoodstyle(Foodstyle foodstyle) {
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
     * @return An Optional containing the FoodStyle entity, if found.
     */
    public Optional<Foodstyle> getFoodstyleById(String id) {
        return foodstyleRepository.findById(id);
    }

    /**
     * Deletes a FoodStyle entity by its ID.
     *
     * @param id The ID of the FoodStyle entity to delete.
     */
    public void deleteFoodstyleById(String id) {
        foodstyleRepository.deleteById(id);
    }
}
