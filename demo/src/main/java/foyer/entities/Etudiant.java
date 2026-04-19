package foyer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "etudiant")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Etudiant {
    @Id
    private String idEtudiant;
    private String nomEt;
    private String prenomEt;
    private long cin;
    private String ecole;
    private LocalDate dateNaissance;

    @JsonIgnore
    private List<Reservation> reservations = new ArrayList<>();
}
