package ch.bonapp.bonapi.controllers;

import ch.bonapp.bonapi.entities.both.Food;
import ch.bonapp.bonapi.services.BonAPI_Food_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST Controller for managing Food entities.
 * Provides endpoints for CRUD operations.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/food")
public class BonAPI_Food_Controller {

    /**
     * Service for Food entities.
     * Used to interact with the database through the service layer.
     */
    @Autowired
    private BonAPI_Food_Service foodService;

    /**
     * Retrieves all Food entities.
     *
     * @return A list of all Food entities.
     */
    @GetMapping
    public List<Food> getAllFoods() {
        return foodService.getAllFoods();
    }

    /**
     * Retrieves a Food entity by its ID.
     *
     * @param id The ID of the Food entity.
     * @return The Food entity if found.
     */
    @GetMapping("/{id}")
    public Optional<Food> getFoodById(@PathVariable String id) {
        return Optional.ofNullable(foodService.getFoodById(id));
    }

    /**
     * Creates a new Food entity.
     *
     * @param food The Food entity to create.
     * @return The created Food entity.
     */
    @PostMapping
    public Food createFood(@RequestBody Food food) {
        return foodService.saveFood(food);
    }

    /**
     * Updates an existing Food entity.
     *
     * @param id   The ID of the Food entity to update.
     * @param food The updated Food entity.
     * @return The updated Food entity.
     */
    @PutMapping("/{id}")
    public Food updateFood(@PathVariable String id, @RequestBody Food food) {
        food.setId(id);
        return foodService.saveFood(food);
    }

    /**
     * Deletes a Food entity by its ID.
     *
     * @param id The ID of the Food entity to delete.
     */
    @DeleteMapping("/{id}")
    public void deleteFood(@PathVariable String id) {
        foodService.deleteFoodById(id);
    }
}
