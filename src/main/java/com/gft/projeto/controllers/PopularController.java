package com.gft.projeto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gft.projeto.entities.Ingrediente;
import com.gft.projeto.services.IngredienteService;
//import com.gft.projeto.services.PopularService;

public class PopularController {
	
	@Autowired 
	private IngredienteService ingredienteService;
	
	/*@Autowired 
	private PopularService popularService;*/
	
	@RequestMapping(method = RequestMethod.POST, path="inicio")
	public ModelAndView salvarIngredienteAutomaticamente() throws Exception {
		
		ModelAndView mv = new ModelAndView("index.html");
		Ingrediente ingrediente = new Ingrediente();
		
        /*boolean novo = true;
		
		if(ingrediente.getId() != null) {
			novo = false;
		}*/
		
		ingrediente.setNome("chocolate");
		ingredienteService.salvarIngrediente(ingrediente);
		
		mv.addObject("ingrediente", ingrediente);
		
		mv.addObject("mensagem", "Banco populado salvo com sucesso!");
		
		//TESTAR SEM ISSO ANTES
		/*if(novo) {
			mv.addObject("ingrediente", new Ingrediente());
		}else {
			mv.addObject("ingrediente", ingrediente);
		}*/
		
		return mv;

	}

}
