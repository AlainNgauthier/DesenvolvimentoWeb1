package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;

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

@WebServlet(name = "Index", urlPatterns = { "/index.jsp", "/logout/*", "/listaVeiculos" })
public class IndexController extends HttpServlet {

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
		
		String action = request.getPathInfo();
		if (action == null) {
			action = "";
		}

		try {
			switch (action) {
				case "/logout":
					logout(request, response);
				default:
					paginaInicial(request, response);
					break;
			}
		} catch (RuntimeException | IOException | ServletException e) {
			throw new ServletException(e);
		}
	}

	private void paginaInicial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Veiculo> listaVeiculos = null;

		String modelo = request.getParameter("modelo");

		if (modelo != null) {
			listaVeiculos = vDao.getAllVeiculosPorModelo(modelo);
		} else {
			listaVeiculos = vDao.getAllVeiculos();
		}

		request.setAttribute("listaVeiculos", listaVeiculos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listaVeiculos.jsp");
		dispatcher.forward(request, response);
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("usuarioLogado");
		paginaInicial(request, response);
	}
}