package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.domain.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

//CRUD USUARIOS E FILTROS
public class UsuarioDAO extends GenericDAO {
	
	// CREATE ADMIN
	public void insertAdmin(Usuario usuario) {
		String sql = "INSERT INTO Usuario (email, senha, nome, categoria) VALUES (?, ?, ?, ?)";
		
		try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;

            statement = conn.prepareStatement(sql);
            statement.setString(1, usuario.getEmail());
            statement.setString(2, usuario.getSenha());
            statement.setString(3, usuario.getNome());
            statement.setString(4, "ADMIN");
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}

	// CREATE CLIENTE
	public void insertCliente(Usuario usuario) {
		String sql = "INSERT INTO Usuario (email, senha, nome, nascimento, sexo, cpf, categoria, telefone) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;

            statement = conn.prepareStatement(sql);
            statement.setString(1, usuario.getEmail());
            statement.setString(2, usuario.getSenha());
            statement.setString(3, usuario.getNome());
            statement.setDate(4, usuario.getNascimento());
            statement.setString(5, usuario.getSexo());
            statement.setString(6, usuario.getCpf());
            statement.setString(7, "CLIENTE");
            statement.setString(8, usuario.getTelefone());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	// CREATE LOJA
	public void insertLoja(Usuario usuario) {
		String sql = "INSERT INTO Usuario (email, senha, nome, cnpj, categoria, descricao) VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;

            statement = conn.prepareStatement(sql);
            statement.setString(1, usuario.getEmail());
            statement.setString(2, usuario.getSenha());
            statement.setString(3, usuario.getNome());
            statement.setString(4, usuario.getCnpj());
            statement.setString(5, "LOJA");
            statement.setString(6, usuario.getDescricao());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	// READ USERS
	// ADMIN
	public List<Usuario> getAllAdmins() {

	        List<Usuario> listAdmins = new ArrayList<>();

	        String sql = "SELECT * from Usuario u WHERE categoria = 'ADMIN'";

	        try {
	            Connection conn = this.getConnection();
	            Statement statement = conn.createStatement();

	            ResultSet resultSet = statement.executeQuery(sql);
	            while (resultSet.next()) {
	                long id = resultSet.getLong("id");
	                String email = resultSet.getString("email");
	                String senha = resultSet.getString("senha");
	                String nome = resultSet.getString("nome");
	                String categoria = resultSet.getString("categoria");
	                Usuario admin = new Usuario(id, email, senha, nome, categoria);
	                listAdmins.add(admin);
	            }

	            resultSet.close();
	            statement.close();
	            conn.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return listAdmins;
	}
	 
	// CLIENTE
	public List<Usuario> getAllClientes() {

	        List<Usuario> listClientes = new ArrayList<>();

	        String sql = "SELECT * from Usuario u WHERE categoria = 'CLIENTE'";

	        try {
	            Connection conn = this.getConnection();
	            Statement statement = conn.createStatement();

	            ResultSet resultSet = statement.executeQuery(sql);
	            while (resultSet.next()) {
	                Long id = resultSet.getLong("id");
	                String email = resultSet.getString("email");
	                String senha = resultSet.getString("senha");
	                String nome = resultSet.getString("nome");
	                Date nascimento = resultSet.getDate("nascimento");
	                String sexo = resultSet.getString("sexo");
	                String cpf = resultSet.getString("cpf");
	                String categoria = resultSet.getString("categoria");
	                String telefone = resultSet.getString("telefone");
	                
	                
	                Usuario cliente = new Usuario(id, email, senha, nome, nascimento, sexo, cpf, categoria,  telefone);
	                listClientes.add(cliente);
	            }

	            resultSet.close();
	            statement.close();
	            conn.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return listClientes;
	 }
	
	// LOJAS
	public List<Usuario> getAllLojas() {

        List<Usuario> listaLojas = new ArrayList<>();

        String sql = "SELECT * from Usuario u WHERE categoria = 'LOJA'";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String nome = resultSet.getString("nome");
                String cnpj = resultSet.getString("cnpj");
                String categoria = resultSet.getString("categoria");
                String descricao = resultSet.getString("descricao");
                Usuario loja = new Usuario(id, email, senha, nome, cnpj, categoria, descricao);
                listaLojas.add(loja);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLojas;
    }
	
	// UPDATE
	// ADMIN
	public void updateAdmin(Usuario usuario) {
        String sql = "UPDATE Usuario SET email = ?, senha = ?, nome = ?, categoria = ? WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, usuario.getEmail());
            statement.setString(2, usuario.getSenha());
            statement.setString(3, usuario.getNome());
            statement.setString(4, usuario.getCategoria());
            statement.setLong(5, usuario.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	// CLIENTE
	public void updateCliente(Usuario usuario) {
        String sql = "UPDATE Usuario SET email = ?, senha = ?, nome = ?, nascimento = ?, sexo = ?, cpf = ?, categoria = ?,  telefone = ? WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, usuario.getEmail());
            statement.setString(2, usuario.getSenha());
            statement.setString(3, usuario.getNome());
            statement.setDate(4, usuario.getNascimento());
            statement.setString(5, usuario.getSexo());
            statement.setString(6, usuario.getCpf());
            statement.setString(7, usuario.getCategoria());
            statement.setString(8, usuario.getTelefone());
            statement.setLong(9, usuario.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	// LOJA
	public void updateLoja(Usuario usuario) {
        String sql = "UPDATE Usuario SET email = ?, senha = ?, nome = ?, cnpj = ?, categoria = ?, descricao = ? WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, usuario.getEmail());
            statement.setString(2, usuario.getSenha());
            statement.setString(3, usuario.getNome());
            statement.setString(4, usuario.getCategoria());
            statement.setString(5, usuario.getCnpj());
            statement.setString(6, usuario.getDescricao());
            statement.setLong(7, usuario.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	// DELETE usuario
	public void delete(Usuario usuario) {
        String sql = "DELETE FROM Usuario where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, usuario.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
        }
    }
	
	// GET usuário por id
	public Usuario get(Long id) {
        Usuario usuario = null;

        String sql = "SELECT * from Usuario WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String nome = resultSet.getString("nome");
                String categoria = resultSet.getString("categoria");
                if (categoria.equals("ADMIN")) {
                    usuario = new Usuario(id, email, senha, nome,  categoria);
                } else if (categoria.equals("CLIENTE")) {
                    String cpf = resultSet.getString("cpf");
                    String telefone = resultSet.getString("telefone");
                    String sexo = resultSet.getString("sexo");
                    Date nascimento = resultSet.getDate("nascimento");
                    usuario = new Usuario(id, email, senha, nome, nascimento, sexo, cpf, categoria, telefone);
                } else {
                    String cnpj = resultSet.getString("cnpj");
                    String descricao = resultSet.getString("descricao");
                    usuario = new Usuario(id, email, senha, nome, cnpj, categoria,  descricao);
                }
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }
	
	// GET USER BY LOGIN
	 public Usuario getbyLogin(String email) {
	        Usuario usuario = null;

	        String sql = "SELECT * FROM Usuario WHERE email = ?";

	        try {
	            Connection conn = this.getConnection();
	            PreparedStatement statement = conn.prepareStatement(sql);

	            statement.setString(1, email);
	            ResultSet resultSet = statement.executeQuery();
	            if (resultSet.next()) {
	                Long id = resultSet.getLong("id");
	                String nome = resultSet.getString("nome");
	                String senha = resultSet.getString("senha");
	                String categoria = resultSet.getString("categoria");
	                if (categoria.equals("ADMIN")) {
	                    usuario = new Usuario(id, email, nome, senha, categoria);
	                } else if (categoria.equals("CLIENTE")) {
	                    String cpf = resultSet.getString("cpf");
	                    String telefone = resultSet.getString("telefone");
	                    String sexo = resultSet.getString("sexo");
	                    Date nascimento = resultSet.getDate("nascimento");
	                    usuario = new Usuario(id, email, senha, nome, nascimento, sexo, cpf, categoria, telefone);
	                } else {
	                    String cnpj = resultSet.getString("cnpj");
	                    String descricao = resultSet.getString("descricao");
	                    usuario = new Usuario(id, email, senha, nome, categoria, cnpj, descricao);
	                }
	            }

	            resultSet.close();
	            statement.close();
	            conn.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return usuario;
	    }
	 
	 //GET LOJA BY CNPJ - relação Fk Veiculo
	 public Usuario getLojaByCnpj(String cnpj) {
	        Usuario agencia = null;

	        String sql = "SELECT * FROM Usuario WHERE cnpj = ?";

	        try {
	            Connection conn = this.getConnection();
	            PreparedStatement statement = conn.prepareStatement(sql);

	            statement.setString(1, cnpj);
	            ResultSet resultSet = statement.executeQuery();
	            if (resultSet.next()) {
	                Long id = resultSet.getLong("id");
	                String email = resultSet.getString("email");
	                String senha = resultSet.getString("senha");
	                String nome = resultSet.getString("nome");
	                String categoria = resultSet.getString("categoria");
	                String descricao = resultSet.getString("descricao");

	                agencia = new Usuario(id, email, senha, nome, cnpj, categoria, descricao);
	            }

	            resultSet.close();
	            statement.close();
	            conn.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return agencia;
	    }
	 
}

