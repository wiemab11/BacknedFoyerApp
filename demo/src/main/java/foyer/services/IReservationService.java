package foyer.services;

import foyer.entities.Reservation;
import java.time.LocalDate;
import java.util.List;

public interface IReservationService {
    Reservation addOrUpdate(Reservation r);
    List<Reservation> findAll();
    Reservation findById(String id);
    void deleteById(String id);
    Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(String numChambre, String cin);
    long getReservationParAnneeUniversitaire(LocalDate debutAnnee, LocalDate finAnnee);
    Reservation annulerReservation(String cinEtudiant);
}
