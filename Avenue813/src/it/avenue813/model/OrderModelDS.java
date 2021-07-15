package it.avenue813.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import it.avenue813.utils.Utility;

public class OrderModelDS {
	DataSource ds = null;
	
	public OrderModelDS(DataSource ds) {
		this.ds = ds;
	}
	
	public void doSave(OrderBean item) throws SQLException {
		
		String sql = "INSERT INTO Orders(customer_id, amount, order_address, order_date, nome, cognome, telefono, product_id) VALUES(?,?,?,?,?,?,?,?);";
		
		
		Connection connection = ds.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, item.getId_customer());
		preparedStatement.setDouble(2, item.getAmount());
		preparedStatement.setString(3, item.getIndirizzo());
		preparedStatement.setString(4, item.getData());
		preparedStatement.setString(5, item.getNome());
		preparedStatement.setString(6, item.getCognome());
		preparedStatement.setString(7, item.getTelefono());
		preparedStatement.setInt(8, item.getIdProduct());
		int rs = preparedStatement.executeUpdate();
		
		if(rs == 1) {
			Utility.print("riga inserita");
		}
		
		preparedStatement.close();
		connection.close();
		
	}
}
