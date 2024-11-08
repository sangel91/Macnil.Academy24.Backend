package macnil.academy.EmailVerification;

import macnil.academy.model.User;
import macnil.academy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("/api/v1")
public class VerificationController {

    @Autowired
    private CodeGenerationService codeGenerationService;

    @Autowired
    private UserRepository userRepository;  // Usa il repository User

    /**
     * Endpoint per richiedere un codice di recupero.
     * La richiesta deve contenere il parametro email come parte della query string.
     * E.g., /api/v1/request?email=example@example.com
     */
    @PostMapping("/request")
    public ResponseEntity<String> requestRecoveryCode(@RequestParam("email") String email) {

        // Recupera l'utente dal database
        User user = userRepository.findByEmail(email);

        // Verifica se l'email è registrata
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found");
        }

        // Genera un codice di recupero (6 cifre)
        String recoveryCode = codeGenerationService.generateRandomCode(); // Restituisce una stringa

        // Calcola la data di generazione del codice
        user.setGeneratedCode(recoveryCode);
        user.setDateGeneratedCode(LocalDateTime.now());  // Memorizza anche l'ora di generazione

        // Salva nel database
        userRepository.save(user);

       

        // Risposta di successo
        return ResponseEntity.ok("Recovery code sent to: " + email);
    }

    /**
     * Endpoint per effettuare il login utilizzando il codice di recupero.
     * La richiesta deve contenere il parametro email e il codice come query string.
     * E.g., /api/v1/login-with-recovery-code?email=example@example.com&code=123456
     */
    @PostMapping("/login-with-recovery-code")
    public ResponseEntity<String> loginWithRecoveryCode(@RequestParam("email") String email, 
                                                        @RequestParam("code") String code) {

        // Recupera l'utente dal database
        User user = userRepository.findByEmail(email);

        // Verifica se l'email è registrata
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found");
        }

        // Verifica se il codice esiste nel database
        if (user.getGeneratedCode() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No recovery code sent to this email");
        }

        // Verifica che il codice fornito corrisponda a quello memorizzato
        if (!user.getGeneratedCode().equals(code)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid recovery code");
        }

        // Verifica se il codice è scaduto (più di 10 minuti)
        LocalDateTime codeGeneratedAt = user.getDateGeneratedCode();  // Ottieni la data di generazione del codice
        if (codeGeneratedAt == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Code generation date is missing");
        }

        // Calcoliamo la differenza in minuti tra la data corrente e quella di generazione del codice
        long minutesBetween = ChronoUnit.MINUTES.between(codeGeneratedAt, LocalDateTime.now());

        if (minutesBetween > 10) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Recovery code has expired");
        }

        // Se il codice è corretto e non è scaduto, login effettuato con successo
        return ResponseEntity.ok("Login successful with recovery code");
    }
}
