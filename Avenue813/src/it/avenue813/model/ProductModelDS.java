package it.avenue813.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import javax.sql.DataSource;

import it.avenue813.utils.Utility;


public class ProductModelDS implements ProductModel<ProductBean> {

	 DataSource ds = null;
	
	public ProductModelDS(DataSource ds) {
		this.ds = ds;
	}
	
	public ArrayList<ProductBean> doRetrieveByLetter(String letter) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		ArrayList<ProductBean> products = new ArrayList<ProductBean>();
		
		String selectSQL = "SELECT * FROM Products WHERE Products.nome LIKE '"+letter+"%'";
		
	
		
		connection = ds.getConnection();
		preparedStatement = connection.prepareStatement(selectSQL);
		
		rs = preparedStatement.executeQuery();
		
		while(rs.next()) {
			ProductBean product = new ProductBean();
			product.setId(rs.getInt("id"));
			product.setName(rs.getString("nome"));
			product.setPrice(rs.getDouble("price"));
			product.setCategory(rs.getString("category"));
			product.setPath(rs.getString("pathImage"));
			product.setDesc(rs.getString("descrizione"));
			product.setSesso(rs.getString("sesso"));
			product.setStocks(rs.getInt("stock"));
			product.setDisp(rs.getBoolean("disp"));
			if(product.getStocks() > 0 && product.isDisp()) {
				products.add(product);
			}
		}
		
		rs.close();
		preparedStatement.close();
		connection.close();
		
		
		return products;
		
	}
	
	
	
	@Override
	public ProductBean doRetrieveByKey(String code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		
		String selectSQL ="SELECT * FROM Products WHERE Products.nome LIKE'"+code+"';";
		
		ProductBean product = new ProductBean();
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("nome"));
				product.setPrice(rs.getDouble("price"));
				product.setCategory(rs.getString("category"));
				product.setPath(rs.getString("pathImage"));
				product.setDesc(rs.getString("descrizione"));
				product.setStocks(rs.getInt("stock"));
				product.setSesso(rs.getString("sesso"));
				product.setStocks(rs.getInt("stock"));
				product.setDisp(rs.getBoolean("disp"));
				return product;
			}
			return null;
		}finally {
			if(rs != null) rs.close();
			if(preparedStatement != null) preparedStatement.close();
			if(connection != null) connection.close();
		}
	}
	
	public ProductBean doRetrieveById(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		
		String selectSQL ="SELECT * FROM Products WHERE Products.id LIKE "+id+";";
		
		ProductBean product = new ProductBean();
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("nome"));
				product.setPrice(rs.getDouble("price"));
				product.setCategory(rs.getString("category"));
				product.setPath(rs.getString("pathImage"));
				product.setDesc(rs.getString("descrizione"));
				product.setSesso(rs.getString("sesso"));
				product.setStocks(rs.getInt("stock"));
				product.setDisp(rs.getBoolean("disp"));
				
				
			}
			return product;
		}finally {
			if(rs != null) rs.close();
			if(preparedStatement != null) preparedStatement.close();
			if(connection != null) connection.close();
		}
	}
	
	public Collection<ProductBean> doRetrieveAllByCategory(String sesso, String category) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		Collection<ProductBean> products = new LinkedList<ProductBean>();
		
		String selectSQL ="SELECT * FROM Products WHERE Products.sesso LIKE '"+sesso+"' AND Products.category LIKE '"+category+"';";
		
		
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				ProductBean product = new ProductBean();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("nome"));
				product.setPrice(rs.getDouble("price"));
				product.setCategory(rs.getString("category"));
				product.setPath(rs.getString("pathImage"));
				product.setDesc(rs.getString("descrizione"));
				product.setSesso(rs.getString("sesso"));
				product.setStocks(rs.getInt("stock"));
				product.setDisp(rs.getBoolean("disp"));
				if(product.getStocks() > 0 && product.isDisp()) {
					products.add(product);
				}
			}
			
		}finally {
			if(rs != null) rs.close();
			if(preparedStatement != null) preparedStatement.close();
			if(connection != null) connection.close();
		}
		return products;
	}

	@Override
	public void doSave(ProductBean item) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String sql = "INSERT INTO Products(nome, price, category, stock, sesso, pathImage, descrizione) VALUES (?,?,?,?,?,?,?);";
		
		connection = ds.getConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, item.getName());
		preparedStatement.setDouble(2, item.getPrice());
		preparedStatement.setString(3, item.getCategory());
		preparedStatement.setInt(4, item.getStocks());
		preparedStatement.setString(5, item.getSesso());
		preparedStatement.setString(6, item.getPath());
		preparedStatement.setString(7, item.getDesc());
		
		
		
		preparedStatement.executeUpdate();
			Utility.print("Aggiunto Prodotto!");

			
		preparedStatement.close();
		connection.close();
		
	}

	@Override
	public void doUpdate(ProductBean item) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rs = 0;
		
		String selectSQL ="UPDATE Products SET Products.stock = ? WHERE Products.id LIKE ?";
		connection = ds.getConnection();
		preparedStatement = connection.prepareStatement(selectSQL);
		preparedStatement.setInt(1, item.getStocks());
		preparedStatement.setInt(2, item.getId());
		
		rs = preparedStatement.executeUpdate();
		
		preparedStatement.close();
		connection.close();
		
	}

	@Override
	public void doDelete(ProductBean item) throws SQLException {
		
		
	}
	
	public void doUpdateDisp(ProductBean item, boolean risp) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rs = 0;
		
		String selectSQL ="UPDATE Products SET Products.disp = ? WHERE id LIKE ?";
		connection = ds.getConnection();
		preparedStatement = connection.prepareStatement(selectSQL);
		preparedStatement.setBoolean(1, risp);
		preparedStatement.setInt(2, item.getId());
		
		rs = preparedStatement.executeUpdate();
		
		preparedStatement.close();
		connection.close();
	}

	@Override
	public Collection<ProductBean> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		String selectSQL ="SELECT * FROM Products";
		
		Collection<ProductBean> products = new LinkedList<ProductBean>();
		
		try {
			connection = ds.getConnection();
			
			
			
			if(order.equals("")) {
				preparedStatement = connection.prepareStatement(selectSQL);
				rs = preparedStatement.executeQuery();
			while(rs.next()) {
				ProductBean product = new ProductBean();
				
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("nome"));
				product.setPrice(rs.getDouble("price"));
				product.setCategory(rs.getString("category"));
				product.setPath(rs.getString("pathImage"));
				product.setSesso(rs.getString("sesso"));
				product.setStocks(rs.getInt("stock"));
				product.setDisp(rs.getBoolean("disp"));
				
				if(product.getStocks() > 0 && product.isDisp()) {
					products.add(product);
				}
			}
		}else {
			selectSQL = "SELECT * FROM Products WHERE Products.sesso LIKE '"+order+"';";
			preparedStatement = connection.prepareStatement(selectSQL);
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				ProductBean product = new ProductBean();
				
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("nome"));
				product.setPrice(rs.getDouble("price"));
				product.setCategory(rs.getString("category"));
				product.setPath(rs.getString("pathImage"));
				product.setSesso(rs.getString("sesso"));
				product.setStocks(rs.getInt("stock"));
				product.setDisp(rs.getBoolean("disp"));
				
				if(product.getStocks() > 0 && product.isDisp()) {
					products.add(product);
				}
			}
			Utility.print("sono qua");
		}
			return products;
		}finally {
			if(rs != null) rs.close();
			if(preparedStatement != null) preparedStatement.close();
			if(connection != null) connection.close();
		}
		
	
	}
	
	public ArrayList<String> getFileNameProducts() throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String path;
		
		ArrayList<String> files = new ArrayList<String>();
		String sql = "Select Products.pathImage FROM Products;";
		
		connection = ds.getConnection();
		preparedStatement = connection.prepareStatement(sql);
		rs = preparedStatement.executeQuery();
		
		while(rs.next()) {
			path = rs.getString("pathImage");
			Utility.print(path);
			String[] parts = path.split("/");
			path = parts[3];
			Utility.print(path);
			files.add(path);
		}
		
		rs.close();
		preparedStatement.close();
		connection.close();
		
		return files;
	}
	
}
