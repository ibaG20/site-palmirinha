package com.gft.projeto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InicioController {
	
	@RequestMapping(method = RequestMethod.GET, path = "/entrar")
	public String entrar() {

		return "entrar";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/faq")
	public String faq() {
		
		return "faq";
	}
	
	@GetMapping (path="inicio")
	public ModelAndView paginaInicial() {
		
		ModelAndView mv = new ModelAndView("index.html");
		return mv;
	}

}
