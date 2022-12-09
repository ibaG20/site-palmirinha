package com.gft.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.projeto.entities.Ingrediente;
import com.gft.projeto.repositories.IngredienteRepository;

@Service
public class IngredienteService {

	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	public List<Ingrediente> listarIngrediente(){
		
		return ingredienteRepository.findAll();
	}
	
	public Ingrediente salvarIngrediente(Ingrediente ingrediente) throws Exception {
		
		if(listarIngrediente().contains(ingrediente)){
			throw new Exception("Ingrediente já foi cadastrado!");
		}else {
			return ingredienteRepository.save(ingrediente);		
			
		}
	}


	public Ingrediente obterIngrediente(Long id) throws Exception{
		
		Optional<Ingrediente> ingrediente = ingredienteRepository.findById(id);
	
		if(ingrediente.isEmpty()) {
			throw new Exception("Ingrediente não encontrado!");
		}
		
		return ingrediente.get();
	}
	
	public void excluirIngrediente(Long id) {
		
		ingredienteRepository.deleteById(id);
	}
}
