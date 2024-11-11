package macnil.academy.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import macnil.academy.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);
    Optional<User> findByFirstname(String firstname);  
    Optional<User> findByEmail(String email);

    Optional<User> findByPassword(String password);

    List<User> findByRole(User.Role role);

}
