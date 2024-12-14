package ch.bonapp.bonapi.entities.both;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Entity class representing a follower relationship between two users.
 * This class is mapped to the "user_following" collection in MongoDB.
 */
@Data
@Getter
@Setter
@Document(collection = "user_following")
public class UserFollowing {

    /**
     * MongoDB document ID.
     */
    @Id
    private String id;

    /**
     * The ID of the user who is following another user.
     */
    private String followerId;

    /**
     * The ID of the user who is being followed.
     */
    private String followedId;

    /**
     * Constructs a new UserFollowing relationship.
     */
    public UserFollowing() {
    }

    /**
     * Constructs a new UserFollowing relationship with specified follower and followed user IDs.
     * @param followerId The ID of the user who follows.
     * @param followedId The ID of the user being followed.
     */
    public UserFollowing(String followerId, String followedId) {
        this.followerId = followerId;
        this.followedId = followedId;
    }

    /**
     * Gets the ID of the document.
     * @return The MongoDB document ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ID of the document.
     * @param id The MongoDB document ID to set.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the ID of the follower.
     * @return The ID of the user who follows.
     */
    public String getFollowerId() {
        return followerId;
    }

    /**
     * Sets the ID of the follower.
     * @param followerId The ID of the user who is following.
     */
    public void setFollowerId(String followerId) {
        this.followerId = followerId;
    }

    /**
     * Gets the ID of the user being followed.
     * @return The ID of the user being followed.
     */
    public String getFollowedId() {
        return followedId;
    }

    /**
     * Sets the ID of the user being followed.
     * @param followedId The ID of the user being followed.
     */
    public void setFollowedId(String followedId) {
        this.followedId = followedId;
    }
}
