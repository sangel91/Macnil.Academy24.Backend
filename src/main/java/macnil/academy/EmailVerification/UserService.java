package macnil.academy.EmailVerification;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    // Simuliamo un database con un Set per le email registrate
    private Set<String> registeredEmails = new HashSet<>();

    // Costruttore che aggiunge alcune email di esempio
    public UserService() {
        registeredEmails.add("user@example.com");
        registeredEmails.add("admin@example.com");
    }

    // Metodo per verificare se l'email è registrata
    public boolean isEmailRegistered(String email) {
        return registeredEmails.contains(email);
    }

    // Metodo per aggiungere una nuova email al "database"
    public void registerEmail(String email) {
        registeredEmails.add(email);
    }
}
