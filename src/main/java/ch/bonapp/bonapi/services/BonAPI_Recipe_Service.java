package ch.bonapp.bonapi.services;

import ch.bonapp.bonapi.entities.both.Recipe;
import ch.bonapp.bonapi.repositories.BonAPI_Recipe_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
     */
    public Recipe saveRecipe(Recipe recipe) {
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
     * @return An Optional containing the Recipe entity, if found.
     */
    public Optional<Recipe> getRecipeById(String id) {
        return recipeRepository.findById(id);
    }

    /**
     * Deletes a Recipe entity by its ID.
     *
     * @param id The ID of the Recipe entity to delete.
     */
    public void deleteRecipeById(String id) {
        recipeRepository.deleteById(id);
    }
}
