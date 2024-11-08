package macnil.academy.repository;

import macnil.academy.model.entryModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface entryRepository extends CrudRepository<entryModel, Integer> {
}
