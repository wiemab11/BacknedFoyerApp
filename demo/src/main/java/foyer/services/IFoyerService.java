package foyer.services;

import foyer.entities.Foyer;
import java.util.List;

public interface IFoyerService {
    Foyer addOrUpdate(Foyer f);
    List<Foyer> findAll();
    Foyer findById(String id);
    void deleteById(String id);
    Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, String idUniversite);
    Foyer desaffecterFoyerAUniversite(String idUniversite);
}
