package ch.bonapp.bonapi.controllers;

import ch.bonapp.bonapi.entities.both.Foodstyle;
import ch.bonapp.bonapi.services.BonAPI_Foodstyle_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST Controller for managing FoodStyle entities.
 * Provides endpoints for CRUD operations.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/foodstyle")
public class BonAPI_Foodstyle_Controller {

    /**
     * Service for FoodStyle entities.
     * Used to interact with the database through the service layer.
     */
    @Autowired
    private BonAPI_Foodstyle_Service foodstyleService;

    /**
     * Retrieves all FoodStyle entities.
     *
     * @return A list of all FoodStyle entities.
     */
    @GetMapping
    public List<Foodstyle> getAllFoodstyles() {
        return foodstyleService.getAllFoodstyles();
    }

    /**
     * Retrieves a FoodStyle entity by its ID.
     *
     * @param id The ID of the FoodStyle entity.
     * @return The FoodStyle entity if found.
     */
    @GetMapping("/{id}")
    public Optional<Foodstyle> getFoodstyleById(@PathVariable String id) {
        return foodstyleService.getFoodstyleById(id);
    }

    /**
     * Creates a new FoodStyle entity.
     *
     * @param foodstyle The FoodStyle entity to create.
     * @return The created FoodStyle entity.
     */
    @PostMapping
    public Foodstyle createFoodstyle(@RequestBody Foodstyle foodstyle) {
        return foodstyleService.saveFoodstyle(foodstyle);
    }

    /**
     * Updates an existing FoodStyle entity.
     *
     * @param id        The ID of the FoodStyle entity to update.
     * @param foodstyle The updated FoodStyle entity.
     * @return The updated FoodStyle entity.
     */
    @PutMapping("/{id}")
    public Foodstyle updateFoodstyle(@PathVariable String id, @RequestBody Foodstyle foodstyle) {
        foodstyle.setId(id);
        return foodstyleService.saveFoodstyle(foodstyle);
    }

    /**
     * Deletes a FoodStyle entity by its ID.
     *
     * @param id The ID of the FoodStyle entity to delete.
     */
    @DeleteMapping("/{id}")
    public void deleteFoodstyle(@PathVariable String id) {
        foodstyleService.deleteFoodstyleById(id);
    }
}
