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
public class UniversiteServiceImpl implements IUniversiteService {

    private final UniversiteRepository universiteRepo;
    private final FoyerRepository foyerRepo;

    @Override
    public Universite addOrUpdate(Universite u) {
        return universiteRepo.save(u);
    }

    @Override
    public List<Universite> findAll() {
        return universiteRepo.findAll();
    }

    @Override
    public Universite findById(String id) {
        return universiteRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(String id) {
        universiteRepo.deleteById(id);
    }

    @Override
    public Universite affecterFoyerAUniversite(String idFoyer, String nomUniversite) {
        Foyer foyer = foyerRepo.findById(idFoyer).orElse(null);
        Universite universite = universiteRepo.findByNomUniversite(nomUniversite);
        if (universite != null && foyer != null) {
            universite.setFoyer(foyer);
        }
        return universiteRepo.save(universite);
    }

    @Override
    public Universite desaffecterFoyerAUniversite(String idUniversite) {
        Universite universite = universiteRepo.findById(idUniversite).orElse(null);
        if (universite != null) {
            universite.setFoyer(null);
        }
        return universiteRepo.save(universite);
    }
}
