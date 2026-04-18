package tn.esprit.foyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.foyer.entities.Reservation;
import java.time.LocalDate;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {
    long countByAnneeUniversitaireBetween(LocalDate debut, LocalDate fin);
}
