package ch.bonapp.bonapi.entities.both;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

/**
 * Entity class representing an Ingredient.
 * This class is mapped to the "ingredients" collection in MongoDB.
 */
@Data
@Getter
@Setter
@Document(collection = "ingredients")
public class Ingredient {

    /**
     * Unique identifier for the Ingredient.
     */
    @Id
    private String id;

    /**
     * Name of the Ingredient.
     */
    private String name;

    /**
     * Identifier for the associated Food Style.
     */
    private String foodStyleId;

    /**
     * Description providing additional details about the Ingredient.
     */
    private String description;

    /**
     * Explicit setter for the `id` field to resolve potential issues with Lombok.
     *
     * @param id The ID to set for the Entity/ Object.
     */
    public void setId(String id) {
        this.id = id;
    }
}
