package macnil.academy.repository;

import java.security.KeyStore.Entry;

import org.springframework.data.jpa.repository.JpaRepository;

import macnil.academy.controller.dto.EntryDto;
import macnil.academy.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}


