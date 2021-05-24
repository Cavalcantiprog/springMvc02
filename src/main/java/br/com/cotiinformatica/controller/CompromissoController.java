package br.com.cotiinformatica.controller;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.dto.CadastroCompromissoDTO;
import br.com.cotiinformatica.dto.ConsultaCompromissoDTO;
import br.com.cotiinformatica.dto.RelatorioCompromissoDTO;
import br.com.cotiinformatica.entities.Compromisso;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.enums.ModoDeExibicao;
import br.com.cotiinformatica.enums.PrioridadeCompromisso;
import br.com.cotiinformatica.enums.TipoCompromisso;
import br.com.cotiinformatica.reports.CompromissoReport;
import br.com.cotiinformatica.services.CompromissoService;
import br.com.cotiinformatica.utils.DateUtil;

@Controller // define a classe como controlador do spring
public class CompromissoController {

	@Autowired // injeção de dependência
	private CompromissoService compromissoService;

	@RequestMapping("/cadastro-compromisso") // abre a view
	public ModelAndView cadastroCompromisso() {
		ModelAndView modelAndView = new ModelAndView("agenda/cadastro-compromisso");

		modelAndView.addObject("dto", new CadastroCompromissoDTO());
		modelAndView.addObject("tipos", TipoCompromisso.values());
		modelAndView.addObject("prioridades", PrioridadeCompromisso.values());

		return modelAndView;
	}

	@RequestMapping(value = "cadastrarCompromisso", method = RequestMethod.POST) // recebe o submit do formulário
	public ModelAndView cadastrarCompromisso(CadastroCompromissoDTO dto, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("agenda/cadastro-compromisso");

		try {

			// Obtendo o usuário da sessão..
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario_autenticado");

			// criando um objeto da classe de entidade Compromisso..
			Compromisso compromisso = new Compromisso();

			compromisso.setNome(dto.getNome());
			compromisso.setData(DateUtil.toDate(dto.getData()));
			compromisso.setHora(dto.getHora());
			compromisso.setTipo(dto.getTipo());
			compromisso.setPrioridade(dto.getPrioridade());
			compromisso.setDescricao(dto.getDescricao());
			compromisso.setUsuario(usuario); // associando ao usuario autenticado

			compromissoService.createOrUpdate(compromisso);

			modelAndView.addObject("mensagem_sucesso", "Compromisso cadastrado com sucesso.");
		} catch (Exception e) {
			// definindo mensagem de erro..
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}

		modelAndView.addObject("dto", new CadastroCompromissoDTO());
		modelAndView.addObject("tipos", TipoCompromisso.values());
		modelAndView.addObject("prioridades", PrioridadeCompromisso.values());

		return modelAndView;
	}

	@RequestMapping("/consulta-compromisso") // abre a view
	public ModelAndView consultaCompromisso() {
		ModelAndView modelAndView = new ModelAndView("agenda/consulta-compromisso");

		modelAndView.addObject("dto", new ConsultaCompromissoDTO());
		modelAndView.addObject("modosDeExibicao", ModoDeExibicao.values());

		return modelAndView;
	}

	@RequestMapping(value = "consultarCompromissos", method = RequestMethod.POST) // recebe o submit POST
	public ModelAndView consultarCompromissos(ConsultaCompromissoDTO dto, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("agenda/consulta-compromisso");

		try {

			// resgatar os dados enviados pelo DTO..
			Date dataInicio = DateUtil.toDate(dto.getDataInicio());
			Date dataFim = DateUtil.toDate(dto.getDataFim());

			// obter o usuario autenticado na sessão..
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario_autenticado");

			// executando a consulta..
			List<Compromisso> compromissos = compromissoService.get(dataInicio, dataFim, usuario.getIdUsuario());

			// verificando o tipo de consulta solicitado..
			switch (dto.getModoDeExibicao()) {

			case HTML:
				modelAndView.addObject("compromissos", compromissos);
				break;

			case PDF:

				RelatorioCompromissoDTO relatorioDTO = new RelatorioCompromissoDTO();
				relatorioDTO.setDataInicio(dataInicio);
				relatorioDTO.setDataFim(dataFim);
				relatorioDTO.setUsuario(usuario);
				relatorioDTO.setCompromissos(compromissos);

				ByteArrayInputStream stream = CompromissoReport.getPdf(relatorioDTO);

				byte[] pdf = stream.readAllBytes();
				// DOWNLOAD..
				response.setContentType("application/pdf");
				response.addHeader("Content-Disposition", "attachment; filename=compromissos.pdf");

				OutputStream out = response.getOutputStream();
				out.write(pdf, 0, pdf.length);
				out.flush();
				out.close();
				response.getOutputStream().flush();

				return null;

			}
		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}

		modelAndView.addObject("dto", dto);
		modelAndView.addObject("modosDeExibicao", ModoDeExibicao.values());

		return modelAndView;
	}

	@RequestMapping("/edicao-compromisso")
	public ModelAndView edicaoCompromisso() {
		ModelAndView modelAndView = new ModelAndView("agenda/edicao-compromisso");
		return modelAndView;
	}
}
