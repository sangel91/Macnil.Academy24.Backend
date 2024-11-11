package macnil.academy.service;



import macnil.academy.controller.dto.EntryDto;
import macnil.academy.model.Entry;

public interface EntryService {

    Entry create(EntryDto entryDto);

    
} 
    