//TESTAR O GET DEPOIS @GetMapping(path = "login")
package com.gft.projeto.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.projeto.entities.Ingrediente;
import com.gft.projeto.services.IngredienteService;

@Controller
@RequestMapping("ingrediente")
public class IngredienteController {
	
	@Autowired 
	private IngredienteService ingredienteService;
	
	@RequestMapping(path = "editar")
	public ModelAndView editarIngrediente(@RequestParam(required = false) Long id) {
		
		ModelAndView mv = new ModelAndView("ingrediente/form.html");
		Ingrediente ingrediente;
		
		if(id == null) {
			ingrediente = new Ingrediente();
		}else {
			try {
				ingrediente = ingredienteService.obterIngrediente(id);
			}catch(Exception e) {
				ingrediente = new Ingrediente();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		
		mv.addObject("ingrediente", ingrediente);
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "editar")
	public ModelAndView salvarIngrediente(@Valid Ingrediente ingrediente, BindingResult bindingResult){
		
		ModelAndView mv = new ModelAndView("ingrediente/form.html");
		boolean novo = true;
		
		if(ingrediente.getId() != null) {
			novo = false;
		}
		
		if(bindingResult.hasErrors()) {
			mv.addObject("ingrediente", ingrediente);
			return mv;
		}
		
		try {
			ingrediente = ingredienteService.salvarIngrediente(ingrediente);
		}catch(Exception e) {
			ingrediente = new Ingrediente();
			mv.addObject("mensagem", e.getMessage());
			return mv;
		}
		
		//ingredienteService.salvarIngrediente(ingrediente);
		
		//SE FOR SALVAR UM NOVO INGREDIENTE EU QUERO UM FORMULÁRIO NOVO
		if(novo) { 
			mv.addObject("ingrediente", new Ingrediente());
			
		// MAS QUANDO EU FOR RECÉM EDITAR EU QUERO MANTER O MESMO FORMULÁRIO	
		}else {    
			mv.addObject("ingrediente", ingrediente);
		}
		
		mv.addObject("mensagem", "Ingrediente salvo com sucesso!");
		
		return mv;
	}
	
	@RequestMapping
	public ModelAndView listarIngredientes() {
		
		ModelAndView mv = new ModelAndView("ingrediente/listar.html");
		mv.addObject("lista", ingredienteService.listarIngrediente());
		
		return mv;
	}

	@RequestMapping("/excluir")
	public ModelAndView excluirIngrediente(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/ingrediente");
		
		try {
			ingredienteService.excluirIngrediente(id);
			redirectAttributes.addFlashAttribute("mensagem", "Ingrediente excluído com sucesso!");
		}catch(Exception e){
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir" + e.getMessage());
		}
		
		return mv;
	}
}
