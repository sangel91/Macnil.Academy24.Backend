package macnil.academy.EmailVerification;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CodeGenerationService {

    // Metodo per generare un codice casuale (6 cifre)
    public String generateRandomCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000); // Genera un numero a 6 cifre
        return String.valueOf(code);
    }
}