package foyer.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import foyer.entities.Etudiant;

@Repository
public interface EtudiantRepository extends MongoRepository<Etudiant, String> {
    Etudiant findByCin(long cin);
}
