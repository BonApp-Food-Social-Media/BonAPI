package ch.bonapp.bonapi.controllers;

import ch.bonapp.bonapi.entities.both.Recipe;
import ch.bonapp.bonapi.services.BonAPI_Recipe_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST Controller for managing Recipe entities.
 * Provides endpoints for CRUD operations.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/recipe")
public class BonAPI_Recipe_Controller {

    /**
     * Service for Recipe entities.
     * Used to interact with the database through the service layer.
     */
    @Autowired
    private BonAPI_Recipe_Service recipeService;

    /**
     * Retrieves all Recipe entities.
     *
     * @return A list of all Recipe entities.
     */
    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    /**
     * Retrieves a Recipe entity by its ID.
     *
     * @param id The ID of the Recipe entity.
     * @return The Recipe entity if found.
     */
    @GetMapping("/{id}")
    public Optional<Recipe> getRecipeById(@PathVariable String id) {
        return Optional.ofNullable(recipeService.getRecipeById(id));
    }

    /**
     * Creates a new Recipe entity.
     *
     * @param recipe The Recipe entity to create.
     * @return The created Recipe entity.
     */
    @PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipeService.saveRecipe(recipe);
    }

    /**
     * Updates an existing Recipe entity.
     *
     * @param id     The ID of the Recipe entity to update.
     * @param recipe The updated Recipe entity.
     * @return The updated Recipe entity.
     */
    @PutMapping("/{id}")
    public Recipe updateRecipe(@PathVariable String id, @RequestBody Recipe recipe) {
        recipe.setId(id);
        return recipeService.saveRecipe(recipe);
    }

    /**
     * Deletes a Recipe entity by its ID.
     *
     * @param id The ID of the Recipe entity to delete.
     */
    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable String id) {
        recipeService.deleteRecipeById(id);
    }
}
