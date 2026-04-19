package foyer.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import foyer.entities.Foyer;

@Repository
public interface FoyerRepository extends MongoRepository<Foyer, String> {
    Foyer findByNomFoyer(String nomFoyer);
}
