package br.ufscar.dc.dsw.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.domain.Veiculo;
import br.ufscar.dc.dsw.dao.VeiculoDAO;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.util.Erro;
import br.ufscar.dc.dsw.dao.PropostaDAO;
import br.ufscar.dc.dsw.domain.Proposta;

import java.util.List;

@WebServlet(urlPatterns = "/clientes/*")
public class ClienteController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cliente usuario = (Cliente) request.getSession().getAttribute("usuarioLogado");
    	
    	if (usuario == null) {
    		erro(request, response);
    	} else if (usuario.getPapel().equals("USER")) {
            String action = request.getPathInfo();
			if (action == null) {
				action = "";
			}

			try {
				switch (action) {
					case "/comprar":
						comprar(request, response);
						break;
					default:
						catalogo(request, response);
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
    	erros.add("Apenas CLIENTES tem acesso a essa página");
    	request.setAttribute("mensagens", erros);
    	RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
    	rd.forward(request, response);
    }

    private void catalogo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        VeiculoDAO dao = new VeiculoDAO();
        List<Veiculo> catalogo = dao.getAll();
        request.setAttribute("catalogo", catalogo);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/cliente/inicio.jsp");
        dispatcher.forward(request, response);
	}
    
    private void comprar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	Cliente cliente = (Cliente) request.getSession().getAttribute("usuarioLogado");
    	String id_s = request.getParameter("id");
		Long id = Long.parseLong(id_s);
		VeiculoDAO dao = new VeiculoDAO();
		Veiculo veiculo = dao.getById(id);
		PropostaDAO dao_proposta = new PropostaDAO();
		List<Proposta> listaPropostas = dao_proposta.getAllbyCliente(cliente.getId());
		
        request.setAttribute("veiculo", veiculo);
        request.setAttribute("listaPropostas", listaPropostas);
        
//        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY +  id_s;
//		File dir = new File(uploadPath);
//		int num_files;
//	    File[] directoryListing = dir.listFiles();
//		if (directoryListing != null){
//	    	num_files = directoryListing.length;
//		}
//		else {
//			num_files = 0;
//		}
//	    
//	    request.setAttribute("num_files", num_files);
		
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/cliente/comprar.jsp");
        dispatcher.forward(request, response);

	}
    
}
