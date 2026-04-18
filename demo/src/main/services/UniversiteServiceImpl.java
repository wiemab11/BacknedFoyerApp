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
    public Universite findById(long id) {
        return universiteRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(long id) {
        universiteRepo.deleteById(id);
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer foyer = foyerRepo.findById(idFoyer).orElse(null);
        Universite universite = universiteRepo.findByNomUniversite(nomUniversite);
        universite.setFoyer(foyer);
        return universiteRepo.save(universite);
    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite = universiteRepo.findById(idUniversite).orElse(null);
        universite.setFoyer(null);
        return universiteRepo.save(universite);
    }
}
