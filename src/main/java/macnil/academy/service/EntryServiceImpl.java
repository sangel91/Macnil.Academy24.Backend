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
    public EntryDto create(Entry entry) {
        // Salva la nuova entry nel DB
        Entry savedEntry = entryRepository.save(entry);  

        // Mappatura manuale da Entry a EntryDto
        EntryDto entryDto = new EntryDto();
        entryDto.setId(savedEntry.getId());  // Esegui la mappatura manuale

        return entryDto;
    }
    
}