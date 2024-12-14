package ch.bonapp.bonapi.repositories;

import ch.bonapp.bonapi.entities.both.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing Recipe entities in MongoDB.
 * Extends the {@link MongoRepository} interface to provide standard CRUD operations.
 * Custom query methods can be added as needed.
 */
@Repository
public interface BonAPI_Recipe_Repository extends MongoRepository<Recipe, String> {

    /**
     * Finds a list of Recipes by their name.
     *
     * @param name the name of the Recipe to search for.
     * @return a list of matching Recipes.
     */
    List<Recipe> findByName(String name);

    /**
     * Finds Recipes by their associated Culinary Style ID.
     *
     * @param culinaryStyleId the ID of the Culinary Style to search for.
     * @return a list of matching Recipes.
     */
    List<Recipe> findByCulinaryStyleId(String culinaryStyleId);

    /**
     * Finds Recipes where the instructions contain a specific keyword (case-insensitive).
     *
     * @param keyword the keyword to search for in the instructions.
     * @return a list of matching Recipes.
     */
    List<Recipe> findByInstructionsContainingIgnoreCase(String keyword);

    /**
     * Finds all Recipes created by a specific user.
     *
     * @param createdBy the ID of the user who created the Recipes.
     * @return a list of Recipes created by the user.
     */
    List<Recipe> findByCreatedBy(String createdBy);

    /**
     * Finds all Recipes sorted by the number of likes in descending order.
     *
     * @return a list of Recipes sorted by likes.
     */
    List<Recipe> findAllByOrderByLikesDesc();
}
