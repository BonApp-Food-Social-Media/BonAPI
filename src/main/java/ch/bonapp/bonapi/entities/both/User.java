package ch.bonapp.bonapi.entities.both;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

/**
 * Entity class representing a User.
 * This class is mapped to the "users" collection in MongoDB.
 */
@Data
@Getter
@Setter
@Document(collection = "users")
public class User {

    /**
     * Unique identifier for the User.
     */
    @Id
    private String id;

    /**
     * Username chosen by the User.
     */
    private String username;

    /**
     * Password for the User account.
     */
    private String password;

    /**
     * First name of the User.
     */
    private String firstName;

    /**
     * Last name of the User.
     */
    private String lastName;

    /**
     * Age of the User.
     */
    private int age;

    /**
     * Identifier for the User's residence.
     */
    private String residenceId;

    /**
     * Date of account creation (e.g., in ISO 8601 format).
     */
    private String dateOfCreation;

    /**
     * Total count of meals the User has swiped through.
     */
    private int swipedMealCount;

    /**
     * Total count of meals the User has liked.
     */
    private int likedMealsCount;

    /**
     * Total count of meals the User has saved.
     */
    private int savedMealCount;

    /**
     * Explicit setter for the `id` field to resolve potential issues with Lombok.
     * see commit-msg 14.12.2024
     * @param id The ID to set for the Entity/ Object.
     */
    public void setId(String id) {
        this.id = id;
    }
}
