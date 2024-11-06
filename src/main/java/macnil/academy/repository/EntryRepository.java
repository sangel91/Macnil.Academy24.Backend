package macnil.academy.repository;

import macnil.academy.model.EntryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EntryRepository extends JpaRepository<EntryModel, Long> {

    List<EntryModel> findByStatus(String status);

}
