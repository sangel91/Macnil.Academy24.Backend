package macnil.academy.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import macnil.academy.model.News;

public interface NewsRepository extends JpaRepository <News, Long> {
  List<News> findByTenantId(Long tenantId);
    
}
