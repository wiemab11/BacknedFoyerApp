package foyer.services;

import foyer.entities.Universite;
import java.util.List;

public interface IUniversiteService {
    Universite addOrUpdate(Universite u);
    List<Universite> findAll();
    Universite findById(String id);
    void deleteById(String id);
    Universite affecterFoyerAUniversite(String idFoyer, String nomUniversite);
    Universite desaffecterFoyerAUniversite(String idUniversite);
}
