package ch.bonapp.bonapi.repositories;

import ch.bonapp.bonapi.entities.both.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing User entities in MongoDB.
 * Extends the {@link MongoRepository} interface to provide standard CRUD operations.
 * Custom query methods can be added as needed.
 */
@Repository
public interface BonAPI_User_Repository extends MongoRepository<User, String> {

    /**
     * Finds a User by their username.
     *
     * @param username the username to search for.
     * @return the matching User entity.
     */
    User findByUsername(String username);

    /**
     * Finds all Users older than a certain age.
     *
     * @param age the minimum age to search for.
     * @return a list of Users older than the specified age.
     */
    List<User> findByAgeGreaterThan(int age);

    /**
     * Finds all Users by their residence ID.
     *
     * @param residenceId the residence ID to search for.
     * @return a list of Users in the specified residence.
     */
    List<User> findByResidenceId(String residenceId);

    /**
     * Finds all Users sorted by their creation date in descending order.
     *
     * @return a list of Users sorted by date of creation.
     */
    List<User> findAllByOrderByDateOfCreationDesc();
}
