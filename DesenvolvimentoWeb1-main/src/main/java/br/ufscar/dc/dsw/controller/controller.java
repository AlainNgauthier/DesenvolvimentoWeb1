package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.dao.VeiculoDAO;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.domain.Veiculo;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/veiculos/*")
public class controller extends HttpServlet {

    private static final long serialVersionUID = 1L;


        private VeiculoDAO daoVeiculo;

        private UsuarioDAO daoUsuario;

        @Override
        public void init() {
            daoVeiculo = new VeiculoDAO();
            daoUsuario = new UsuarioDAO();
        }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {

        String action = request.getPathInfo();
        if (action == null) {
            action = "";
        }

        try {
            System.out.println(action);
            switch (action) {
                case"/updateCliente":
                    updateCliente(request, response);
                    break;
                case"/removeUsuario":
                    removeUsuario(request, response);
                    break;
                case"/removeLoja":
                    removeLoja(request, response);
                    break;
                case"/listar":
                    listaVeiculos(request, response);
                    break;
                case"/listarClientes":
                    listaCliente(request, response);
                    break;
                case"/listarLojas":
                    listaLoja(request, response);
                    break;
                case"/paglogin":
                    paglogin(request, response);
                    break;
                case"/adm":
                    adm(request,response);
                    break;
                case"/edicaoCliente":
                    apresentaFormEdicaoCliente(request, response);
                    break;
                case"/cadastrarCliente":
                    apresentaFormCliente(request, response);
                    break;
                case"/insercaoCliente":
                    insereCliente(request, response);
                    break;
                default:
                    inicial(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }

    private void inicial(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("inicial.jsp");
    }

    private void listaVeiculos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Veiculo> listaVeiculos = daoVeiculo.getAllVeiculos();
        request.setAttribute("listaVeiculos", listaVeiculos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/veiculo/lista.jsp");
        dispatcher.forward(request, response);
    }

    private void listaCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Usuario> listaCliente = daoUsuario.getClientes();
        request.setAttribute("listaCliente", listaCliente);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/veiculo/admClientes.jsp");
        dispatcher.forward(request, response);
    }

    private void listaLoja(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Usuario> listaLoja = daoUsuario.getLojas();
        request.setAttribute("listaLoja", listaLoja);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/veiculo/admLojas.jsp");
        dispatcher.forward(request, response);
    }


    private void paglogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/veiculo/login.jsp");
        dispatcher.forward(request, response);
    }

    private void adm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/veiculo/adm.jsp");
        dispatcher.forward(request, response);
    }

   /* private void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String status = "";
        Usuario user = new Usuario();
        user.setEmail(email);
        user.setSenha(senha);
        RequestDispatcher rd = null;
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if (usuarioDAO.verificaUsuario(user)) {
            HttpSession sessao = request.getSession();
            sessao.setAttribute(("sessaoUsuario"), email);
            rd = request.getRequestDispatcher("/veiculo/adm.jsp");
            rd.forward(request, response);
        }else {
            request.setAttribute("msg", "Login inválido");
            response.sendRedirect("inicial.jsp");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/veiculo/adm.jsp");
        dispatcher.forward(request, response);
        }*/


    private Map<Long, String> getClientes() {
        Map <Long,String> clientes = new HashMap<>();
        for (Usuario cliente: new UsuarioDAO().getClientes()) {
            clientes.put(cliente.getId(), cliente.getEmail());
        }
        return clientes;
    }

    private void apresentaFormCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("clientes", getClientes());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/veiculo/formCliente.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicaoCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Usuario usuario = daoUsuario.get(id);
        System.out.println(daoUsuario.get(id));
        request.setAttribute("usuario", usuario);
        request.setAttribute("clientes", getClientes());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/veiculo/formCliente.jsp");
        dispatcher.forward(request, response);
    }

    private void insereCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        //Long id = Long.parseLong(request.getParameter("id"));

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");
        String nasc = request.getParameter("nascimento");
        String sexo = request.getParameter("sexo");
        String cpf = request.getParameter("cpf");
        String categoria = "CLIENTE";
        String tel = request.getParameter("telefone");

        Usuario cliente = new Usuario(email, senha, nome, nasc, sexo, cpf, categoria, tel);

        daoUsuario.registerCliente(cliente);
        response.sendRedirect("adm");
    }

    private void updateCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        Long id = Long.parseLong(request.getParameter("id"));
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");
        String nasc = request.getParameter("nascimento");
        String sexo = request.getParameter("sexo");
        String cpf = request.getParameter("cpf");
        String categoria = "CLIENTE";
        String tel = request.getParameter("telefone");

        Usuario cliente = new Usuario(id, email, senha, nome, nasc, sexo, cpf, categoria, tel);
        daoUsuario.updateCliente(cliente);
        response.sendRedirect("adm");
    }


    private void removeUsuario(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Long id = Long.parseLong(request.getParameter("id"));

        Usuario user = new Usuario(id);
        daoUsuario.delete(user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/veiculo/adm.jsp");
        dispatcher.forward(request, response);
    }

    private void removeLoja(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Long id = Long.parseLong(request.getParameter("id"));

        Usuario user = new Usuario(id);
        daoUsuario.delete(user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/veiculo/adm.jsp");
        dispatcher.forward(request, response);
    }


}

