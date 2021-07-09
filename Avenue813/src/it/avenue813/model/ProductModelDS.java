package it.avenue813.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.sql.DataSource;


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

		
		String selectSQL ="SELECT * FROM Products WHERE Products.name LIKE'"+code+"';";
		
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
			preparedStatement = connection.prepareStatement(selectSQL);
			
			
			if(order.equals("")) {
				rs = preparedStatement.executeQuery();
			while(rs.next()) {
				ProductBean product = new ProductBean();
				
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("nome"));
				product.setPrice(rs.getDouble("price"));
				product.setCategory(rs.getString("category"));
				product.setPath(rs.getString("pathImage"));
				
				products.add(product);
				
			}
		}else {
			selectSQL = "SELECT * FROM Products WHERE Products.category LIKE '"+order+"'";
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				ProductBean product = new ProductBean();
				
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("nome"));
				product.setPrice(rs.getDouble("price"));
				product.setCategory(rs.getString("category"));
				product.setPath(rs.getString("pathImage"));
				
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
}
