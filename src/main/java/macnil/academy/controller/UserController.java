package macnil.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import macnil.academy.controller.dto.EmailRequestDTO;
import macnil.academy.controller.dto.EmailResponseDTO;
import macnil.academy.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController 
{
     @Autowired
    private UserService userService;

    @PostMapping("/check-email")  
    public ResponseEntity<EmailResponseDTO> checkEmail(@RequestBody EmailRequestDTO emailRequestDTO) {
        boolean exists = userService.checkEmailExists(emailRequestDTO.getEmail());
        return ResponseEntity.ok().body(new EmailResponseDTO(exists));
    }
}
