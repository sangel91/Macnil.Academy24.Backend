package macnil.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

import macnil.academy.controller.dto.UserDto;
import macnil.academy.model.User;
import macnil.academy.repository.UserRepository;
import macnil.academy.service.UserService;

@RestController
@RequestMapping("/api/v1/users")


public class UserRestController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    
    
    
    @GetMapping("tenant/{tenantId}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public @ResponseBody List<UserDto> getAllUsers(@PathVariable Long tenantId){
        // 1. Verifica se il tenantId è nullo
        if(tenantId == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Il tenanId non può essere nullo");  
            
        }
        // 2. Verifica se il tenantId esiste nel database, ad esempio controllando se esistono utenti associati a questo tenantId
        boolean tenantExists = userRepository.existsByTenantId(tenantId); 
        if(!tenantExists){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tenant non trovato");
        }
        // 3. Recupera tutti gli utenti associati al tenantId direttamente
        List<User> users = userRepository.findByTenantId(tenantId); // Trova tutti gli utenti con il tenantId
    if (users.isEmpty()) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nessun utente trovato per questo tenant");
    }
    // Converti gli utenti in UserDto e restituisci la lista
    List<UserDto> userDtos = users.stream()
                                    .map(user -> new UserDto())
                                    .collect(Collectors.toList());
    return userDtos;
}
    


    
    
    @GetMapping("{id}")
    public @ResponseBody UserDto getUser(@PathVariable("id") Long id){
        // return userRepository.findById(id).get();
           return userService.read(id);
    }
    

   




    
}
