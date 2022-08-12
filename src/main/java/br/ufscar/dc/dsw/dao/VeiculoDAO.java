package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Loja;
import br.ufscar.dc.dsw.domain.Veiculo;

public class VeiculoDAO extends GenericDAO {

    public void insert(Veiculo veiculo) {    
        String sql = "INSERT INTO Veiculo (placa, modelo, chassi, ano, quilometragem, descricao, valor, id_loja) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;    
            statement = conn.prepareStatement(sql);
            statement.setString(1, veiculo.getPlaca());
            statement.setString(2, veiculo.getModelo());
            statement.setString(3, veiculo.getChassi());
            statement.setInt(4, veiculo.getAno());
            statement.setInt(5, veiculo.getQuilometragem());
            statement.setString(6, veiculo.getDescricao());
            statement.setFloat(7, veiculo.getValor());
            statement.setLong(8, veiculo.getLoja().getId());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Veiculo> getAll() {   
        List<Veiculo> listaVeiculos = new ArrayList<>();
        String sql = "SELECT * from Veiculo v, Loja l where v.id_loja = l.id order by v.id";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
            	Long id =  resultSet.getLong("id");
                String placa = resultSet.getString("placa");
                String modelo = resultSet.getString("modelo");
                String chassi = resultSet.getString("chassi");
                Integer ano = resultSet.getInt("ano");
                Integer quilometragem = resultSet.getInt("quilometragem");
                String descricao = resultSet.getString("descricao");
                float valor = resultSet.getFloat("valor");
                
                Long loja_id = resultSet.getLong(6);
    			String email = resultSet.getString("email");
				String senha = resultSet.getString("senha");
				String nome = resultSet.getString("nome");
				String cnpj = resultSet.getString("CNPJ");
				String descricao_loja = resultSet.getString("l.descricao");

                Loja loja = new Loja(loja_id,email,senha,cnpj,nome,descricao_loja);
                Veiculo veiculo = new Veiculo(id,placa,modelo,chassi,ano,quilometragem,descricao,valor,loja);
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

    public List<Veiculo> getAllByLoja(Long id_loja) {   
        List<Veiculo> listaVeiculos = new ArrayList<>();
        String sql = "SELECT * from Veiculo v, Loja l where l.id = ? and v.id_loja = l.id order by v.id";
        
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setLong(1, id_loja);
            
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	Long id =  resultSet.getLong("id");
                String placa = resultSet.getString("placa");
                String modelo = resultSet.getString("modelo");
                String chassi = resultSet.getString("chassi");
                Integer ano = resultSet.getInt("ano");
                Integer quilometragem = resultSet.getInt("quilometragem");
                String descricao = resultSet.getString("descricao");
                float valor = resultSet.getFloat("valor");
                
                Long loja_id = resultSet.getLong("id");
    			String email = resultSet.getString("email");
				String senha = resultSet.getString("senha");
				String nome = resultSet.getString("nome");
				String cnpj = resultSet.getString("CNPJ");
				String descricao_loja = resultSet.getString("l.descricao");

                Loja loja = new Loja(loja_id,email,senha,cnpj,nome,descricao_loja);
                Veiculo veiculo = new Veiculo(id,placa,modelo,chassi,ano,quilometragem,descricao,valor,loja);
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
    
    public void delete(Veiculo veiculo) {
        String sql = "DELETE FROM Veiculo where id = ?";
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
    
    public void update(Veiculo veiculo) {
        String sql = "UPDATE Veiculo SET placa = ?, modelo = ?, chassi = ?, ano = ?, quilometragem = ?, descricao = ?, valor = ?, id_loja = ? WHERE id = ?";
    
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, veiculo.getPlaca());
            statement.setString(2, veiculo.getModelo());
            statement.setString(3, veiculo.getChassi());
            statement.setInt(4, veiculo.getAno());
            statement.setInt(5, veiculo.getQuilometragem());
            statement.setString(6, veiculo.getDescricao());
            statement.setFloat(7, veiculo.getValor());
            statement.setLong(8, veiculo.getLoja().getId());
            statement.setLong(9,veiculo.getId());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Veiculo getById(Long id) {
        Veiculo veiculo = null;
        String sql = "SELECT * from Veiculo v, Loja l where v.id = ? and v.id_loja = l.id";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	String placa = resultSet.getString("placa");
                String modelo = resultSet.getString("modelo");
                String chassi = resultSet.getString("chassi");
                Integer ano = resultSet.getInt("ano");
                Integer quilometragem = resultSet.getInt("quilometragem");
                String descricao = resultSet.getString("descricao");
                Float valor = resultSet.getFloat("valor");
                Long id_loja = resultSet.getLong("id_loja");
                
                Loja loja = new LojaDAO().getById(id_loja);
                veiculo = new Veiculo(id,placa, modelo, chassi, ano, quilometragem, descricao, valor,loja);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return veiculo;
    }
}
