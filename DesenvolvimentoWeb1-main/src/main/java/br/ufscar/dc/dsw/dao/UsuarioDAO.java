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
    public void registerAdmin(Usuario usuario) {
        String sql = "INSERT INTO Usuario (email, senha, nome, categoria) VALUES (?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            ;

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
    public void registerCliente(Usuario usuario) {
        String sql = "INSERT INTO Usuario (email, senha, nome, nascimento, sexo, cpf, categoria, telefone) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            ;
            statement = conn.prepareStatement(sql);
            statement.setString(1, usuario.getEmail());
            statement.setString(2, usuario.getSenha());
            statement.setString(3, usuario.getNome());
            statement.setString(4, usuario.getNascimento());
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
    public void registerLoja(Usuario usuario) {
        String sql = "INSERT INTO Usuario (email, senha, nome, cnpj, categoria, descricao) VALUES (?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            ;

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
    public List<Usuario> getAdmins() {

        List<Usuario> listAdmins = new ArrayList<>();

        String sql = "SELECT * from Usuario u WHERE categoria = 'ADMIN'";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                //long id = resultSet.getLong("id");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String nome = resultSet.getString("nome");
                String categoria = resultSet.getString("categoria");
                Usuario admin = new Usuario(email, senha, nome, categoria);
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
    public List<Usuario> getClientes() {

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
                String nascimento = resultSet.getString("nascimento");
                String sexo = resultSet.getString("sexo");
                String cpf = resultSet.getString("cpf");
                String categoria = resultSet.getString("categoria");
                String telefone = resultSet.getString("telefone");


                Usuario cliente = new Usuario(id, email, senha, nome, nascimento, sexo, cpf, categoria, telefone);
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
    public List<Usuario> getLojas() {

        List<Usuario> listLojas = new ArrayList<>();

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
                Usuario agencia = new Usuario(id, email, senha, nome, cnpj, categoria, descricao);
                listLojas.add(agencia);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listLojas;
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
            statement.setString(4, usuario.getCategoria());
            statement.setString(5, usuario.getCpf());
            statement.setString(6, usuario.getTelefone());
            statement.setString(7, usuario.getSexo());
            statement.setString(8, usuario.getNascimento());
            statement.setLong(9, usuario.getId());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // LOJA
    public void updateAgencia(Usuario usuario) {
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

    // DELETE
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

    public Usuario get(Long id) {
        Usuario usuario = null;

        String sql = "SELECT * from Usuario user where user.id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String nome = resultSet.getString("nome");
                String nascimento = resultSet.getString("nascimento");
                String sexo = resultSet.getString("sexo");
                String cpf = resultSet.getString("cpf");
                String categoria = resultSet.getString("categoria");
                String telefone = resultSet.getString("telefone");

                usuario = new Usuario(id, email, senha, nome, nascimento, sexo, cpf, categoria, telefone);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }

}

