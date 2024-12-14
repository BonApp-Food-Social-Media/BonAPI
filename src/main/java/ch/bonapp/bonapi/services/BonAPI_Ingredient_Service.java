package ch.bonapp.bonapi.services;

import ch.bonapp.bonapi.entities.both.Ingredient;
import ch.bonapp.bonapi.repositories.BonAPI_Ingredient_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing Ingredient entities.
 * This class provides methods for CRUD operations and custom queries related to Ingredients.
 */
@Service
public class BonAPI_Ingredient_Service {

    /**
     * Repository for Ingredient entities.
     * Used for accessing the database.
     */
    @Autowired
    private BonAPI_Ingredient_Repository ingredientRepository;

    /**
     * Saves or updates an Ingredient entity in the database.
     *
     * @param ingredient The Ingredient entity to be saved or updated.
     * @return The saved or updated Ingredient entity.
     * @throws IllegalArgumentException if the Ingredient or its name is null.
     */
    public Ingredient saveIngredient(Ingredient ingredient) {
        if (ingredient == null || ingredient.getName() == null) {
            throw new IllegalArgumentException("Ingredient or ingredient name cannot be null.");
        }
        return ingredientRepository.save(ingredient);
    }

    /**
     * Retrieves all Ingredient entities from the database.
     *
     * @return A list of all Ingredient entities.
     */
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    /**
     * Retrieves an Ingredient entity by its ID.
     *
     * @param id The ID of the Ingredient entity.
     * @return The Ingredient entity if found.
     * @throws IllegalArgumentException if the ID is null or empty.
     * @throws RuntimeException if the Ingredient with the given ID is not found.
     */
    public Ingredient getIngredientById(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty.");
        }
        return ingredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingredient with ID " + id + " not found."));
    }

    /**
     * Deletes an Ingredient entity by its ID.
     *
     * @param id The ID of the Ingredient entity to delete.
     * @throws IllegalArgumentException if the ID is null or empty.
     * @throws RuntimeException if the Ingredient with the given ID does not exist.
     */
    public void deleteIngredientById(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty.");
        }
        if (!ingredientRepository.existsById(id)) {
            throw new RuntimeException("Ingredient with ID " + id + " does not exist.");
        }
        ingredientRepository.deleteById(id);
    }

    /**
     * Searches for Ingredients by their name.
     *
     * @param name The name to search for.
     * @return A list of matching Ingredients.
     * @throws IllegalArgumentException if the name is null or empty.
     */
    public List<Ingredient> searchByName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        return ingredientRepository.findByName(name);
    }

    /**
     * Searches for Ingredients by their associated Food Style ID.
     *
     * @param foodStyleId The Food Style ID to search for.
     * @return A list of matching Ingredients.
     * @throws IllegalArgumentException if the Food Style ID is null or empty.
     */
    public List<Ingredient> searchByFoodStyleId(String foodStyleId) {
        if (foodStyleId == null || foodStyleId.isEmpty()) {
            throw new IllegalArgumentException("Food Style ID cannot be null or empty.");
        }
        return ingredientRepository.findByFoodStyleId(foodStyleId);
    }
}
