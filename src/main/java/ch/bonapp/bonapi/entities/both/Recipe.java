package ch.bonapp.bonapi.entities.both;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.util.List;

/**
 * Entity class representing a Recipe.
 * This class is mapped to the "recipes" collection in MongoDB.
 */
@Data
@Getter
@Setter
@Document(collection = "recipes")
public class Recipe {

    /**
     * Unique identifier for the Recipe.
     */
    @Id
    private String id;

    /**
     * Name of the Recipe.
     */
    private String name;

    /**
     * Identifier for the associated Culinary Style.
     */
    private String culinaryStyleId;

    /**
     * Identifier for the time scale (e.g., cooking time in minutes).
     */
    private String timeScaleId;

    /**
     * List of instructions for preparing the Recipe.
     */
    private List<String> instructions;

    /**
     * Identifier for the User who created the Recipe.
     */
    private String createdBy;

    /**
     * Image URL or path representing the Recipe.
     */
    private String image;

    /**
     * Number of likes the Recipe has received.
     */
    private int likes;

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

    public String getCulinaryStyleId() {
        return culinaryStyleId;
    }

    public void setCulinaryStyleId(String culinaryStyleId) {
        this.culinaryStyleId = culinaryStyleId;
    }

    public String getTimeScaleId() {
        return timeScaleId;
    }

    public void setTimeScaleId(String timeScaleId) {
        this.timeScaleId = timeScaleId;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
