package ch.bonapp.bonapi.repositories;

import ch.bonapp.bonapi.entities.both.Ingredient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing Ingredient entities in MongoDB.
 * Extends the {@link MongoRepository} interface to provide standard CRUD operations.
 * Custom query methods can be added as needed.
 */
@Repository
public interface BonAPI_Ingredient_Repository extends MongoRepository<Ingredient, String> {

    /**
     * Finds a list of Ingredients by their name.
     *
     * @param name the name of the Ingredient to search for.
     * @return a list of matching Ingredients.
     */
    List<Ingredient> findByName(String name);

    /**
     * Finds Ingredients by their associated Food Style ID.
     *
     * @param foodStyleId the ID of the Food Style to search for.
     * @return a list of matching Ingredients.
     */
    List<Ingredient> findByFoodStyleId(String foodStyleId);

    /**
     * Finds Ingredients where the description contains a specific keyword (case-insensitive).
     *
     * @param keyword the keyword to search for in the description.
     * @return a list of matching Ingredients.
     */
    List<Ingredient> findByDescriptionContainingIgnoreCase(String keyword);

    /**
     * Finds all Ingredients sorted by their name in ascending order.
     *
     * @return a list of Ingredients sorted by name.
     */
    List<Ingredient> findAllByOrderByNameAsc();
}
