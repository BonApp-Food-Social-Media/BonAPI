package ch.bonapp.bonapi.controllers;

import ch.bonapp.bonapi.entities.both.Ingredient;
import ch.bonapp.bonapi.services.BonAPI_Ingredient_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST Controller for managing Ingredient entities.
 * Provides endpoints for CRUD operations.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/ingredient")
public class BonAPI_Ingredient_Controller {

    /**
     * Service for Ingredient entities.
     * Used to interact with the database through the service layer.
     */
    @Autowired
    private BonAPI_Ingredient_Service ingredientService;

    /**
     * Retrieves all Ingredient entities.
     *
     * @return A list of all Ingredient entities.
     */
    @GetMapping
    public List<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    /**
     * Retrieves an Ingredient entity by its ID.
     *
     * @param id The ID of the Ingredient entity.
     * @return The Ingredient entity if found.
     */
    @GetMapping("/{id}")
    public Optional<Ingredient> getIngredientById(@PathVariable String id) {
        return Optional.ofNullable(ingredientService.getIngredientById(id));
    }

    /**
     * Creates a new Ingredient entity.
     *
     * @param ingredient The Ingredient entity to create.
     * @return The created Ingredient entity.
     */
    @PostMapping
    public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.saveIngredient(ingredient);
    }

    /**
     * Updates an existing Ingredient entity.
     *
     * @param id         The ID of the Ingredient entity to update.
     * @param ingredient The updated Ingredient entity.
     * @return The updated Ingredient entity.
     */
    @PutMapping("/{id}")
    public Ingredient updateIngredient(@PathVariable String id, @RequestBody Ingredient ingredient) {
        ingredient.setId(id);
        return ingredientService.saveIngredient(ingredient);
    }

    /**
     * Deletes an Ingredient entity by its ID.
     *
     * @param id The ID of the Ingredient entity to delete.
     */
    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable String id) {
        ingredientService.deleteIngredientById(id);
    }
}
