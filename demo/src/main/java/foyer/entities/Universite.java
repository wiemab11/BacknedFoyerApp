package foyer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "universite")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Universite {
    @Id
    private String idUniversite;
    private String nomUniversite;
    private String adresse;

    private Foyer foyer;
}
