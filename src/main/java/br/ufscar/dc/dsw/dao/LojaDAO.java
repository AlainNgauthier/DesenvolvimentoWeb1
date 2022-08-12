package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Loja;

public class LojaDAO extends GenericDAO{
	
	
	public void insert(Loja loja) {

        String sql = "INSERT INTO Loja (email, senha, CNPJ, nome, descricao) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, loja.getEmail());
            statement.setString(2, loja.getSenha());
            statement.setString(3, loja.getCNPJ());
            statement.setString(4, loja.getNome());
            statement.setString(5, loja.getDescricao());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	

	public List<Loja> getAll() {
		
		List<Loja> listaLojas = new ArrayList<>();
		
		String sql = "SELECT * from Loja";
		
		try {
			Connection conn = this.getConnection();
			Statement statement = conn.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				String email = resultSet.getString("email");
				String senha = resultSet.getString("senha");
				String nome = resultSet.getString("nome");
				String cnpj = resultSet.getString("CNPJ");
				String descricao = resultSet.getString("descricao");
				Loja loja = new Loja(id,email, senha, cnpj, nome, descricao);
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
	
	public void delete(Loja loja) {
        String sql = "DELETE FROM Loja where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, loja.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public void update(Loja loja) {
	        String sql = "UPDATE Loja SET email = ?, senha = ?, CNPJ = ?, nome = ?";
	        sql += ", descricao = ? WHERE id = ?";
	        try {
	            Connection conn = this.getConnection();
	            PreparedStatement statement = conn.prepareStatement(sql);

	            statement.setString(1, loja.getEmail());
	            statement.setString(2, loja.getSenha());
	            statement.setString(3, loja.getCNPJ());
	            statement.setString(4, loja.getNome());
	            statement.setString(5, loja.getDescricao());
	            statement.setLong(6, loja.getId());
	            statement.executeUpdate();

	            statement.close();
	            conn.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }
	 
	public Loja getById(Long id) {
	        Loja loja = null;

	        String sql = "SELECT * from Loja WHERE id = ?";

	        try {
	            Connection conn = this.getConnection();
	            PreparedStatement statement = conn.prepareStatement(sql);

	            statement.setLong(1, id);
	            ResultSet resultSet = statement.executeQuery();
	            if (resultSet.next()) {
	                String email = resultSet.getString("email");
	                String senha = resultSet.getString("senha");
	                String cnpj = resultSet.getString("CNPJ");
	                String nome = resultSet.getString("nome");
	                String descricao = resultSet.getString("descricao");
	                loja = new Loja(id, email, senha, cnpj, nome, descricao);
	            }

	            resultSet.close();
	            statement.close();
	            conn.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return loja;
	    }
	public Loja getbyLogin(String login) {
			Loja loja = null;
			String sql = "SELECT * from Loja WHERE email = ?";
			try {
				Connection conn = this.getConnection();
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, login);
				ResultSet resultSet = statement.executeQuery();
				if (resultSet.next()) {
					Long id = resultSet.getLong("id");
					String senha = resultSet.getString("senha");
	                String CNPJ = resultSet.getString("CNPJ");
	                String nome = resultSet.getString("nome");
	                String descricao = resultSet.getString("descricao");
					loja = new Loja(id, login, senha, CNPJ, nome, descricao);
				}
				resultSet.close();
				statement.close();
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return loja;
		}
}
