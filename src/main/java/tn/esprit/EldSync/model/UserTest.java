package tn.esprit.EldSync.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class UserTest {
    @Id
    private String nickName;
    private String fullName;
    private Status status;
}
