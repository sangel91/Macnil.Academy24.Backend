package macnil.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;



import java.util.List;
import macnil.academy.model.User;

//JpaRepository è una delle interfacce di Spring che fornisce un set di metodi CRUD (Create, Read, Update, Delete) 
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByFirstname(String firstname); 
    List<User>findByFirstnameAndCity(String firstname, String city); 
    List<User>findByTenantId(Long tenantId); 
    boolean existsByTenantId(Long tenantId);

    
    
    
    
}


