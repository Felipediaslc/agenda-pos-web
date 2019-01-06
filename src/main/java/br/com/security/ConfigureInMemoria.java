package br.com.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class ConfigureInMemoria {
  

  public void configureGlobal(AuthenticationManagerBuilder builde) throws Exception{
	  builde.inMemoryAuthentication()
	  .withUser("Carlos").password("123").roles("ADMIN")
	  .and()
	  .withUser("Maria").password("123").roles("USER");
  }
  }