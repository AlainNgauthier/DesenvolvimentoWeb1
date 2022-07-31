package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


abstract public class AcessaBDDAO {

	public AcessaBDDAO() {
		try {
			/* Setup para uso do banco de dados MySQL */
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	protected Connection getConnection() throws SQLException {
    	return DriverManager.getConnection("jdbc:mysql://localhost:3306/CompraVendaVeiculo", "root", "root");
    }
}