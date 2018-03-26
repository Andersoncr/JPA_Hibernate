package br.usjt.arqsw.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.arqsw.entity.Usuario;
import br.usjt.arqsw.service.UsuarioService;

/**
 * 
 * @author Anderson
 *
 */
@Controller
public class UsuarioController {
	UsuarioService us;
	
	@Autowired
	public UsuarioController(UsuarioService us){
		this.us = us;
	}
	/**
	 * 
	 * @return Chama a página de autenticação Login.jsp
	 */
	@RequestMapping("telaLogin")
	public String telaLogin(){
		return "Login";
	}
	
	/**
	 * 
	 * @param usuario Valida usuário
	 * @param session 
	 * @return JSP inicial
	 */
	@RequestMapping("fazer_Login")
	public String fazerLogin(@Valid Usuario usuario, HttpSession session){
		try {
			if(us.validar(usuario)){
				session.setAttribute(Usuario.LOGADO, usuario);
				return "index";
			}else{
				return "redirect:telaLogin";
			}
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
}
