package macnil.academy.controller;

import macnil.academy.model.EntryModel;

import macnil.academy.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entry")
public class EntryController {

    @Autowired
    private EntryService entryService;


    @PostMapping
    public EntryModel addEntry(@RequestBody EntryModel entry) {
        return entryService.saveEntry(entry);
    }

    @GetMapping("/{id}")
    public EntryModel getEntryModel(@PathVariable("id") Long id) {
        Optional<EntryModel> entry = entryService.getEntryById(id);
        return entry.orElse(null);  
    }

    
    @GetMapping
    public List<EntryModel> getAllEntries() {
        return entryService.getAllEntries();
    }

    @PutMapping("/{id}")
    public EntryModel updateEntry(@PathVariable("id") Long id, @RequestBody EntryModel updatedEntry) {
        return entryService.updateEntry(id, updatedEntry);
    }



    
}
