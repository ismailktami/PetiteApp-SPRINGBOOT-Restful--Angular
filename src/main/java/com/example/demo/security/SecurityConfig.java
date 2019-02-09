package com.example.demo.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	@Autowired
	private DataSource datasource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication().withUser("admin").password(encoder.encode("12345")).roles("PROF", "ADMIN");
		auth.inMemoryAuthentication().withUser("prof1").password(encoder.encode("12345")).roles("PROF");
		auth.inMemoryAuthentication().withUser("et1").password(encoder.encode("12345")).roles("ETUDIANT","PROF");
		auth.inMemoryAuthentication().withUser("sco1").password(encoder.encode("12345")).roles("SCOLARITE");

		*/
		 auth.jdbcAuthentication().dataSource(datasource)
			.usersByUsernameQuery("select u.username as principal, u.password as credentials,u.actived from users u where u.username=?" )
			.authoritiesByUsernameQuery("select user_username as principal, roles_role as role from users_roles  where user_username=?")
			.rolePrefix("ROLE_").passwordEncoder(NoOpPasswordEncoder.getInstance());	
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated();
		http.formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/index.html");
		http.csrf().disable();
		http.exceptionHandling().accessDeniedPage("/403.html");
	}	
	
}
