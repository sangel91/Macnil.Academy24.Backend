package macnil.academy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import macnil.academy.controller.dto.EntryDto;
import macnil.academy.model.Entry;
import macnil.academy.repository.EntryRepository;

@Service
public class EntryServiceImpl implements EntryService {

    @Autowired
    private EntryRepository entryRepository;

    @Override
    public Entry create(EntryDto entryDto) {
        // Creiamo un nuovo oggetto Entry basato sul DTO
        Entry entry = new Entry(
            entryDto.getDate(),            // LocalDate
            entryDto.getHour_in(),        // LocalTime
            entryDto.getHour_out(),       // LocalTime
            entryDto.getNotes(),          // String
            entryDto.getLocation(),       // String
            null                          // User sarà gestito in un altro momento (ad esempio tramite autenticazione)
        );

        // Salviamo l'entry nel database e lo restituiamo
        return entryRepository.save(entry);
    }
}
