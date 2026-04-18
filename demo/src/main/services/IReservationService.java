package tn.esprit.foyer.services;

import tn.esprit.foyer.entities.Reservation;
import java.time.LocalDate;
import java.util.List;

public interface IReservationService {
    Reservation addOrUpdate(Reservation r);
    List<Reservation> findAll();
    Reservation findById(String id);
    void deleteById(String id);
    Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(Long numChambre, String cin);
    long getReservationParAnneeUniversitaire(LocalDate debutAnnee, LocalDate finAnnee);
    Reservation annulerReservation(long cinEtudiant);
}
