package foyer.services;

import foyer.entities.Etudiant;
import java.util.List;

public interface IEtudiantService {
    Etudiant addOrUpdate(Etudiant e);
    List<Etudiant> findAll();
    Etudiant findById(String id);
    void deleteById(String id);
}
