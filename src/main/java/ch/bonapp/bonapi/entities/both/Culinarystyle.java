package ch.bonapp.bonapi.entities.both;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

/**
 * Entity class representing a Culinary Style.
 * This class is mapped to the "culinarystyles" collection in MongoDB.
 */
@Data
@Getter
@Setter
@Document(collection = "culinarystyles")
public class Culinarystyle {

    /**
     * Unique identifier for the Culinary Style.
     */
    @Id
    private String id;

    /**
     * Name of the Culinary Style (e.g., Italian, Asian, Mediterranean).
     */
    private String style;

    /**
     * Description providing additional details about the Culinary Style.
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
