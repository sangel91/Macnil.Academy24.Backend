package macnil.academy.service;
import macnil.academy.model.ResponseEntry;
import macnil.academy.repository.EntryRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// import org.modelmapper.ModelMapper;

@Service
public class EntryServiceImpl {
    @Autowired
    EntryRepository entryRepository;

    public List<ResponseEntry> getEntryResult() {

        List<Object[]> results = entryRepository.entryByMonth();
        List<ResponseEntry> responseEntries = new ArrayList<>();

        for (Object[] row : results) {
            Long id = ((Number) row[0]).longValue();  // id
            java.sql.Date sqlDate = (java.sql.Date) row[1];  // Recupera la data come java.sql.Date
        
            // Converte java.sql.Date in java.time.LocalDate
            LocalDate date = sqlDate.toLocalDate();  // Conversione esplicita

            BigDecimal workTimeMinutes = (BigDecimal) row[2];  // Recupera il valore come BigDecimal


            ResponseEntry responseEntry = new ResponseEntry(id, date, workTimeMinutes);
            responseEntries.add(responseEntry);
        }

        return responseEntries;
    }
    
}
