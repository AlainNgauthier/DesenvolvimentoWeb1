package br.ufscar.dc.dsw.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.ClienteDAO;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.dao.LojaDAO;
import br.ufscar.dc.dsw.domain.Loja;
import br.ufscar.dc.dsw.util.Erro;

@WebServlet(name = "Login", urlPatterns= {"/login/*", "/logout/*"})
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Erro erros = new Erro();
		
		if (request.getParameter("bOK") != null) {
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			if (login == null || login.isEmpty()) {
				erros.add("Email não digitado!");
			}
			if (senha == null || senha.isEmpty()) {
				erros.add("Senha não digitada!");
			}

			if (!erros.isExisteErros()) {
				ClienteDAO dao1 = new ClienteDAO();
				Cliente usuario = dao1.getbyLogin(login);
				LojaDAO dao2 = new LojaDAO();
				Loja loja = dao2.getbyLogin(login);

				if (usuario != null && loja == null) {
					if (usuario.getSenha().equalsIgnoreCase(senha)) {
						request.getSession().setAttribute("usuarioLogado", usuario);
						if (usuario.getPapel().equals("ADMIN")) {
							response.sendRedirect("admin");
						} 
						else {
							response.sendRedirect("clientes");
						}
						return;
					} else {
						erros.add("Senha inválida!");
					}
				}
				else {
					if (loja != null && usuario == null) {
						if (loja.getSenha().equalsIgnoreCase(senha)) {
							request.getSession().setAttribute("lojaLogada", loja);
							response.sendRedirect("lojas");
							return;
						}
						else {
							erros.add("Senha inválida!");
						}
					}
					else {
						erros.add("Usuário não encontrado!");
					}
				}
			}
			request.setAttribute("mensagens", erros);
			String URL = "/login.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(URL);
			rd.forward(request, response);
		}
		else {
			request.getSession().invalidate(); //logout
			String URL = "/index.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(URL);
			rd.forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
	
}

