package tn.esprit.foyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.foyer.entities.Chambre;
import tn.esprit.foyer.entities.TypeChambre;
import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    Chambre findByNumeroChambre(long numeroChambre);
    List<Chambre> findByBlocNomBloc(String nomBloc);
    long countByTypeCAndBlocIdBloc(TypeChambre typeC, long idBloc);
    List<Chambre> findByBlocFoyerNomFoyerAndTypeC(String nomFoyer, TypeChambre typeC);
}
