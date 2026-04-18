package tn.esprit.foyer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.entities.*;
import tn.esprit.foyer.repositories.*;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservationService {

    private final ReservationRepository reservationRepo;
    private final ChambreRepository chambreRepo;
    private final EtudiantRepository etudiantRepo;

    @Override
    public Reservation addOrUpdate(Reservation r) { return reservationRepo.save(r); }

    @Override
    public List<Reservation> findAll() { return reservationRepo.findAll(); }

    @Override
    public Reservation findById(String id) { return reservationRepo.findById(id).orElse(null); }

    @Override
    public void deleteById(String id) { reservationRepo.deleteById(id); }

    // Service 05 — ajouter réservation et assigner à chambre + étudiant
    @Override
    public Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(
            Long numChambre, String cin) {

        Chambre chambre   = chambreRepo.findByNumeroChambre(numChambre);
        Etudiant etudiant = etudiantRepo.findByCin(Long.parseLong(cin));

        // Vérifier capacité
        int capaciteMax = switch (chambre.getTypeC()) {
            case SIMPLE -> 1;
            case DOUBLE -> 2;
            case TRIPLE -> 3;
        };

        long reservationsActives = chambre.getReservations()
                .stream().filter(Reservation::isEstValide).count();

        if (reservationsActives >= capaciteMax) {
            throw new RuntimeException(
                "Capacité maximale atteinte pour la chambre " + numChambre);
        }

        // Construire l'année universitaire
        int year = LocalDate.now().getYear() % 100;
        String anneeUniv = (LocalDate.now().getMonthValue() <= 7)
            ? "20" + (year - 1) + "/20" + year
            : "20" + year + "/20" + (year + 1);

        // ID : "2024/2025-BlocA-1-123456789"
        String nomBloc = (chambre.getBloc() != null) ? chambre.getBloc().getNomBloc() : "SansBloc";
        String idReservation = anneeUniv + "-" + nomBloc + "-" + numChambre + "-" + cin;

        Reservation reservation = new Reservation();
        reservation.setIdReservation(idReservation);
        reservation.setAnneeUniversitaire(LocalDate.now());
        reservation.setEstValide(true);
        reservation.getEtudiants().add(etudiant);

        Reservation saved = reservationRepo.save(reservation);
        chambre.getReservations().add(saved);
        chambreRepo.save(chambre);
        return saved;
    }

    // Service 08 — compter réservations dans une plage de dates
    @Override
    public long getReservationParAnneeUniversitaire(LocalDate debutAnnee, LocalDate finAnnee) {
        return reservationRepo.countByAnneeUniversitaireBetween(debutAnnee, finAnnee);
    }

    // Service 11 — annuler la réservation active d'un étudiant
    @Override
    public Reservation annulerReservation(long cinEtudiant) {
        Etudiant etudiant = etudiantRepo.findByCin(cinEtudiant);

        Reservation reservation = reservationRepo.findAll().stream()
            .filter(r -> r.isEstValide() && r.getEtudiants().contains(etudiant))
            .findFirst()
            .orElseThrow(() -> new RuntimeException(
                "Aucune réservation active pour CIN : " + cinEtudiant));

        // Désaffecter la chambre
        chambreRepo.findAll().forEach(c -> {
            if (c.getReservations().contains(reservation)) {
                c.getReservations().remove(reservation);
                chambreRepo.save(c);
            }
        });

        reservationRepo.delete(reservation);
        return reservation;
    }
}
