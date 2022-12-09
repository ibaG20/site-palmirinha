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

import com.gft.projeto.entities.Receita;
import com.gft.projeto.services.ReceitaService;

@Controller
@RequestMapping("receita")
public class ReceitaController {
	
	@Autowired
	private ReceitaService receitaService;
	
	@RequestMapping(path = "editar")
	public ModelAndView editarReceita(@RequestParam(required = false) Long id) {
		
		ModelAndView mv = new ModelAndView("receita/form.html");
		Receita receita; 
		
		if(id == null) {
			receita = new Receita();
		}else {
			try {
				receita = receitaService.obterReceita(id);
			}catch(Exception e) {
				receita = new Receita();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		
		mv.addObject("receita", receita);
		//mv.addObject("listaReceita", receitaService.listarReceita());
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "editar")
	public ModelAndView salvarReceita(@Valid Receita receita, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("receita/form.html");
		boolean novo = true;
		
		if(receita.getId() != null) {
			novo = false;
		}
		
		if(bindingResult.hasErrors()) {
			mv.addObject("receita", receita);
			return mv;
		}
		
		receitaService.salvarReceita(receita);
		
		if(novo) {
			mv.addObject("receita", new Receita());
		}else {
			mv.addObject("receita", receita);
		}
		
		mv.addObject("mensagem", "Receita salva com sucesso!");
		//mv.addObject("listaReceita", receitaService.listarReceita());
		
		return mv;
	}
	
	@RequestMapping
	public ModelAndView listarReceitas() {
		
		ModelAndView mv = new ModelAndView("receita/listar");
		mv.addObject("lista", receitaService.listarReceita());
		
		return mv;
	}
	
	@RequestMapping("/excluir")
	public ModelAndView excluirReceita(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/receita");
		
		try {
			receitaService.excluirReceita(id);
			redirectAttributes.addFlashAttribute("mensagem", "Receita excluída com sucesso!");
		}catch(Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir receita!");	
		}
		return mv;
	} 
	
}
