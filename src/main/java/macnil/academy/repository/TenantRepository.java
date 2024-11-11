package macnil.academy.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import macnil.academy.model.Tenant;



public interface TenantRepository extends JpaRepository <Tenant, Long> {
    
}
