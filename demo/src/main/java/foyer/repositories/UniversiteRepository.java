package foyer.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import foyer.entities.Universite;

@Repository
public interface UniversiteRepository extends MongoRepository<Universite, String> {
    Universite findByNomUniversite(String nomUniversite);
}
