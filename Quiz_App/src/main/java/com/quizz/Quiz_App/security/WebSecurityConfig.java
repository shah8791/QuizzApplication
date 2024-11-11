package com.quizz.Quiz_App.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.quizz.Quiz_App.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	@Autowired
	private final UserService userService;
	private UserDetailsService customUserDetailsService;

	public WebSecurityConfig(UserService userService) {
		this.userService = userService;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}

	@Bean
	public SecurityFilterChain securityChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().requestMatchers("/").permitAll();

		http.csrf().disable()
			.authorizeHttpRequests(authorize)
			.antMatchers("/login", "/register")
			.permitAll()
			.antMatchers("/admin/**")
			.hasRole("ADMIN")
			.antMatchers("/user/**")
			.hasRole("USER")
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/home")
			.permitAll()
			.and()
			.logout()
			.logoutSuccessUrl("/login?logout")
			.permitAll();
		http.authenticationProvider(daoAuthenticationProvider());
		return http.build();

		
		 http.csrf().disable() .authorizeHttpRequests(authorize)
		 .antMatchers("/admin/**").hasRole("ADMIN").antMathers("/user/**").hasRole(
		 "USER")
		 .antmatchers("/admin/**").hasRole("ADMIN").antMatchers("/user/**").hasRole(
		 "USER") .antMatchers("/login","/").permitAll().and().formLogin().defaultSuccessUrl("/home", true).and()
		 .logout().permitAll(); 
		 return http.build();
		 

	}


	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(this.customUserDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}

}