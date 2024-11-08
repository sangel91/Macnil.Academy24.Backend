package macnil.academy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import macnil.academy.model.ResponseEntry;
import macnil.academy.service.EntryServiceImpl;


@RestController
@RequestMapping("/api/v1/report")
public class EntryRestController {

    @Autowired
    private EntryServiceImpl entryServiceImpl;

    @GetMapping
    public List<ResponseEntry> entryByMonth(){
            return entryServiceImpl.getEntryResult();
        
    }
    
}
