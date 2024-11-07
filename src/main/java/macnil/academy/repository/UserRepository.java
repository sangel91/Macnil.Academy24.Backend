package macnil.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import macnil.academy.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}


