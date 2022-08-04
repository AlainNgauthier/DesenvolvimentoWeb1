package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.dao.VeiculoDAO;
import br.ufscar.dc.dsw.domain.Veiculo;
import br.ufscar.dc.dsw.util.Erro;

@WebServlet(urlPatterns = "/loja/*")
public class LojaController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private UsuarioDAO uDao;
	private VeiculoDAO vDao;

	@Override
	public void init() {
		uDao = new UsuarioDAO();
		vDao = new VeiculoDAO();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
		Erro erros = new Erro();

		if (usuario == null) {
			response.sendRedirect(request.getContextPath());
			return;
		} else if (!usuario.getCategoria().equals("LOJA")) {
			erros.add("Não autorizado!");
			erros.add("Acesso restrito à Categoria LOJA");
			request.setAttribute("mensagens", erros);
			RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
			rd.forward(request, response);
			return;
		}
		
		String action = request.getPathInfo();
		if (action == null) {
			action = "";
		}

		try {
			switch (action) {
				case "/cadastroVeiculo":
					apresentaFormularioCadastroVeiculo(request, response);
					break;
				case "/insereVeiculo":
					insereVeiculo(request, response, usuario);
					break;
				case "/listaVeiculosLoja":
					listaVeiculosLoja(request, response, usuario);
					break;
				case "/atualizaVeiculo":
					apresentaFormularioEdicaoVeiculo(request, response);
					break;
				case "/atualizarVeiculo":
					atualizaVeiculo(request, response, usuario);
					break;
				case "/removeVeiculo":
					removeVeiculo(request, response, usuario);
					break;
				default:
					paginaInicial(request, response);
					break;
			}
		} catch (RuntimeException | IOException | ServletException e) {
			throw new ServletException(e);
		}
	}

	private void paginaInicial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/loja/index.jsp");
		dispatcher.forward(request, response);
	}

	private void listaVeiculosLoja(HttpServletRequest request, HttpServletResponse response, Usuario usuario) throws ServletException, IOException {
		
		List<Veiculo> listaVeiculos = vDao.getAllVeiculosLoja(usuario);
		request.setAttribute("lista", listaVeiculos);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/loja/listaVeiculos.jsp");
		dispatcher.forward(request, response);
	}

	private void apresentaFormularioCadastroVeiculo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/loja/formulario.jsp");
		dispatcher.forward(request, response);
	}

	private void apresentaFormularioEdicaoVeiculo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Veiculo veiculo = vDao.get(id);
		request.setAttribute("veiculo", veiculo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/loja/formulario.jsp");
		dispatcher.forward(request, response);
	}

	private void insereVeiculo(HttpServletRequest request, HttpServletResponse response, Usuario usuario) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String cnpj = usuario.getCnpj();
		String placa = request.getParameter("placa");
		String chassi = request.getParameter("chassi");
		String modelo = request.getParameter("modelo");
		String descricao = request.getParameter("descricao");
		Integer ano = Integer.parseInt(request.getParameter("ano"));
		Float kilometragem = Float.parseFloat(request.getParameter("kilometragem"));
		Float valor = Float.parseFloat(request.getParameter("valor"));

		Usuario agencia = uDao.getLojaByCnpj(cnpj);
			
		Veiculo veiculo = new Veiculo(agencia, placa, chassi, modelo, descricao, ano, kilometragem, valor);

		vDao.insert(veiculo);
		response.sendRedirect("listaVeiculosLoja");
	}

	private void atualizaVeiculo(HttpServletRequest request, HttpServletResponse response, Usuario usuario) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Long id = Long.parseLong(request.getParameter("id"));
		String cnpj = usuario.getCnpj();
		String placa = request.getParameter("placa");
		String chassi = request.getParameter("chassi");
		String modelo = request.getParameter("modelo");
		String descricao = request.getParameter("descricao");	
		Integer ano = Integer.parseInt(request.getParameter("ano"));
		Float kilometragem = Float.parseFloat(request.getParameter("kilometragem"));
		Float valor = Float.parseFloat(request.getParameter("valor"));

		UsuarioDAO uDao = new UsuarioDAO();

		Usuario agencia = uDao.getLojaByCnpj(cnpj);
			
		Veiculo veiculo = new Veiculo(id, agencia, placa, chassi, modelo, descricao, ano, kilometragem, valor);

		vDao.update(veiculo);
		response.sendRedirect("listaVeiculosLoja");
	}

	private void removeVeiculo(HttpServletRequest request, HttpServletResponse response, Usuario usuario) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Veiculo veiculo = new Veiculo(id);                                                                           
		vDao.delete(veiculo);
		response.sendRedirect("listaVeiculosLoja");
	}
}