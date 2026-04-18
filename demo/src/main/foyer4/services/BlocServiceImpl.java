package tn.esprit.foyer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.entities.Bloc;
import tn.esprit.foyer.entities.Chambre;
import tn.esprit.foyer.entities.Foyer;
import tn.esprit.foyer.repositories.BlocRepository;
import tn.esprit.foyer.repositories.ChambreRepository;
import tn.esprit.foyer.repositories.FoyerRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BlocServiceImpl implements IBlocService {

    private final BlocRepository blocRepo;
    private final FoyerRepository foyerRepo;
    private final ChambreRepository chambreRepo;

    // ---- CRUD ----
    @Override
    public Bloc addOrUpdate(Bloc b) {
        // cascade ALL : les chambres dans b.getChambres() seront créées aussi
        return blocRepo.save(b);
    }

    @Override
    public List<Bloc> findAll() {
        return blocRepo.findAll();
    }

    @Override
    public Bloc findById(long id) {
        return blocRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(long id) {
        // cascade ALL : les chambres du bloc seront supprimées aussi
        blocRepo.deleteById(id);
    }

    // ---- Service 03 : affecter des chambres existantes à un bloc ----
    @Override
    public Bloc affecterChambresABloc(List<Long> numChambres, String nomBloc) {
        Bloc bloc = blocRepo.findByNomBloc(nomBloc);
        for (Long num : numChambres) {
            Chambre chambre = chambreRepo.findByNumeroChambre(num);
            if (chambre != null) {
                chambre.setBloc(bloc);
                chambreRepo.save(chambre);
                if (!bloc.getChambres().contains(chambre)) {
                    bloc.getChambres().add(chambre);
                }
            }
        }
        return blocRepo.save(bloc);
    }

    // ---- Service 04 : affecter un bloc à un foyer ----
    @Override
    public Bloc affecterBlocAFoyer(String nomBloc, String nomFoyer) {
        Bloc bloc = blocRepo.findByNomBloc(nomBloc);
        Foyer foyer = foyerRepo.findByNomFoyer(nomFoyer);
        bloc.setFoyer(foyer);
        return blocRepo.save(bloc);
    }
}
