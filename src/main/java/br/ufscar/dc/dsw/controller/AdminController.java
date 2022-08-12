package br.ufscar.dc.dsw.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.dao.ClienteDAO;
import br.ufscar.dc.dsw.domain.Loja;
import br.ufscar.dc.dsw.dao.LojaDAO;

import br.ufscar.dc.dsw.util.Erro;
import java.util.List;


@WebServlet(urlPatterns = "/admin/*")
public class AdminController extends HttpServlet {

    private static final long serialVersionUID = 1L;

	private LojaDAO daoLoja;
	private ClienteDAO daoCliente;

    @Override
    public void init() {
        daoLoja = new LojaDAO();
		daoCliente = new ClienteDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	Cliente cliente = (Cliente) request.getSession().getAttribute("usuarioLogado");

		if (cliente == null) {
    		erro(request, response);
    	} else if (cliente.getPapel().equals("ADMIN")) {
			String action = request.getPathInfo();
			if (action == null) {
				action = "";
			}

			try {
				switch (action) {
					case "/cadastroLoja":
						apresentaFormCadastroLojas(request, response);
						break;
					case "/insercaoLoja":
						insereLoja(request, response);
						break;
					case "/edicaoLoja":
						apresentaFormEdicaoLojas(request,response);
						break;
					case "/atualizacaoLoja":
						atualizaLoja(request,response);
						break;
					case "/remocaoLoja":
						removeLoja(request, response);
						break;
					case "/listaLojas":
						listaLojas(request, response);
						break;
					case "/cadastroCliente":
						apresentaFormCadastroClientes(request, response);
						break;
					case "/insercaoCliente":
						insereCliente(request, response);
						break;
					case "/edicaoCliente":
						apresentaFormEdicaoClientes(request, response);
						break;
					case "/atualizacaoCliente":
						atualizaCliente(request, response);
						break;
					case "/remocaoCliente":
						removeCliente(request, response);
						break;
					case "/listaClientes":
						listaClientes(request, response);
						break;
					default:
						RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/crudLinks.jsp");
						dispatcher.forward(request, response);
						break;
				}
			} catch (RuntimeException | IOException | ServletException e) {
				throw new ServletException(e);
			}
    		
    	} else {
    		erro(request, response);
    	}
    }

	private void erro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		Erro erros = new Erro();

        erros.add("Acesso não autorizado!");
    	erros.add("Apenas ADMINS tem acesso a essa página");
    	request.setAttribute("mensagens", erros);
    	RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
    	rd.forward(request, response);
    }

	private void listaLojas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Loja> listaLojas = daoLoja.getAll();
        request.setAttribute("listaLojas", listaLojas);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/listaLojas.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormCadastroLojas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {	
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/formularioLojas.jsp");
        dispatcher.forward(request, response);
    }
    
    private void apresentaFormEdicaoLojas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Loja loja = daoLoja.getById(id);
        request.setAttribute("loja", loja);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/formularioLojas.jsp");
        dispatcher.forward(request, response);
    }
    
    private Erro verifica_duplicado(String email, String senha) {
		Erro erros = new Erro();
   		
		int i = 0;
		int ver_cli = 0;
		ClienteDAO dao_cliente = new ClienteDAO();
		List<Cliente> lista_clientes = dao_cliente.getAll();
		while(i<lista_clientes.size() && erros.size() == 0) { //verifica duplicação em cliente
			if(lista_clientes.get(i).getEmail().equals(email)) {
				erros.add("Email já cadastrado");
				ver_cli = 1;
			}
			if(lista_clientes.get(i).getSenha().equals(senha)) {
				if(ver_cli == 0)
					erros.add("Senha já está sendo usada");
			}
			i++;
		}

   		int j = 0;
		int ver_loja = 0;
		LojaDAO dao_loja = new LojaDAO();
		List<Loja> lista_lojas = dao_loja.getAll();
		while(j<lista_lojas.size() && erros.size() == 0) { //verifica duplicação de loja
			if(lista_lojas.get(j).getEmail().equals(email)) {
				erros.add("Email já cadastrado");
				ver_loja = 1;
			}
			if(lista_lojas.get(j).getSenha().equals(senha)) {
				if(ver_loja == 0)
					erros.add("Senha já está sendo usada");
			}
			j++;
		}
		return erros;
    	
    }
    
    private void insereLoja(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	
    	String email = request.getParameter("email");
    	String senha = request.getParameter("senha");
    	String CNPJ = request.getParameter("CNPJ");
    	String nome = request.getParameter("nome");
    	String descricao_loja = request.getParameter("descricao");
    	Erro erros = new Erro();
    	erros = verifica_duplicado(email,senha);
    	Loja loja = new Loja(email, senha, CNPJ, nome, descricao_loja);
    	if(erros.isExisteErros()) {
			request.setAttribute("mensagens", erros);
			String URL = "/logado/admin/formularioLojas.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(URL);
			rd.forward(request, response);
    	}else {
        	daoLoja.insert(loja);
        	// Retorna para a página do CRUD:
        	response.sendRedirect("listaLojas");
    	}
    	
    }
    
    private void atualizaLoja(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String nome = request.getParameter("nome");
    	String email = request.getParameter("email");
    	String senha = request.getParameter("senha");
    	String CNPJ = request.getParameter("CNPJ");
    	String descricao = request.getParameter("descricao");
    	
    	Loja loja = new Loja(id,email,senha,CNPJ,nome,descricao);
    	
        daoLoja.update(loja);
        
        response.sendRedirect("listaLojas");
    }
    
    private void removeLoja(HttpServletRequest request, HttpServletResponse response)
    		throws IOException {
    	String id_s = request.getParameter("id");
    	Long id = Long.parseLong( id_s );
    	Loja loja = new Loja(id);
    	daoLoja.delete(loja);
   
    	// Retorna para a página do CRUD:
    	response.sendRedirect("listaLojas");
    }

	private void listaClientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cliente> listaClientes = daoCliente.getAll();
        request.setAttribute("listaClientes", listaClientes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/listaClientes.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormCadastroClientes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {	
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/formularioClientes.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicaoClientes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Cliente cliente = daoCliente.getbyId(id);
        request.setAttribute("cliente", cliente);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/formularioClientes.jsp");
        dispatcher.forward(request, response);
    }

    private void insereCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

    	Erro erros = new Erro();
    	erros = verifica_duplicado(email,senha);
        String CPF = request.getParameter("CPF");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String sexo = request.getParameter("sexo");
        String nascimento = request.getParameter("nascimento");
        String papel = request.getParameter("papel");
        Cliente cliente = new Cliente(email, senha, CPF, nome, telefone, sexo, nascimento, papel);
        if(erros.isExisteErros()) {
        	System.out.println(erros.getErros().get(0));
			request.setAttribute("mensagens", erros);
			String URL = "/logado/admin/formularioClientes.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(URL);
			rd.forward(request, response);
    	}else {    	
	        daoCliente.insert(cliente);
	        response.sendRedirect("listaClientes");
		}
    }
    
    private void atualizaCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
    	String email = request.getParameter("email");
    	String senha = request.getParameter("senha");
    	String CPF = request.getParameter("CPF");
    	String nome = request.getParameter("nome");
    	String telefone = request.getParameter("telefone");
    	String sexo = request.getParameter("sexo");
    	String nascimento = request.getParameter("nascimento");
    	String papel = request.getParameter("papel");
    	
    	Cliente cliente = new Cliente(id,email,senha,CPF,nome,telefone,sexo, nascimento,papel);
    	
        daoCliente.update(cliente);
        
        response.sendRedirect("listaClientes");
    }
    
    private void removeCliente(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {

		Erro erros = new Erro();
    	String id_s = request.getParameter("id");
    	Long id = Long.parseLong( id_s );  
    	Cliente cliente = (Cliente) request.getSession().getAttribute("usuarioLogado");
    	Cliente cliente_remover = new Cliente(id);
		if (cliente.getId().equals(id)){
			erros.add("Não é possível esse usuário!");
            request.setAttribute("mensagens", erros);
            RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
            rd.forward(request, response);
		}
		else {
			daoCliente.delete(cliente_remover);
			// Retorna para a página do CRUD:
			response.sendRedirect("listaClientes");
		}
    }
}
