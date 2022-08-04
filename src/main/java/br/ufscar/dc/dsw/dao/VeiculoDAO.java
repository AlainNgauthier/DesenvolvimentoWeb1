package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import br.ufscar.dc.dsw.domain.Veiculo;
import br.ufscar.dc.dsw.domain.Usuario;



// CRUD VEICULOS
public class VeiculoDAO extends GenericDAO {
	
	/* CREATE VEICULO - 3 */
	public void insert(Veiculo veiculo) {
		String sql = "INSERT INTO Veiculo (cnpj, placa, chassi, modelo, descricao, ano, kilometragem, valor) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement = conn.prepareStatement(sql);
            statement.setString(1, veiculo.getLoja().getCnpj());
            statement.setString(2, veiculo.getPlaca());
            statement.setString(3, veiculo.getChassi());
            statement.setString(4, veiculo.getModelo());
            statement.setString(5, veiculo.getDescricao());
            statement.setInt(6, veiculo.getAno());
            statement.setFloat(7, veiculo.getKilometragem());
            statement.setFloat(8, veiculo.getValor());
            
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	/* READ ALL VEICULOS - REQ 4 */
	public List<Veiculo> getAllVeiculos() {

        List<Veiculo> listaVeiculos = new ArrayList<>();

        String sql = "SELECT * from Veiculo v, Usuario u WHERE v.cnpj = u.cnpj";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
            	// veículo
                Long id = resultSet.getLong("id");
                String cnpj = resultSet.getString("cnpj");
                String placa = resultSet.getString("placa");
                String chassi = resultSet.getString("chassi");
                String modelo = resultSet.getString("modelo");
                String descricao = resultSet.getString("descricao");
                Integer ano = resultSet.getInt("ano");
                Float kilometragem = resultSet.getFloat("kilometragem");
                Float valor = resultSet.getFloat("valor");
                //usuário
                Long loja_id = resultSet.getLong(10);
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String loja_nome = resultSet.getString("nome");
                String categoria = resultSet.getString("categoria");
                String descricao_loja = resultSet.getString(15);
                Usuario loja = new Usuario(loja_id, email, senha, loja_nome, cnpj, categoria,  descricao_loja);
                Veiculo veiculo = new Veiculo(id, loja, placa, chassi, modelo, descricao, ano, kilometragem, valor);
                listaVeiculos.add(veiculo);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaVeiculos;
	}
	
	//Todos os veiculos de uma loja (usuário loja logado) - REQ 6
	public List<Veiculo> getAllVeiculosLoja(Usuario usuario) {

        List<Veiculo> listaVeiculosLoja = new ArrayList<>();

        String sql = "SELECT * from Veiculo v, Usuario u WHERE u.id = ? AND v.cnpj = u.cnpj";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            Long id = usuario.getId();

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	//veiculo
                long veiculo_id = resultSet.getLong(1);
                String placa = resultSet.getString("placa");
                String cnpj = resultSet.getString("cnpj");
                String chassi = resultSet.getString("chassi");
                String modelo = resultSet.getString("modelo");
                String descricao = resultSet.getString("descricao");
                Integer ano = resultSet.getInt("ano");
                Float kilometragem = resultSet.getFloat("kilometragem");
                Float valor = resultSet.getFloat("valor");
                //usuário loja                                      
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String nome = resultSet.getString("nome");
                String categoria = resultSet.getString("categoria");
                String descricao_loja = resultSet.getString(15);
                
                Usuario loja = new Usuario(id, email, senha, nome, cnpj, categoria, descricao_loja);
                Veiculo veiculo = new Veiculo(veiculo_id, loja, placa, chassi, modelo, descricao, ano, kilometragem, valor);
                listaVeiculosLoja.add(veiculo);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaVeiculosLoja;
    }
	
	//GET um veiculo pelo seu id
	 public Veiculo get(Long id) {
		 Veiculo veiculo = null;

	        String sql = "SELECT * from Veiculo v, Usuario u WHERE v.id = ? AND v.cnpj = u.cnpj";

	        try {
	            Connection conn = this.getConnection();
	            PreparedStatement statement = conn.prepareStatement(sql);

	            statement.setLong(1, id);
	            ResultSet resultSet = statement.executeQuery();
	            if (resultSet.next()) {
	            	// veiculo
	            	//long id = resultSet.getLong(1);
	                String cnpj = resultSet.getString("cnpj");
	                String placa = resultSet.getString("placa");
	                String chassi = resultSet.getString("chassi");
	                String modelo = resultSet.getString("modelo");
	                String descricao = resultSet.getString("descricao");
	                Integer ano = resultSet.getInt("ano");
	                Float kilometragem = resultSet.getFloat("kilometragem");
	                Float valor = resultSet.getFloat("valor");
	                
	                //usuário
	                long agencia_id = resultSet.getLong(10);
	                String email = resultSet.getString("email");
	                String senha = resultSet.getString("senha");
	                String nome = resultSet.getString("nome");
	                String categoria = resultSet.getString("categoria");
	                String descricao_loja = resultSet.getString("descricao");
	                Usuario agencia = new Usuario(agencia_id, email, senha, nome, cnpj, categoria, descricao_loja);
	                veiculo = new Veiculo(id, agencia, placa, chassi, modelo, descricao, ano, kilometragem, valor);
	            }

	            resultSet.close();
	            statement.close();
	            conn.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return veiculo;
	    }
	
	// FILTERING VEICULO BY MODELO - 4b
	public List<Veiculo> getAllVeiculosPorModelo(String modelo) {
		List<Veiculo> listVeiculosByModelo = new ArrayList<>();
		//Veiculo veiculo = null;
		
		String sql = "SELECT * from Veiculo v, Usuario u WHERE v.modelo = ? AND v.cnpj = u.cnpj";
		
		try {
			Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, modelo);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
            	 // veiculo
            	 Long id = resultSet.getLong("id");
                 String cnpj = resultSet.getString("cnpj");
                 String placa = resultSet.getString("placa");
                 String chassi = resultSet.getString("chassi");
                 String modelo_veiculo = resultSet.getString("modelo");
                 String descricao = resultSet.getString("descricao");
                 Integer ano = resultSet.getInt("ano");
                 Float kilometragem = resultSet.getFloat("kilometragem");
                 Float valor = resultSet.getFloat("valor");
                 // usuário loja
                 Long loja_id = resultSet.getLong(10);
                 String email = resultSet.getString("email");
                 String senha = resultSet.getString("senha");
                 String loja_nome = resultSet.getString("nome");
                 String categoria = resultSet.getString("categoria");
                 String descricao_loja = resultSet.getString(15);
                 
                 Usuario loja = new Usuario(loja_id, email, senha, loja_nome, cnpj, categoria, descricao_loja);
                 Veiculo veiculo = new Veiculo(id, loja, placa, chassi, modelo_veiculo, descricao, ano, kilometragem, valor);
                 
                 listVeiculosByModelo.add(veiculo);
            }
		} catch (SQLException e) {
            throw new RuntimeException(e);
        }
		
		return listVeiculosByModelo;
	}
	
	//UPDATE VEICULO
	public void update(Veiculo veiculo) {
		String sql="UPDATE Veiculo SET cnpj= ?, placa = ?, chassi = ?, modelo = ?, descricao = ?, ano = ?, kilometragem = ?, valor = ? WHERE id = ?";
		try {
			Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, veiculo.getLoja().getCnpj());
            statement.setString(2, veiculo.getPlaca());
            statement.setString(3, veiculo.getChassi());
            statement.setString(4, veiculo.getModelo());
            statement.setString(5, veiculo.getDescricao());
            statement.setInt(6, veiculo.getAno());
            statement.setFloat(7, veiculo.getKilometragem());
            statement.setFloat(8, veiculo.getValor());
            statement.setLong(9, veiculo.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	// DELETE VEICULO
	public void delete(Veiculo veiculo) {
        String sql = "DELETE FROM Pacote where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, veiculo.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
        }
    }
	
	public List<Veiculo> getAllVeiculosCliente(Usuario usuario) {
        List<Veiculo> lista = null;

        return lista;
    }
}