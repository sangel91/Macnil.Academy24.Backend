package macnil.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    
    // @RequestMapping( method=RequestMethod.GET) questo server col @Controller
    @GetMapping
    public @ResponseBody List<UserDto> getAllUsers(){
        //return userRepository.findAll();
        return userService.readAll();
    }

    // @RequestMapping(value = "/{id}", method=RequestMethod.GET)
    @GetMapping("{id}")
    public @ResponseBody UserDto getUser(@PathVariable("id") Long id){
           // return userRepository.findById(id).get();
           return userService.read(id);
    }

   




    
}
