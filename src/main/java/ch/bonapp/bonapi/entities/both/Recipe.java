package ch.bonapp.bonapi.entities.both;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.util.List;

@Data
@Document(collection = "recipes")
public class Recipe {
    @Id
    private String id;
    private String name;
    private String culinaryStyleId;
    private String timeScaleId;
    private List<String> instructions;
    private String createdBy;
    private String image;
    private int likes;
}
