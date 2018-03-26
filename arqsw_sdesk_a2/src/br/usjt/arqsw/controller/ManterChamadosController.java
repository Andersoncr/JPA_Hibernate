package br.usjt.arqsw.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;
import br.usjt.arqsw.service.ChamadoService;
import br.usjt.arqsw.service.FilaService;

/**
 * 
 * @author Anderson
 *
 */
@Controller
public class ManterChamadosController {
	private ChamadoService cs;
	private FilaService fs;
	
	@Autowired
	public ManterChamadosController(ChamadoService cs, FilaService fs ) {
		this.cs = cs;
		this.fs = fs;
	}

	/**
	 * 
	 * @return Chama a página inicial index.jsp
	 */
	@RequestMapping("index")
	public String inicio() {
		return "index";
	}

	@SuppressWarnings("unused")
	private List<Fila> listarFilas() throws IOException{
			return fs.listarFilas();
	}
	
	/**
	 * 
	 * @param model Acesso à request http
	 * @return JSP de Listar Chamados
	 */
	@RequestMapping("/listar_filas_exibir")
	public String listarFilasExibir(Model model) {
		try {
			List<Fila> filas = fs.listarFilas();
			model.addAttribute("filas", filas);
			return "ChamadoListar";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("/listar_chamados_exibir")
	public String listarChamadosExibir(@Valid Fila fila, BindingResult result, Model model) {
		try {
			fila = fs.carregar(fila.getId());
			model.addAttribute("fila", fila);

			List<Chamado> chamados = cs.listarChamados(fila);
			model.addAttribute("chamados", chamados);

			return "ChamadoListarExibir";

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
}