package ch.bonapp.bonapi.repositories;

import ch.bonapp.bonapi.entities.both.Culinarystyle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Repository interface for managing CulinaryStyle entities in MongoDB.
 * Extends the {@link MongoRepository} interface to provide standard CRUD operations.
 * Additional custom query methods can be added as needed.
 */
@Repository
public interface BonAPI_Culinarystyle_Repository extends MongoRepository<Culinarystyle, String> {

    /**
     * Finds a list of CulinaryStyles by their style.
     *
     * @param style the style of the CulinaryStyle to search for.
     * @return a list of matching CulinaryStyles.
     */
    List<Culinarystyle> findByStyle(String style);

    /**
     * Finds CulinaryStyles whose descriptions contain a specific keyword, case-insensitive.
     *
     * @param keyword the keyword to search for in the description.
     * @return a list of matching CulinaryStyles.
     */
    List<Culinarystyle> findByDescriptionContainingIgnoreCase(String keyword);

    /**
     * Finds CulinaryStyles by a regex pattern in their style field.
     *
     * @param regex the regular expression to use for matching styles.
     * @return a list of CulinaryStyles matching the regex pattern.
     */
    @Query("{ 'style': { $regex: ?0, $options: 'i' } }")
    List<Culinarystyle> findByStyleRegex(String regex);

    /**
     * Finds all CulinaryStyles sorted by their style in ascending order.
     *
     * @return a list of CulinaryStyles sorted by style.
     */
    List<Culinarystyle> findAllByOrderByStyleAsc();
}
