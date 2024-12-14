package ch.bonapp.bonapi.entities.both;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int age;
    private String residenceId;
    private String dateOfCreation;
    private int swipedMealCount;
    private int likedMealsCount;
    private int savedMealCount;
}
