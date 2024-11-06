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
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
@EnableWebSecurity
public class SecurityConfigurer {

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
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


    @Configuration
    public static class JwtTokenConfigurationAdapter extends WebSecurityConfigurerAdapter {

        // @Autowired
        // UserInfoService userInfoService;

        @Autowired
        SecurityFilter securityFilter;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .cors().and().csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/api/v1/**", "/v3/api-docs/**", "/swagger-ui/**")
                    .permitAll()
                    .anyRequest().authenticated().and()
                    .exceptionHandling().accessDeniedHandler(accessDeniedHandler()).and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            //http.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
        }

         @Bean
	    RestAccessDeniedHandler accessDeniedHandler() {
		    return new RestAccessDeniedHandler();
	    } 

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            //auth.userDetailsService(userInfoService);
        }

        @Bean
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }
    }
}
