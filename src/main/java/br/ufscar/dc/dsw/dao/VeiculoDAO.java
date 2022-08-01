package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;

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
	
	/* READ ALL VEICULOS - 4 */
	public List<Veiculo> getAllVeiculos() {

        List<Veiculo> list = new ArrayList<>();

        String sql = "SELECT * from Veiculo v, Usuario u WHERE v.cnpj = u.cnpj";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String cnpj = resultSet.getString("cnpj");
                String placa = resultSet.getString("placa");
                String chassi = resultSet.getString("chassi");
                String modelo = resultSet.getString("modelo");
                String descricao = resultSet.getString("descricao");
                Integer ano = resultSet.getInt("ano");
                Float kilometragem = resultSet.getFloat("kilometragem");
                Float valor = resultSet.getFloat("valor");
                
                Long loja_id = resultSet.getLong(10);
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String loja_nome = resultSet.getString("nome");
                String categoria = resultSet.getString("categoria");
                String descricao_loja = resultSet.getString(15);
                Usuario loja = new Usuario(loja_id, email, senha, loja_nome, cnpj, categoria,  descricao_loja);
                Veiculo veiculo = new Veiculo(id, loja, placa, chassi, modelo, descricao, ano, kilometragem, valor);
                list.add(veiculo);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
	}
	
	// FILTER VEICULO BY MODELO - 4b
	public List<Veiculo> getAllVeiculosPorModelo(String modelo) {
		List<Veiculo> list = new ArrayList<>();
		Veiculo veiculo = null;
		
		String sql = "SELECT * from Veiculo v, Usuario u WHERE v.modelo = ? AND v.cnpj = u.cnpj";
		
		try {
			Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, modelo);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
            	 Long id = resultSet.getLong("id");
                 String cnpj = resultSet.getString("cnpj");
                 String placa = resultSet.getString("placa");
                 String chassi = resultSet.getString("chassi");
                 //String modelo_veiculo = resultSet.getString("modelo");
                 String descricao = resultSet.getString("descricao");
                 Integer ano = resultSet.getInt("ano");
                 Float kilometragem = resultSet.getFloat("kilometragem");
                 Float valor = resultSet.getFloat("valor");
                 
                 Long loja_id = resultSet.getLong(10);
                 String email = resultSet.getString("email");
                 String senha = resultSet.getString("senha");
                 String loja_nome = resultSet.getString("nome");
                 String categoria = resultSet.getString("categoria");
                 String descricao_loja = resultSet.getString(15);
                 
                 Usuario loja = new Usuario(loja_id, email, senha, loja_nome, cnpj, categoria, descricao_loja);
                 veiculo = new Veiculo(id, loja, placa, chassi, modelo, descricao, ano, kilometragem, valor);
                 
                 list.add(veiculo);
            }
		} catch (SQLException e) {
            throw new RuntimeException(e);
        }
		
		return list;
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
}