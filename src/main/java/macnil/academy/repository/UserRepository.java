package macnil.academy.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import macnil.academy.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByFirstname(String firstname);  
    Optional<User> findByEmail(String email);
    Optional<User> findByPassword(String password);
    List<User> findByRole(User.Role role);
    
}


