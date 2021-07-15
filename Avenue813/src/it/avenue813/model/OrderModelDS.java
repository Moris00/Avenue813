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
		preparedStatement.setInt(0, item.getId_customer());
		preparedStatement.setDouble(1, item.getAmount());
		preparedStatement.setString(2, item.getIndirizzo());
		preparedStatement.setString(3, item.getData());
		preparedStatement.setString(4, item.getNome());
		preparedStatement.setString(5, item.getCognome());
		preparedStatement.setString(6, item.getTelefono());
		preparedStatement.setInt(7, item.getIdProduct());
		int rs = preparedStatement.executeUpdate();
		
		if(rs == 1) {
			Utility.print("riga inserita");
		}
		
		preparedStatement.close();
		connection.close();
		
	}
}
