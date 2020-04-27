package com.itlize.joole.config;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.itlize.joole.filter.JwtRequestFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService myUserDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsService);
	}

	@Bean
	  public PasswordEncoder passwordEncoder() {
	      return new BCryptPasswordEncoder();
	}
	

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
	
		//　CSRF（Cross-site request forgery），one click attack/session riding
		//		Attackers steal your identity and send malicious requests on your behalf
		httpSecurity.csrf().disable()
		//		Entry points
				.authorizeRequests()
				.antMatchers("/consumer/*").permitAll()
				.antMatchers("/product/*").permitAll()
				.antMatchers("/category/*").permitAll()
				.antMatchers("/type/*").permitAll()
				.antMatchers("/manufacturer/*").permitAll()
				.antMatchers("/representative/*").permitAll()
		     // Disallow everything else..
		        .anyRequest().authenticated().and().exceptionHandling()
				// No session will be created or used by spring security
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
				httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);	
	}
	
}