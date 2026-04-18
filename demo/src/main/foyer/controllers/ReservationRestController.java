package tn.esprit.foyer.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyer.entities.Reservation;
import tn.esprit.foyer.services.IReservationService;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class ReservationRestController {

    private final IReservationService reservationService;

    @PostMapping("/addOrUpdate")
    public Reservation addOrUpdate(@RequestBody Reservation r) { return reservationService.addOrUpdate(r); }

    @GetMapping("/findAll")
    public List<Reservation> findAll() { return reservationService.findAll(); }

    @GetMapping("/findById/{id}")
    public Reservation findById(@PathVariable String id) { return reservationService.findById(id); }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id) { reservationService.deleteById(id); }

    // S05
    @PostMapping("/ajouterReservationEtAssignerAChambreEtAEtudiant")
    public Reservation ajouter(@RequestParam Long numChambre, @RequestParam String cin) {
        return reservationService.ajouterReservationEtAssignerAChambreEtAEtudiant(numChambre, cin);
    }

    // S08
    @GetMapping("/getReservationParAnneeUniversitaire")
    public long getByAnnee(
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate debutAnnee,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate finAnnee) {
        return reservationService.getReservationParAnneeUniversitaire(debutAnnee, finAnnee);
    }

    // S11
    @DeleteMapping("/annulerReservation")
    public String annuler(@RequestParam long cinEtudiant) {
        Reservation r = reservationService.annulerReservation(cinEtudiant);
        return "La réservation " + r.getIdReservation() + " est annulée avec succès";
    }
}
