package macnil.academy.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import macnil.academy.model.Entry;

public interface EntryRepository extends JpaRepository<Entry, Long> {
    // // Metodo per trovare una Entry per la data
    // List<Entry> findByDate(LocalDate date);

    // // Metodo per trovare tutte le Entry per la location
    // List<Entry> findByLocation(String location);

    // // Metodo per trovare tutte le Entry in un intervallo di tempo
    // List<Entry> findByHour_inBetween(LocalTime startTime, LocalTime endTime);

    // // Metodo per trovare tutte le Entry che hanno note specifiche
    // List<Entry> findByNotesContaining(String keyword);

    // // Metodo personalizzato per trovare tutte le Entry per una data e una location specifica
    // List<Entry> findByDateAndLocation(LocalDate date, String location);

    // // Metodo personalizzato con una query JPQL (Java Persistence Query Language)
    // @Query("SELECT e FROM Entry e WHERE e.date = :date AND e.hour_in BETWEEN :startTime AND :endTime")
    // List<Entry> findEntriesByDateAndTimeRange(LocalDate date, LocalTime startTime, LocalTime endTime);

    // // Metodo per ottenere tutte le entries ordinate per data (ascendente)
    // List<Entry> findAllByOrderByDateAsc();

}