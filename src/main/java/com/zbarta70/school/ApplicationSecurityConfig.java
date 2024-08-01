package com.zbarta70.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig { //extends WebSecurityConfiguration {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(requests -> requests
						
					 .requestMatchers("/login", "/index", "/resources/**", "/css/**", "/fonts/**", "/img/**").permitAll()
					 .requestMatchers("/register", "/resources/**",	"/css/**", "/fonts/**", "/img/**", "/js/**").permitAll()
					 .requestMatchers("/users/addNew").permitAll()
					 .requestMatchers("/h2-console").permitAll() 
//					 .requestMatchers("/security/user/Edit/**").hasRole("ADMIN")   
					 .anyRequest().authenticated())
//              .and()
                .formLogin((form) -> form
                        .permitAll()  
                        .defaultSuccessUrl("/index"))
                .exceptionHandling(handling -> handling.accessDeniedPage("/accessDenied"))
                .logout(logout -> logout.invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login").permitAll());
//                .and()
		/*
		 * .oauth2Login(login -> login .loginPage("/login")
		 * .defaultSuccessUrl("/index").permitAll());
		 */
        return http.build();
	}
	
	/*
	 * @Bean public PasswordEncoder passwordEncoder() { return
	 * NoOpPasswordEncoder.getInstance(); }
	 */
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(userDetailsService);
		
		provider.setPasswordEncoder(bCryptPasswordEncoder());
		return provider;
	}
	
}
