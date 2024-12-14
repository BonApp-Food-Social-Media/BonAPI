package ch.bonapp.bonapi.entities.both;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "culinarystyles")
public class Culinarystyle {
    @Id
    private String id;
    private String style;
    private String description;
}
