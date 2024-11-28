package macnil.academy.repository;

import macnil.academy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Puoi aggiungere metodi personalizzati se necessario
    User findByEmail(String email);
}