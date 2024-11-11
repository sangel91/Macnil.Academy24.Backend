package macnil.academy.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import macnil.academy.model.Entry;


public interface EntryRepository extends JpaRepository<Entry, Long>{

    @Query(value = "SELECT id, date, FLOOR(SUM(EXTRACT(EPOCH FROM (hour_out - hour_in)) / 60)) AS w_time_minutes FROM entry WHERE user_id = :user_id  AND EXTRACT(MONTH FROM date) = :month AND EXTRACT(YEAR FROM date) = EXTRACT(YEAR FROM CURRENT_DATE) GROUP BY id, date order by date desc", 
    nativeQuery = true)
    List<Object[]> entryByMonth(@Param("user_id") Long user_id, @Param("month") int month);

}







    
