package ch.bonapp.bonapi.repositories;

import ch.bonapp.bonapi.entities.both.Foodstyle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing Foodstyle entities in MongoDB.
 * Provides built-in CRUD operations and allows custom queries.
 */
@Repository
public interface BonAPI_Foodstyle_Repository extends MongoRepository<Foodstyle, String> {

    /**
     * Finds a list of Foodstyle entities by their style.
     *
     * @param style the style to search for.
     * @return a list of matching Foodstyle entities.
     */
    List<Foodstyle> findByStyle(String style);

    /**
     * Finds Foodstyle entities where the description contains a specific keyword (case-insensitive).
     *
     * @param keyword the keyword to search for in the description.
     * @return a list of matching Foodstyle entities.
     */
    List<Foodstyle> findByDescriptionContainingIgnoreCase(String keyword);

    /**
     * Finds all Foodstyle entities sorted by their style in ascending order.
     *
     * @return a list of Foodstyle entities sorted by style.
     */
    List<Foodstyle> findAllByOrderByStyleAsc();
}
