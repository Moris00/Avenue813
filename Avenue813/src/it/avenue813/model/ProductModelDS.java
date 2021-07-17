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
			}
			return product;
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
				products.add(product);
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
		
		String sql = "INSERT INTO Products(nome, price, category, stock, sesso, descrizione, pathImage) VALUES('"+item.getName()+"', "+item.getPrice()+", '"+item.getCategory()+"', "+item.getStocks()+", '"+item.getSesso()+"', '"+item.getDesc()+"', '"+item.getPath()+"');";
		
		connection = ds.getConnection();
		preparedStatement = connection.prepareStatement(sql);
		
		
		
		preparedStatement.executeUpdate(sql);
			Utility.print("Aggiunto Prodotto!");

		
		
	}

	@Override
	public void doUpdate(ProductBean item) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doDelete(ProductBean item) throws SQLException {
		// TODO Auto-generated method stub
		
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
				
				products.add(product);
				Utility.print("sono qua");
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
				
				products.add(product);	
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
		
		
		
		return files;
	}
	
}
