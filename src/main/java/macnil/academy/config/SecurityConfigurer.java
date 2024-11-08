package macnil.academy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import macnil.academy.service.UserService;



@Configuration
@EnableWebSecurity
public class SecurityConfigurer{
    @Autowired
    private SecurityFilter securityFilter;

    public SecurityConfigurer(SecurityFilter securityFilter) {
        this.securityFilter = securityFilter;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/api/auth/login").permitAll()  // Permetti l'accesso alla rotta di login
            .anyRequest().authenticated()
            .and()
            .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class); 
            
              

        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
    /**
     * There are no plans to remove this support.
     * It is deprecated to indicate that this is a legacy implementation
     * and using it is considered insecure.
     * https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/crypto/password/NoOpPasswordEncoder.html
     * 
     * @todo use instead an adaptive one way function like BCryptPasswordEncoder,
     *       Pbkdf2PasswordEncoder, or SCryptPasswordEncoder.
     *       Even better use DelegatingPasswordEncoder which supports password
     *       upgrades
     */
    


    // @Configuration
    // public static class JwtTokenConfigurationAdapter extends WebSecurityConfigurerAdapter {

    //      @Autowired
    //     UserService userService;

    //     @Autowired
    //     SecurityFilter securityFilter;

    //     @Override
    //     protected void configure(HttpSecurity http) throws Exception {
    //         http
    //                 .cors().and().csrf().disable()
    //                 .authorizeRequests()
    //                 .antMatchers("./api/auth")
    //                 .permitAll()
    //                 .anyRequest().authenticated().and()
    //                 .exceptionHandling().accessDeniedHandler(accessDeniedHandler()).and()
    //                 .sessionManagement()
    //                 .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    //                 .and()
    //                 .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
    //     }

    //      @Bean
	//     RestAccessDeniedHandler accessDeniedHandler() {
	// 	    return new RestAccessDeniedHandler();
	//     } 

    //     @Override
    //     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //         //auth.userDetailsService(userInfoService);
    //     }

    //     @Bean
    //     @Override
    //     public AuthenticationManager authenticationManagerBean() throws Exception {
    //         return super.authenticationManagerBean();
    //     }
    // }

