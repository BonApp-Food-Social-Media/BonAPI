package ch.bonapp.bonapi.entities.both;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

/**
 * Entity class representing a FoodStyle in the application.
 * This class is mapped to the "foodstyles" collection in MongoDB.
 */
@Data
@Getter
@Setter
@Document(collection = "foodstyles")
public class Foodstyle {

    /**
     * Unique identifier for the FoodStyle.
     */
    @Id
    private String id;

    /**
     * Name or type of the FoodStyle (e.g., Vegan, Vegetarian, Pescatarian).
     */
    private String style;

    /**
     * Description providing additional details about the FoodStyle.
     */
    private String description;

    /**
     * Explicit setter for the `id` field to resolve potential issues with Lombok.
     * see commit-msg 14.12.2024
     * @param id The ID to set for the Entity/ Object.
     */
    public void setId(String id) {
        this.id = id;
    }
}
