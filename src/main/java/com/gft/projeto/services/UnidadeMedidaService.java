package com.gft.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.projeto.entities.UnidadeMedida;
import com.gft.projeto.repositories.UnidadeMedidaRepository;

@Service
public class UnidadeMedidaService {
	
	@Autowired
	private UnidadeMedidaRepository unidadeMedidaRepository;
	
	public UnidadeMedida salvarUnidadeMedida(UnidadeMedida unidadeMedida) {
		
		return unidadeMedidaRepository.save(unidadeMedida);
	}
	
	public List<UnidadeMedida> listarUnidadeMedida(){
		
		return unidadeMedidaRepository.findAll();
	}
	
	public UnidadeMedida obterUnidadeMedida(Long id) throws Exception{
		Optional<UnidadeMedida> unidadeMedida = unidadeMedidaRepository.findById(id);

		if(unidadeMedida.isEmpty()) {
			throw new Exception("Unidade de Medida não encontrado!");
		}
		
		return unidadeMedida.get();
	}
	
	public void excluirUnidadeMedida(Long id) {
		
		unidadeMedidaRepository.deleteById(id);
	}

}
