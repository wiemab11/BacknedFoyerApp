package foyer.services;

import foyer.entities.Bloc;
import java.util.List;

public interface IBlocService {
    Bloc addOrUpdate(Bloc b);
    List<Bloc> findAll();
    Bloc findById(String id);
    void deleteById(String id);
    Bloc affecterChambresABloc(List<String> numChambres, String nomBloc);
    Bloc affecterBlocAFoyer(String nomBloc, String nomFoyer);
}
