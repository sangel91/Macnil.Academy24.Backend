package macnil.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;



import java.util.List;
import macnil.academy.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmail(String email); 
    List<User>findByFirstnameAndCity(String firstname, String city); 

    
    
    
    
}


