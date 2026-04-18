package tn.esprit.foyer.services;

import tn.esprit.foyer.entities.Foyer;
import java.util.List;

public interface IFoyerService {
    Foyer addOrUpdate(Foyer f);
    List<Foyer> findAll();
    Foyer findById(long id);
    void deleteById(long id);
    Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite);
}
