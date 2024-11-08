package macnil.academy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import macnil.academy.model.User;
import macnil.academy.repository.UserRepository;
@Service
public class UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
     
    
public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


public User getUserByEmail(String email) {
    Optional<User> userOptional = userRepository.findByEmail(email);
    if (userOptional.isPresent()) {
        return userOptional.get(); // Puoi restituire l'oggetto User
    } else {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Email non trovata");
    }
}

   

    // Metodo per criptare la password
    public String encodePassword(String plainPassword) {
        return passwordEncoder.encode(plainPassword);
}
    



}
