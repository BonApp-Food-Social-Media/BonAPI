package ch.bonapp.bonapi.repositories;

import ch.bonapp.bonapi.entities.both.UserFollowing;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

/**
 * Repository interface for accessing the user_following collection in MongoDB.
 * This repository manages follower relationships between users.
 */
public interface BonAPI_UserFollowing_Repository extends MongoRepository<UserFollowing, String> {
    /**
     * Finds all follow relationships where the specified user is the follower.
     * @param followerId The ID of the user who follows others.
     * @return A list of UserFollowing instances representing the follow relationships.
     */
    List<UserFollowing> findByFollowerId(String followerId);

    /**
     * Finds all follow relationships where the specified user is being followed.
     * @param followedId The ID of the user who is followed.
     * @return A list of UserFollowing instances representing the follow relationships.
     */
    List<UserFollowing> findByFollowedId(String followedId);

    /**
     * Deletes a follow relationship between two users.
     * @param followerId The ID of the user who follows.
     * @param followedId The ID of the user being followed.
     */
    void deleteByFollowerIdAndFollowedId(String followerId, String followedId);
}
