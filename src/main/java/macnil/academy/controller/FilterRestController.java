package macnil.academy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import macnil.academy.model.ResponseEntry;
import macnil.academy.service.FilterService;

import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin()
@RestController
@RequestMapping("/api/v1")
public class FilterRestController {

    private final FilterService filterService;

    @Autowired
    public FilterRestController(FilterService filterService) {
        this.filterService = filterService;
    }

  @GetMapping("/user/{userId}/report/{selectedMonth}")
    public ResponseEntity<List<ResponseEntry>> handleMonth(
        @PathVariable("userId") Long userId, 
        @PathVariable("selectedMonth") int selectedMonth) {
        
        System.out.println("User ID: " + userId);
        System.out.println("Mese selezionato: " + selectedMonth);

        List<ResponseEntry> entries = filterService.getFilterResult(userId, selectedMonth);
        return ResponseEntity.ok(entries);
    }
    // @GetMapping("/report")
    // public ResponseEntity<List<ResponseEntry>> handleMonth(@RequestParam(value = "month") int month) {
    //     System.out.println("Mese selezionato: " + month);
    //     List<ResponseEntry> entries = filterService.getFilterResult(month);
    //     return ResponseEntity.ok(entries);
    // }

}
    

    

