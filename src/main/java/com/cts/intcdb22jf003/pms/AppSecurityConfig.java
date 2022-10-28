package com.cts.intcdb22jf003.pms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
@Autowired
	private UserDetailsService userdetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
	/*	auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
		.withUser("krishna").password("$2a$12$C0IjgIBlbzH3gK5PJ1b6seXgVhmWeiCfP07ewKbk7TNw2e4uAtgF2").roles("ADMIN")
		.and().withUser("kumar").password("$2a$12$C0IjgIBlbzH3gK5PJ1b6seXgVhmWeiCfP07ewKbk7TNw2e4uAtgF2").roles("USER");
	*/
	
		
		auth.userDetailsService(userdetailsService).passwordEncoder(passwordEncoder());
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		
		http.csrf().disable()
		
		.authorizeHttpRequests()
		.antMatchers("/h2-console").permitAll()
		.antMatchers("/pms/admin/**")
		.hasAuthority("ADMIN").antMatchers("/pms/api/**")
		.hasAnyAuthority("ADMIN","USER")
		.and().httpBasic().and().headers().frameOptions().disable();
	}
	
	
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		//return NoOpPasswordEncoder.getInstance();
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		return passwordEncoder;
	}
}
