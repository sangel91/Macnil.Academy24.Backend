package macnil.academy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import macnil.academy.repository.UserRepository;

@Service 
public class UserService {
    @Autowired  
    private UserRepository userRepository;

    public boolean checkEmailExists(String email) {
        return userRepository.existsByEmail(email); 
    }
}
