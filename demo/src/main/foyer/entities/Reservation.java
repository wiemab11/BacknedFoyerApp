package tn.esprit.foyer.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Reservation {
    @Id
    private String idReservation;
    private LocalDate anneeUniversitaire;
    private boolean estValide;
}
