package ch.bonapp.bonapi.entities.both;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "ingredients")
public class Ingredient {
    @Id
    private String id;
    private String name;
    private String foodStyleId;
    private String description;
}
