package com.gft.projeto.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.gft.projeto.entities.Ingrediente;
import com.gft.projeto.repositories.IngredienteRepository;

public class PopularService {
	
	//AQUI VAI COLOCAR OS REPOSITORYS DE 
	//INGREDIENTES, RECEITAS E UNIDADES DE MEDIDA
	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	public Ingrediente salvarIngredienteAutomaticamente(Ingrediente ingrediente) {
		
		return ingredienteRepository.save(ingrediente);
	}

}
