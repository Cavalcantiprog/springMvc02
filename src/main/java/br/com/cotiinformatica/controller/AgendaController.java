package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AgendaController {

	@RequestMapping("/home")
	public ModelAndView home(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(isLoggedIn(request)) {
			modelAndView.setViewName("agenda/home");
		}
		else {
			modelAndView.setViewName("redirect:/");
		}
		
		return modelAndView;
	}
	
	//método para verificar se o usuario esta autenticado..
	private boolean isLoggedIn(HttpServletRequest request) {
		return request.getSession().getAttribute("usuario_autenticado") != null;
	}	
}
