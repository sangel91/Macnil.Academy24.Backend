package macnil.academy.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import macnil.academy.model.User;
import macnil.academy.utils.JwtUtils;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    JwtUtils jwtUtils;

    // @Autowired
    // UserInfoService userInfoService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");
        String token = null;
        String customerId = null;

        if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7);
            customerId = jwtUtils.extractCustomerId(token);
        }

        if(customerId != null && SecurityContextHolder.getContext().getAuthentication() ==null) {
/*             UserInfo userInfo = (UserInfo) userInfoService.loadUserByCustomerId(Long.valueOf(customerId));
            if(jwtUtils.validateToken(token, userInfo)) {
                User user = new User(userInfo.getUsername(), userInfo.getPassword(), new ArrayList<>());
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userInfo, null, user.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            } */
        }
        
        filterChain.doFilter(request, response);                
    }
        
}