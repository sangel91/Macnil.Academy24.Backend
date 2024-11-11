package macnil.academy.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import macnil.academy.model.UserInfo;

@Service
public class JwtUtils {

    @Value("${macnil.academy.secret}")
    private String SECRET;

    @Value("${macnil.academy.jwtExpirationMs}")
    private int jwtExpirationMs;

    private Log logger = LogFactory.getLog(JwtUtils.class);

    /**
     * Generates a token by using the user info. 
     * @param userInfo
     * @return A string representing the generated token.
     */
    public String generateToken(UserInfo userInfo) {
        Map<String, Object> claims = new HashMap<>();
        // claims.put("key", "value");
        return createToken(claims, userInfo);
    }

    /**
     * Validates a token by comparing it with the user info
     * @param token
     * @param userInfo
     * @return A true or false result representing the outcome of the validation.
     */
    public boolean validateToken(String token, UserInfo userInfo) {
        final String customerId = extractCustomerId(token);
        return (customerId.equals(String.valueOf(userInfo.getId())) && !isTokenExpired(token));
    }

    /**
     * Extracts the identifier of the customer from the token.
     * @param token
     * @return A string representing the identifier of the customer.
     */
    public String extractCustomerId(String token) {
        String customerId = null;
        try {
            customerId = extractClaim(token, Claims::getSubject);
        }
        catch(ExpiredJwtException e) {
            logger.warn("Token expired or not valid!", e);
        }
        return customerId;
    }

    /**
     * Extracts a specific user claim from the authentication token. 
     * @param <T>
     * @param token
     * @param claimsResolver
     * @return
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Extracts all the user claims from the authentication token.
     * @param token
     * @return
     */
    public Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    // region PRIVATE_METHODS
    private boolean isTokenExpired(String token) {
        Date expDate = extractClaim(token, Claims::getExpiration);
        return (new Date()).after(expDate);
    }
    
    private String createToken(Map<String, Object> claims, UserInfo userInfo) {
        return Jwts.builder().setClaims(claims).setSubject(String.valueOf(userInfo.getId())).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs)) 
                .signWith(SignatureAlgorithm.HS512, SECRET).compact();
    }
    // endregion PRIVATE_METHODS
}

