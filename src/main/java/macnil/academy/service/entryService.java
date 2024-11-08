package macnil.academy.service;

import macnil.academy.model.entryModel;

import java.util.Optional;

public interface entryService {
    
    Iterable<entryModel> getAllEntries();
    
    Optional<entryModel> getEntryById(Integer id);
    
    entryModel saveEntry(entryModel entry);
    
    entryModel updateEntry(Integer id, entryModel entryDetails);
    
    void deleteEntry(Integer id);
}