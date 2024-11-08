package macnil.academy.config;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import macnil.academy.model.User;
import macnil.academy.model.UserInfo;
import macnil.academy.service.AuthenticationService;
import macnil.academy.service.UserService;
import macnil.academy.utils.JwtUtils;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    @Lazy
    UserService userService;

    

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");
        String token = null;
        String email = null;

        if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7);
            email = jwtUtils.extractUserId(token);
        }

        if(email != null && SecurityContextHolder.getContext().getAuthentication() ==null) {
            User user = userService.getUserByEmail(email);
             
            if (user != null && jwtUtils.validateToken(token, user)) {
                // Se l'utente è valido e il token è valido, crea un token di autenticazione
                UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                
                // Imposta l'autenticazione nel SecurityContextHolder
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
          
            
        }
        
        filterChain.doFilter(request, response);                
    }
}
        
