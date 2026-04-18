package tn.esprit.foyer.services;

import tn.esprit.foyer.entities.Etudiant;
import java.util.List;

public interface IEtudiantService {
    Etudiant addOrUpdate(Etudiant e);
    List<Etudiant> findAll();
    Etudiant findById(long id);
    void deleteById(long id);
}
