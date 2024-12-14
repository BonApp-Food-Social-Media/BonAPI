package ch.bonapp.bonapi.services;

import ch.bonapp.bonapi.entities.both.Ingredient;
import ch.bonapp.bonapi.repositories.BonAPI_Ingredient_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
     */
    public Ingredient saveIngredient(Ingredient ingredient) {
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
     * @return An Optional containing the Ingredient entity, if found.
     */
    public Optional<Ingredient> getIngredientById(String id) {
        return ingredientRepository.findById(id);
    }

    /**
     * Deletes an Ingredient entity by its ID.
     *
     * @param id The ID of the Ingredient entity to delete.
     */
    public void deleteIngredientById(String id) {
        ingredientRepository.deleteById(id);
    }
}
