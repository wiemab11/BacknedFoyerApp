package foyer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import foyer.entities.Chambre;
import foyer.entities.TypeChambre;
import foyer.repositories.ChambreRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChambreServiceImpl implements IChambreService {

    private final ChambreRepository chambreRepo;

    @Override
    public Chambre addOrUpdate(Chambre c) { return chambreRepo.save(c); }

    @Override
    public List<Chambre> findAll() { return chambreRepo.findAll(); }

    @Override
    public Chambre findById(String id) { return chambreRepo.findById(id).orElse(null); }

    @Override
    public void deleteById(String id) { chambreRepo.deleteById(id); }

    // Service 06 — chambres d'un bloc par son nom
    @Override
    public List<Chambre> getChambresParNomBloc(String nomBloc) {
        return chambreRepo.findByBlocNomBloc(nomBloc);
    }

    // Service 07 — nombre de chambres d'un type dans un bloc donné
    @Override
    public long nbChambreParTypeEtBloc(TypeChambre type, String idBloc) {
        return chambreRepo.countByTypeCAndBlocIdBloc(type, idBloc);
    }

    // Service 09 — chambres non réservées d'un foyer par type pour l'AU en cours
    @Override
    public List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre(
            String nomFoyer, TypeChambre type) {

        // Calcul dynamique de l'année universitaire en cours
        int year = LocalDate.now().getYear() % 100;
        LocalDate dateDebutAU, dateFinAU;
        if (LocalDate.now().getMonthValue() <= 7) {
            dateDebutAU = LocalDate.of(Integer.parseInt("20" + (year - 1)), 9, 15);
            dateFinAU   = LocalDate.of(Integer.parseInt("20" + year), 6, 30);
        } else {
            dateDebutAU = LocalDate.of(Integer.parseInt("20" + year), 9, 15);
            dateFinAU   = LocalDate.of(Integer.parseInt("20" + (year + 1)), 6, 30);
        }

        List<Chambre> toutes = chambreRepo.findByBlocFoyerNomFoyerAndTypeC(nomFoyer, type);

        final LocalDate debut = dateDebutAU;
        final LocalDate fin   = dateFinAU;

        return toutes.stream().filter(chambre ->
            chambre.getReservations().stream().noneMatch(r ->
                r.isEstValide() &&
                !r.getAnneeUniversitaire().isBefore(debut) &&
                !r.getAnneeUniversitaire().isAfter(fin)
            )
        ).collect(Collectors.toList());
    }
}
