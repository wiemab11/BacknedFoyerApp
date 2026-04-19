package foyer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import foyer.entities.Foyer;
import foyer.entities.Universite;
import foyer.repositories.FoyerRepository;
import foyer.repositories.UniversiteRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoyerServiceImpl implements IFoyerService {

    private final FoyerRepository foyerRepo;
    private final UniversiteRepository universiteRepo;

    @Override
    public Foyer addOrUpdate(Foyer f) {
        return foyerRepo.save(f);
    }

    @Override
    public List<Foyer> findAll() {
        return foyerRepo.findAll();
    }

    @Override
    public Foyer findById(String id) {
        return foyerRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(String id) {
        foyerRepo.deleteById(id);
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, String idUniversite) {
        Universite universite = universiteRepo.findById(idUniversite).orElse(null);
        if (universite != null && foyer.getBlocs() != null) {
            foyer.getBlocs().forEach(bloc -> bloc.setFoyer(foyer));
        }
        Foyer savedFoyer = foyerRepo.save(foyer);
        if (universite != null) {
            universite.setFoyer(savedFoyer);
            universiteRepo.save(universite);
        }
        return savedFoyer;
    }

    @Override
    public Foyer desaffecterFoyerAUniversite(String idUniversite) {
        Universite universite = universiteRepo.findById(idUniversite).orElse(null);
        if (universite != null) {
            Foyer foyer = universite.getFoyer();
            universite.setFoyer(null);
            universiteRepo.save(universite);
            return foyer;
        }
        return null;
    }
}
