package foyer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "bloc")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Bloc {
    @Id
    private String idBloc;
    private String nomBloc;
    private long capaciteBloc;

    @JsonIgnore
    private Foyer foyer;

    private List<Chambre> chambres = new ArrayList<>();
}
