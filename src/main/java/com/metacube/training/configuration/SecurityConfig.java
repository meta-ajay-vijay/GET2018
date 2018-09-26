package com.metacube.training.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "com.metacube.training")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthentication customAuthProvider;

	@Autowired
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(customAuthProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/admin/*").access("hasRole('ROLE_ADMIN')").antMatchers("/employee/*")
				.access("hasRole('ROLE_EMPLOYEE')").and().formLogin(). // login
																		// configuration
				loginPage("/login").loginProcessingUrl("/Login").defaultSuccessUrl("/default")
				.usernameParameter("email").passwordParameter("password").and().logout().logoutUrl("/logout")
				// logout configuration
				.logoutSuccessUrl("/login?logout").and().exceptionHandling().accessDeniedPage("/error").and().csrf();
	}
}