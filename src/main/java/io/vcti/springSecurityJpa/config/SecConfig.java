package io.vcti.springSecurityJpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecConfig{

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	AuthenticationProvider authProvider()
	{
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider(encoder());
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(encoder());
		return provider;
	}
	
	
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(authz -> authz
            .requestMatchers("/sec/save").hasRole("admin")
            .requestMatchers("/sec/fetch").hasAnyRole("admin", "user")
        )
        .formLogin(Customizer.withDefaults())
        .httpBasic(Customizer.withDefaults());  
    return http.build();
    }

    @Bean
    BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
