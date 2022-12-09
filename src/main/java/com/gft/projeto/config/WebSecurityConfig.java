package com.gft.projeto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig{
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.
	    	authorizeRequests() //P QUALQUER REQUISIÇÃO O USUÁRIO TEM Q TA AUTENTICADO
            	.antMatchers("/unidademedida/editar").hasAnyRole("PG_UNIDADEMEDIDA_EDITAR")	
            	.antMatchers("/ingrediente/editar").hasAnyRole("PG_INGREDIENTE_EDITAR")	
            	.antMatchers("/receita/editar").hasAnyRole("PG_RECEITA_EDITAR")	
            	.anyRequest()
            	.authenticated()
            .and()
            .formLogin()
				.loginPage("/entrar")
				.permitAll()
			.and()
			.logout()
				.logoutSuccessUrl("/entrar?logout")
				.permitAll();
		
		return http.build();
		
	}	
}