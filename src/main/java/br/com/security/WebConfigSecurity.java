package br.com.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
public class WebConfigSecurity extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		//.anyRequest()
		//.authenticated()
		  //.and()
		    //.formLogin().loginPAge("/login").permitAll();
		
	.antMatchers("/static/**","/resources/**").permitAll()
	.antMatchers("/contatos").hasRole("ADMIN")
		.and()
		.formLogin().loginPage("/login").permitAll()
	.and()
		.exceptionHandling().accessDeniedPage("/403")
		.and()
		.logout().logoutSuccessUrl("/login?logout").permitAll();
	}

	
}