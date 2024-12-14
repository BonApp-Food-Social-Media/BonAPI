package ch.bonapp.bonapi.entities.both;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

/**
 * Entity class representing a Food item in the application.
 * This class is mapped to the "foods" collection in MongoDB.
 */
@Data
@Getter
@Setter
@Document(collection = "foods")
public class Food {

    /**
     * Unique identifier for the food item.
     */
    @Id
    private String id;

    /**
     * Name of the food item.
     */
    private String name;

    /**
     * Identifier for the food style associated with the food item.
     * This links to the FoodStyle entity.
     */
    private String styleId;

    /**
     * Description of the food item, providing additional details.
     */
    private String description;

    /**
     * Explicit setter for the `id` field to resolve potential issues with Lombok.
     * see commit-msg 14.12.2024
     * https://github.com/GurkeSchaleSammler/BonAPI/commit/07325998950b426a63a6cbc4328ca4662e71a551
     * @param id The ID to set for the Entity/ Object.
     */
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyleId() {
        return styleId;
    }

    public void setStyleId(String styleId) {
        this.styleId = styleId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
