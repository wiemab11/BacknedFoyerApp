package foyer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "foyer")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Foyer {
    @Id
    private String idFoyer;
    private String nomFoyer;
    private long capaciteFoyer;

    @JsonIgnore
    private Universite universite;

    private List<Bloc> blocs = new ArrayList<>();
}
