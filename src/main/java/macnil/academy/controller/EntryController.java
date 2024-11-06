package macnil.academy.controller;

import macnil.academy.model.EntryModel;
import macnil.academy.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entry")
public class EntryController {

    @Autowired
    private EntryService entryService;

    
    @PostMapping
    public EntryModel addEntry(@RequestBody EntryModel entry) {
        return entryService.saveEntry(entry);
    }

    
    @GetMapping
    public List<EntryModel> getAllEntries() {
        return entryService.getAllEntries();
    }
}
