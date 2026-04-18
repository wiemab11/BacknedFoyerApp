package tn.esprit.foyer.services;

import tn.esprit.foyer.entities.Chambre;
import tn.esprit.foyer.entities.TypeChambre;
import java.util.List;

public interface IChambreService {
    Chambre addOrUpdate(Chambre c);
    List<Chambre> findAll();
    Chambre findById(long id);
    void deleteById(long id);
    List<Chambre> getChambresParNomBloc(String nomBloc);
    long nbChambreParTypeEtBloc(TypeChambre type, long idBloc);
    List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre(String nomFoyer, TypeChambre type);
}
