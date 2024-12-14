package ch.bonapp.bonapi.repositories;

import ch.bonapp.bonapi.entities.both.Food;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing Food entities in MongoDB.
 * Extends the {@link MongoRepository} interface to provide standard CRUD operations.
 * Custom query methods can be added as needed.
 */
@Repository
public interface BonAPI_Food_Repository extends MongoRepository<Food, String> {

    /**
     * Finds a list of Food entities by their name.
     *
     * @param name the name of the Food to search for.
     * @return a list of matching Food entities.
     */
    List<Food> findByName(String name);

    /**
     * Finds Food entities where the description contains a specific keyword (case-insensitive).
     *
     * @param keyword the keyword to search for in the description.
     * @return a list of matching Food entities.
     */
    List<Food> findByDescriptionContainingIgnoreCase(String keyword);

    /**
     * Finds Food entities by their style ID.
     *
     * @param styleId the style ID to search for.
     * @return a list of matching Food entities.
     */
    List<Food> findByStyleId(String styleId);

    /**
     * Finds all Food entities sorted by their name in ascending order.
     *
     * @return a list of Food entities sorted by name.
     */
    List<Food> findAllByOrderByNameAsc();
}
