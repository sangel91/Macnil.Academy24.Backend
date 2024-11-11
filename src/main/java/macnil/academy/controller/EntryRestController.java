package macnil.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import macnil.academy.controller.dto.EntryDto;
import macnil.academy.model.Entry;
import macnil.academy.service.EntryServiceImpl;

@CrossOrigin(origins = "*") // Permette tutte le origini
@RestController
@RequestMapping("/api/v1/entry")
public class EntryRestController {

    @Autowired
    private EntryServiceImpl entryServiceImpl;

    // Metodo per creare un nuovo entry
    @PostMapping
    public ResponseEntity<Entry> createEntry(@RequestBody EntryDto entryDto) {

        // Creiamo un nuovo Entry tramite il service
        Entry entry = entryServiceImpl.create(entryDto);

        // Restituiamo l'entry creato con stato HTTP 200 OK
        return ResponseEntity.ok(entry);
    }
}
