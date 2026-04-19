package foyer.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "reservation")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Reservation {
    @Id
    private String idReservation;
    private LocalDate anneeUniversitaire;
    private boolean estValide;

    private List<Etudiant> etudiants = new ArrayList<>();
}
