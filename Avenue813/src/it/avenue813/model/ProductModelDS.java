package it.avenue813.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
				//product.setStocks(rs.getInt("stocks"));
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
				//product.setStocks(rs.getInt("stocks"));
			}
			return product;
		}finally {
			if(rs != null) rs.close();
			if(preparedStatement != null) preparedStatement.close();
			if(connection != null) connection.close();
		}
	}
	
	public ProductBean doRetrieveAllByCategory(String sesso, String category) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		
		String selectSQL ="SELECT * FROM Products WHERE Products.sesso LIKE '"+sesso+"' AND Products.category LIKE '"+category+"';";
		
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
				//product.setStocks(rs.getInt("stocks"));
			}
			return product;
		}finally {
			if(rs != null) rs.close();
			if(preparedStatement != null) preparedStatement.close();
			if(connection != null) connection.close();
		}
	}

	@Override
	public void doSave(ProductBean item) throws SQLException {
		// TODO Auto-generated method stub
		
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
	
}
