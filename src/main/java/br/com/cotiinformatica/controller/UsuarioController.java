package br.com.cotiinformatica.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.services.UsuarioService;

@Controller // classe de controle do SpringMVC
public class UsuarioController {

	@Autowired // injeção de dependência
	private UsuarioService usuarioService;

	@RequestMapping("/")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login");
		
		// enviando um objeto javabean Usuario para o formulário..
		modelAndView.addObject("usuario", new Usuario());
		
		return modelAndView;
	}

	@RequestMapping("/register")
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView("register");

		// enviando um objeto javabean Usuario para o formulário..
		modelAndView.addObject("usuario", new Usuario());

		return modelAndView;
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public ModelAndView registerUser(Usuario usuario) {
		
		ModelAndView modelAndView = new ModelAndView("register");
		
		try {
			
			usuario.setDataCriacao(new Date()); //data atual			
			//cadastrando o usuário..
			usuarioService.createOrUpdate(usuario);
			
			modelAndView.addObject("mensagem_sucesso", "Conta de usuário cadastrada com sucesso.");
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}
		
		modelAndView.addObject("usuario", new Usuario());
		return modelAndView;
	}
	
	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public ModelAndView loginUser(Usuario usuario, HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("login");
		
		try {
			
			//verificar se existe no banco de dados um usuario com o email e a senha informados..
			Usuario registro = usuarioService.get(usuario.getEmail(), usuario.getSenha());
			
			if(registro != null) {
				
				//armazenar os dados do usuário em uma sessão
				request.getSession().setAttribute("usuario_autenticado", registro);
				
				//redirecionar para a página da agenda..
				modelAndView.setViewName("redirect:/home");
			}
			else {
				throw new Exception("Acesso negado. Usuário inválido.");
			}
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}
		
		modelAndView.addObject("usuario", new Usuario());
		return modelAndView;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		
		//destruir os dados gravados em sessão
		request.getSession().removeAttribute("usuario_autenticado");
		request.getSession().invalidate();
		
		//redirecionar de volta para a página inicial (login)
		ModelAndView modelAndView = new ModelAndView("redirect:/");
		return modelAndView;
	}
	
}






