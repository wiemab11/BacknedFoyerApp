package foyer.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import foyer.entities.Chambre;
import foyer.entities.TypeChambre;
import java.util.List;

@Repository
public interface ChambreRepository extends MongoRepository<Chambre, String> {
    Chambre findByNumeroChambre(long numeroChambre);
    List<Chambre> findByBlocNomBloc(String nomBloc);
    long countByTypeCAndBlocIdBloc(TypeChambre typeC, String idBloc);
    List<Chambre> findByBlocFoyerNomFoyerAndTypeC(String nomFoyer, TypeChambre typeC);
}
