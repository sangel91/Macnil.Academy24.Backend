package macnil.academy.controller;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.micrometer.core.ipc.http.HttpSender.Response;
// import io.swagger.v3.oas.annotations.parameters.RequestBody;
import macnil.academy.config.SecurityFilter;
import macnil.academy.controller.dto.LoginRequestDto;
import macnil.academy.controller.dto.LoginResponseDto;
import macnil.academy.model.User;

import macnil.academy.service.AuthenticationService;
import macnil.academy.service.UserService;
import macnil.academy.utils.JwtUtils;

@RestController
@RequestMapping("/api/auth")
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationService autenticationService;
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
       
        LoginResponseDto loginResponseDto = autenticationService.authenticate(loginRequestDto, loginRequestDto.getPassword());
        return ResponseEntity.ok(loginResponseDto);
    }

}
