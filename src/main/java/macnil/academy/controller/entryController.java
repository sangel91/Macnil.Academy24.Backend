package macnil.academy.controller;

import macnil.academy.model.entryModel;
import macnil.academy.service.entryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/api/v1/entries")  
public class entryController {

    @Autowired
    entryServiceImpl entryService;

    
    @GetMapping
    public Iterable<entryModel> getAllEntries() {
        return entryService.getAllEntries();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<entryModel> getEntryById(@PathVariable Integer id) {
        Optional<entryModel> entry = entryService.getEntryById(id);
        if (entry.isPresent()) {
            return new ResponseEntity<>(entry.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  
        }
    }

    
    @PostMapping
    public ResponseEntity<entryModel> createEntry(@RequestBody entryModel entry) {
        entryModel savedEntry = entryService.saveEntry(entry);
        return new ResponseEntity<>(savedEntry, HttpStatus.CREATED);  
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<entryModel> updateEntry(@PathVariable Integer id, @RequestBody entryModel entryDetails) {
        try {
            entryModel updatedEntry = entryService.updateEntry(id, entryDetails);
            return new ResponseEntity<>(updatedEntry, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable Integer id) {
        try {
            entryService.deleteEntry(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  
        }
    }
}
