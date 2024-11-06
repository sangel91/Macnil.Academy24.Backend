package macnil.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import macnil.academy.model.Broadcast;

public interface BroadcastRepository extends JpaRepository<Broadcast, Long> {
    
}
