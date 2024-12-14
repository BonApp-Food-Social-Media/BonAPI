package ch.bonapp.bonapi.entities.both;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "foods")
public class Food {
    @Id
    private String id;
    private String name;
    private String styleId;
    private String description;
}
