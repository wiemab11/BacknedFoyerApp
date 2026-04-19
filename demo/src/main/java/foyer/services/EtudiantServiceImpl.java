package foyer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import foyer.entities.Etudiant;
import foyer.repositories.EtudiantRepository;
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
    public Etudiant findById(String id) {
        return etudiantRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(String id) {
        etudiantRepo.deleteById(id);
    }
}
