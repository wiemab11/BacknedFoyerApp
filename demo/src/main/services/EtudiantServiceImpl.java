package tn.esprit.foyer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.entities.Etudiant;
import tn.esprit.foyer.repositories.EtudiantRepository;
import java.util.List;

@Service
@RequiredArgsConstructor

public class EtudiantServiceImpl implements IEtudiantService {

    private final EtudiantRepository etudiantRepo;

    @Override
    public Etudiant addOrUpdate(Etudiant e) {
        return etudiantRepo.save(e);
    }

    @Override
    public List<Etudiant> findAll() {
        return etudiantRepo.findAll();
    }

    @Override
    public Etudiant findById(long id) {
        return etudiantRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(long id) {
        etudiantRepo.deleteById(id);
    }
}
