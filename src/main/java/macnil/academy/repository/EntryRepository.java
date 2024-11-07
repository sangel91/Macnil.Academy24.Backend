package macnil.academy.repository;

import macnil.academy.model.EntryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EntryRepository extends JpaRepository<EntryModel, Long> {

    List<EntryModel> findByStatus(String status);

}
