package com.gft.projeto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;




@Configuration
@EnableWebSecurity
public class InMemorySecurityConfig {
	
	/*
	 * admin@gft.com
	 * usuario@gft.com
	 * Gft@1234
	 */

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception{
		builder
			.inMemoryAuthentication()
			.withUser("admin@gft.com")
				.password("{noop}Gft@1234")
				.roles("PG_UNIDADEMEDIDA_EDITAR", "PG_INGREDIENTE_EDITAR",
						"PG_RECEITA_EDITAR")
			.and()
			.withUser("usuario@gft.com")
				.password("{noop}Gft@1234")
				.roles("");
				
	}
}
