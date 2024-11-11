package macnil.academy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import macnil.academy.model.ResponseEntry;
import macnil.academy.repository.EntryRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Service
public class FilterService {

    @Autowired
    EntryRepository entryRepository;

    public List<ResponseEntry> getFilterResult(Long user_id, int month) {

        List<Object[]> results = entryRepository.entryByMonth(user_id, month);
        List<ResponseEntry> responseEntries = new ArrayList<>();

        for (Object[] row : results) {
            Long id = ((Number) row[0]).longValue();  
            java.sql.Date sqlDate = (java.sql.Date) row[1];  
        
            // Converte java.sql.Date in java.time.LocalDate
            LocalDate date = sqlDate.toLocalDate();  

            BigDecimal workTimeMinutes = (BigDecimal) row[2];  


            ResponseEntry responseEntry = new ResponseEntry(id, date, workTimeMinutes);
            responseEntries.add(responseEntry);
        }

        return responseEntries;
    }
}


