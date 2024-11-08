package macnil.academy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import ch.qos.logback.core.recovery.ResilientFileOutputStream;
import macnil.academy.controller.dto.LoginRequestDto;
import macnil.academy.controller.dto.LoginResponseDto;
import macnil.academy.model.User;
import macnil.academy.repository.UserRepository;
import macnil.academy.utils.JwtUtils;

@Service
public class AuthenticationService {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private PasswordEncoder passwordEncoder;

    
    
    public LoginResponseDto authenticate(LoginRequestDto loginRequestDto, String plainPassword){
        Optional<User> userOptional = userRepository.findByEmail(loginRequestDto.getEmail());
        
        User user = userOptional.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "EMAIL NON TROVATA"));
        String encryptedPassword = user.getPassword();
           if (!passwordEncoder.matches(plainPassword , encryptedPassword)) {
            throw new RuntimeException("Invalid credentials");
        }
        String role = user.getRole().name();
        String token = jwtUtils.generateToken(user);
        LoginResponseDto loginResponse = new LoginResponseDto();
        loginResponse.setToken(token);
        loginResponse.setRole(role);
        return loginResponse; 
         
    }
}

       
