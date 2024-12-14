package ch.bonapp.bonapi.services;

import ch.bonapp.bonapi.entities.both.Recipe;
import ch.bonapp.bonapi.repositories.BonAPI_Recipe_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing Recipe entities.
 * This class provides methods for CRUD operations and custom queries related to Recipes.
 */
@Service
public class BonAPI_Recipe_Service {

    /**
     * Repository for Recipe entities.
     * Used for accessing the database.
     */
    @Autowired
    private BonAPI_Recipe_Repository recipeRepository;

    /**
     * Saves or updates a Recipe entity in the database.
     *
     * @param recipe The Recipe entity to be saved or updated.
     * @return The saved or updated Recipe entity.
     * @throws IllegalArgumentException if the Recipe or its name is null.
     */
    public Recipe saveRecipe(Recipe recipe) {
        if (recipe == null || recipe.getName() == null) {
            throw new IllegalArgumentException("Recipe or recipe name cannot be null.");
        }
        return recipeRepository.save(recipe);
    }

    /**
     * Retrieves all Recipe entities from the database.
     *
     * @return A list of all Recipe entities.
     */
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    /**
     * Retrieves a Recipe entity by its ID.
     *
     * @param id The ID of the Recipe entity.
     * @return The Recipe entity if found.
     * @throws IllegalArgumentException if the ID is null or empty.
     * @throws RuntimeException if the Recipe with the given ID is not found.
     */
    public Recipe getRecipeById(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty.");
        }
        return recipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipe with ID " + id + " not found."));
    }

    /**
     * Deletes a Recipe entity by its ID.
     *
     * @param id The ID of the Recipe entity to delete.
     * @throws IllegalArgumentException if the ID is null or empty.
     * @throws RuntimeException if the Recipe with the given ID does not exist.
     */
    public void deleteRecipeById(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty.");
        }
        if (!recipeRepository.existsById(id)) {
            throw new RuntimeException("Recipe with ID " + id + " does not exist.");
        }
        recipeRepository.deleteById(id);
    }

    /**
     * Searches for Recipes by their name.
     *
     * @param name The name to search for.
     * @return A list of matching Recipes.
     * @throws IllegalArgumentException if the name is null or empty.
     */
    public List<Recipe> searchByName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        return recipeRepository.findByName(name);
    }

    /**
     * Searches for Recipes by their associated Culinary Style ID.
     *
     * @param culinaryStyleId The Culinary Style ID to search for.
     * @return A list of matching Recipes.
     * @throws IllegalArgumentException if the Culinary Style ID is null or empty.
     */
    public List<Recipe> searchByCulinaryStyleId(String culinaryStyleId) {
        if (culinaryStyleId == null || culinaryStyleId.isEmpty()) {
            throw new IllegalArgumentException("Culinary Style ID cannot be null or empty.");
        }
        return recipeRepository.findByCulinaryStyleId(culinaryStyleId);
    }
}
