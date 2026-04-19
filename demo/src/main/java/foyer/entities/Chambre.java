package foyer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "chambre")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Chambre {

    @Id
    private String idChambre;

    private long numeroChambre;

    private TypeChambre typeC;

    private Bloc bloc;

    @JsonIgnore
    private List<Reservation> reservations = new ArrayList<>();
}