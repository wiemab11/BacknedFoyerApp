package tn.esprit.foyer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.entities.Foyer;
import tn.esprit.foyer.entities.Universite;
import tn.esprit.foyer.repositories.FoyerRepository;
import tn.esprit.foyer.repositories.UniversiteRepository;
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
    public Foyer findById(long id) {
        return foyerRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(long id) {
        foyerRepo.deleteById(id);
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite universite = universiteRepo.findById(idUniversite).orElse(null);
        if (foyer.getBlocs() != null) {
            foyer.getBlocs().forEach(bloc -> bloc.setFoyer(foyer));
        }
        Foyer savedFoyer = foyerRepo.save(foyer);
        universite.setFoyer(savedFoyer);
        universiteRepo.save(universite);
        return savedFoyer;
    }
}
