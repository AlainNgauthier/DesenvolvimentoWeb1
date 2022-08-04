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

import br.ufscar.dc.dsw.dao.VeiculoDAO;
import br.ufscar.dc.dsw.domain.Veiculo;
import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.util.Erro;

@WebServlet(urlPatterns = "/veiculo/*")
public class VeiculoController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private VeiculoDAO dao;

	@Override
	public void init() {
		dao = new VeiculoDAO();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
		
		String action = request.getPathInfo();
		if (action == null) {
			action = "";
		}

		try {
			switch (action) {
				
				case "/listaPacotesCliente":
					listaVeiculosCliente(request, response, usuario);
					break;
				default:
					listaDeVeiculos(request, response);
					break;
			}
		} catch (RuntimeException | IOException | ServletException e) {
			throw new ServletException(e);
		}
	}

	private void listaDeVeiculos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Veiculo> listaVeiculos = dao.getAllVeiculos();
		request.setAttribute("listaVeiculos", listaVeiculos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pacote/listaVeiculos.jsp");
		dispatcher.forward(request, response);
	}

	private void listaVeiculosCliente(HttpServletRequest request, HttpServletResponse response, Usuario usuario) throws ServletException, IOException {
		if (usuario.getCategoria().equals("CLIENTE")) {
			List<Veiculo> listaVeiculos = dao.getAllVeiculosCliente(usuario);
			request.setAttribute("listaVeiculos", listaVeiculos);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/veiculo/listaVeiculos.jsp");
			dispatcher.forward(request, response);
		} else {
			acessoNegadoCliente(request, response);
		}
	}

	private void acessoNegadoAgencia (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Erro erros = new Erro();
		erros.add("Acesso não autorizado!");
		erros.add("Só usuários da categoria LOJA têm acesso a essa página");
		request.setAttribute("mensagens", erros);
		RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
		rd.forward(request, response);
	}

	private void acessoNegadoCliente (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Erro erros = new Erro();
		erros.add("Acesso não autorizado!");
		erros.add("Apenas usuários CLIENTE têm acesso a essa página");
		request.setAttribute("mensagens", erros);
		RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
		rd.forward(request, response);
	}
}