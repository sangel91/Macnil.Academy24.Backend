package macnil.academy.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import macnil.academy.model.Entry;
import macnil.academy.model.ResponseEntry;


public interface EntryRepository extends JpaRepository<Entry, Long>{

    //scrivere query 
    // @Query("SELECT id, date,SUM(EXTRACT(EPOCH FROM (hour_out - hour_in)) / 60) AS w_time_minutesFROM entryWHERE user_id = ? AND EXTRACT(MONTH FROM date) = ? GROUP BY date;")
    // List<Object[]> entryByMonth(@Param("userId") LocalDate userId, @Param("date") LocalDate Date);

    @Query(value = "SELECT id, date, FLOOR(SUM(EXTRACT(EPOCH FROM (hour_out - hour_in)) / 60)) AS w_time_minutes FROM entry WHERE user_id = 1 AND EXTRACT(MONTH FROM date) = 11 GROUP BY id, date", 
            nativeQuery = true)
    List<Object[]> entryByMonth();

}



    
