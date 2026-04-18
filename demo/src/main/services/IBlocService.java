package tn.esprit.foyer.services;

import tn.esprit.foyer.entities.Bloc;
import java.util.List;

public interface IBlocService {
    Bloc addOrUpdate(Bloc b);
    List<Bloc> findAll();
    Bloc findById(long id);
    void deleteById(long id);
    Bloc affecterChambresABloc(List<Long> numChambres, String nomBloc);
    Bloc affecterBlocAFoyer(String nomBloc, String nomFoyer);
}
