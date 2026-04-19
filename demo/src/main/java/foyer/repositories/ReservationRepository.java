package foyer.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import foyer.entities.Reservation;
import java.time.LocalDate;

@Repository
public interface ReservationRepository extends MongoRepository<Reservation, String> {
    long countByAnneeUniversitaireBetween(LocalDate debut, LocalDate fin);
}
