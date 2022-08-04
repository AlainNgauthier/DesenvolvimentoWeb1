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
import br.ufscar.dc.dsw.util.Erro;

@WebServlet(urlPatterns = "/admin/*")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDAO dao;

	@Override
	public void init() {
		dao = new UsuarioDAO();
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
		} else if (!usuario.getCategoria().equals("ADMIN")) {
			erros.add("Acesso não autorizado!");
			erros.add("Apenas Papel [ADMIN] tem acesso a essa página");
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
				case "/cadastroCliente":
					apresentaFormularioCadastroCliente(request, response);
					break;
				case "/inserirCliente":
					insereCliente(request, response);
					break;
				case "/cadastroLoja":
					apresentaFormularioCadastroLoja(request, response);
					break;
				case "/inserirLoja":
					insereLoja(request, response);
					break;
				case "/listaClientes":
					listaClientes(request, response);
					break;
				case "/listaLojas":
					listaLojas(request, response);
					break;
				case "/atualizaCliente":
					apresentaFormularioEdicaoCliente(request, response);
					break;
				case "/atualizarCliente":
					atualizaCliente(request, response);
					break;
				case "/atualizaLoja":
					apresentaFormularioEdicaoLoja(request, response);
					break;
				case "/atualizarLoja":
					atualizaAgencia(request, response);
					break;
				case "/removeCliente":
					removeCliente(request, response);
					break;
				case "/removeLoja":
					removeLoja(request, response);
					break;
				default:
					paginaInicial(request, response);
					break;
			}
		} catch (RuntimeException | IOException | ServletException e) {
			throw new ServletException(e);
		}
	}
	
	//Página inicial
	private void paginaInicial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/index.jsp");
		dispatcher.forward(request, response);
	}
	
	//apresentaFormularioCadastroCliente
	private void apresentaFormularioCadastroCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/formulario.jsp");
		request.setAttribute("usuario", "cliente");
		dispatcher.forward(request, response);
	}
	
	//insereCliente
	private void insereCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String nome = request.getParameter("nome");	
		Date nascimento = null;
		String sexo = request.getParameter("sexo");
		String cpf = request.getParameter("cpf");
		String categoria = "CLIENTE";	
		String telefone = request.getParameter("telefone");				

		try {
			nascimento = new java.sql.Date((new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("nascimento"))).getTime());
		} catch (Exception e) {
		}

		Usuario cliente = new Usuario(email, senha, nome, nascimento, sexo, cpf, categoria, telefone );

		dao.insertCliente(cliente);
		response.sendRedirect("listaClientes");
	}
	
	//apresentaFormularioCadastroLoja
	private void apresentaFormularioCadastroLoja(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/formulario.jsp");
		request.setAttribute("usuario", "agencia");
		dispatcher.forward(request, response);
	}
	
	//insereLoja
	private void insereLoja(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String nome = request.getParameter("nome");
		String cnpj = request.getParameter("cnpj");
		String categoria = "LOJA";
		String descricao = request.getParameter("descricao");
		
		Usuario loja = new Usuario(email, senha, nome, categoria, cnpj, descricao);

		dao.insertLoja(loja);
		response.sendRedirect("listaLojas");
	}
	
	//listaClientes
	private void listaClientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> listaClientes = dao.getAllClientes();
		request.setAttribute("listaClientes", listaClientes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/listaClientes.jsp");
		dispatcher.forward(request, response);
	}
	
	//listaLojas
	private void listaLojas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> listaLojas = dao.getAllLojas();
		request.setAttribute("listaAgencias", listaLojas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/listaAgencias.jsp");
		dispatcher.forward(request, response);
	}
	
	//apresentaFormularioEdicaoCliente
	private void apresentaFormularioEdicaoCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Usuario cliente = dao.get(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/formulario.jsp");
		request.setAttribute("cliente", cliente);
		dispatcher.forward(request, response);
	}
	
	//atualizaCliente
	private void atualizaCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Long id = Long.parseLong(request.getParameter("id"));		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String nome = request.getParameter("nome");		
		Date nascimento = null;
		String sexo = request.getParameter("sexo");
		String cpf = request.getParameter("cpf");
		String categoria = "CLIENTE";		
		String telefone = request.getParameter("telefone");			

		try {
			nascimento = new java.sql.Date((new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("nascimento"))).getTime());
		} catch (Exception e) {
		}
		
		Usuario cliente = new Usuario(id, email, senha, nome, nascimento, sexo, cpf, categoria, telefone);

		dao.updateCliente(cliente);
		response.sendRedirect("listaClientes");
	}
	
	//apresentaFormularioEdicaoLoja
	private void apresentaFormularioEdicaoLoja(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Usuario loja = dao.get(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/formulario.jsp");
		request.setAttribute("loja", loja);
		dispatcher.forward(request, response);
	}
	
	//atualizaLoja
	private void atualizaAgencia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String categoria = "LOJA";
		String cnpj = request.getParameter("cnpj");
		String descricao = request.getParameter("descricao");
		
		Usuario agencia = new Usuario(id, email, senha, nome, cnpj, categoria, descricao);

		dao.updateLoja(agencia);
		response.sendRedirect("listaAgencias");
	}
	
	//removeCliente
	private void removeCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Usuario cliente = new Usuario(id);
		dao.delete(cliente);
		response.sendRedirect("listaClientes");
	}
	
	//removeLoja
	private void removeLoja(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Usuario loja = new Usuario(id);
		dao.delete(loja);
		response.sendRedirect("listaLojas");
	}
	
	
}