package macnil.academy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import macnil.academy.controller.dto.EntryDto;
import macnil.academy.model.Entry;
import macnil.academy.service.EntryService;



@RestController
@RequestMapping("/api/entry")
public class EntryRestController {
    
    @Autowired
    EntryService entryService;

        @PostMapping
        public EntryDto createEntry(@RequestBody Entry entry) {
            return entryService.create(entry);
        }
}
