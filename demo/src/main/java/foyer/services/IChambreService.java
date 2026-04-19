package foyer.services;

import foyer.entities.Chambre;
import foyer.entities.TypeChambre;
import java.util.List;

public interface IChambreService {
    Chambre addOrUpdate(Chambre c);
    List<Chambre> findAll();
    Chambre findById(String id);
    void deleteById(String id);
    List<Chambre> getChambresParNomBloc(String nomBloc);
    long nbChambreParTypeEtBloc(TypeChambre type, String idBloc);
    List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre(String nomFoyer, TypeChambre type);
}
