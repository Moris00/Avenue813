package it.avenue813.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import it.avenue813.utils.Utility;

public class OrderModelDS {
	DataSource ds = null;
	
	public OrderModelDS(DataSource ds) {
		this.ds = ds;
	}
	
	public String doRetrieveMethodPagament(int index) throws SQLException {
		String sql = "SELECT Orders.method_pagament FROM Orders WHERE Orders.numero_ordini ="+index+";";
		
		Connection connection = ds.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery();
		String pagamento = "";
		while(rs.next()) {
			pagamento = rs.getString("method_pagament");
		}
		rs.close();
		preparedStatement.close();
		connection.close();
		return  pagamento;
		
	}
	
	public ArrayList<ProductBean> giveProducts(int index) throws SQLException {
		
		String sql = "SELECT Orders.product_id FROM Orders WHERE Orders.numero_ordini ="+index+";";
		
		ArrayList<ProductBean> products = new ArrayList<ProductBean>();
		
		Connection connection = ds.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery();
		
		ArrayList<Integer> idProducts = new ArrayList<Integer>();
		int i = 0;
		
		while(rs.next()) {
			idProducts.add(rs.getInt("product_id"));
			i++;
		}
		
		preparedStatement.close();
		rs.close();
		
		int n = idProducts.size();
		i = 0;
		while(i < n) {
			sql = "SELECT * FROM Products WHERE Products.id = "+idProducts.get(i)+";";
			preparedStatement = connection.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				ProductBean bean = new ProductBean();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("nome"));
				bean.setPrice(rs.getDouble("price"));
				bean.setCategory(rs.getString("category"));
				bean.setPath(rs.getString("pathImage"));
				bean.setDesc(rs.getString("descrizione"));
				bean.setSesso(rs.getString("sesso"));
				bean.setStocks(rs.getInt("stock"));
				
				products.add(bean);
			}
			
			
			preparedStatement.close();
			rs.close();
			i++;
		}

		preparedStatement.close();
		rs.close();
		connection.close();
		return products;
		
	}
	
	public void doSave(OrderBean item) throws SQLException {
		
		String sql = "INSERT INTO Orders(customer_id, amount, order_address, order_date, nome, cognome, telefono, product_id, method_pagament, numero_ordini) VALUES(?,?,?,?,?,?,?,?,?, ?);";
		
		
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
		preparedStatement.setString(9, item.getMethod());
		preparedStatement.setInt(10, item.getNumOrder());
		int rs = preparedStatement.executeUpdate();
		
		if(rs == 1) {
			Utility.print("riga inserita");
		}
		
		preparedStatement.close();
		connection.close();
		
	}
}
