package macnil.academy.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Eseguiamo un controllo per verificare se l'utente è autenticato
        // Ad esempio, possiamo verificare se è presente una sessione o un altro tipo di autenticazione

        String sessionId = request.getSession(false) != null ? request.getSession(false).getId() : null;

        if (sessionId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
           
            // Se la sessione è presente e l'utente non è autenticato nel contesto di sicurezza,
            // possiamo effettuare altre operazioni, come caricare un utente dalla sessione.
            
            // Qui dovresti inserire la logica per caricare l'utente associato alla sessione
            // e impostare il contesto di sicurezza se l'autenticazione è valida.
            // Questo dipende dal tuo meccanismo di autenticazione.

            // ESEMPIO DI LOGICA DI AUTENTICAZIONE SEMPLICE SENZA JWT
            // Verifica una sessione di autenticazione o altro tipo di controllo.
            
            // Se l'autenticazione è valida, imposta il contesto di sicurezza.
            // UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, null, authorities);
            // SecurityContextHolder.getContext().setAuthentication(auth);
        }

        // Continua la catena di filtri
        filterChain.doFilter(request, response);
    }
}
