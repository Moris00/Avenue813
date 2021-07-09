package it.avenue813.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import it.avenue813.utils.Utility;

public class UserModelDS {

	DataSource ds = null;
	
	public UserModelDS(DataSource ds) {
		this.ds = ds;
	}
	
	public boolean isNew(UserBean user) throws SQLException {
		
		String email = user.getUsername();

		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM Customers WHERE Customers.email LIKE '"+email+"';");
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				return false;
			}
			
			return true;
			
		}catch(SQLException e) {
			Utility.print(e);
		}finally {
			rs.close();
			preparedStatement.close();
			connection.close();
		}
		
		return false;
	}
	
	public void toSave(UserBean user) throws SQLException{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO Customers (email, passw, pname, secondname, username) VALUES (?,?,?,?,?);");
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getName());
			preparedStatement.setString(4, user.getSecond_name());
			preparedStatement.setString(5, user.getUsername());
			
			int i = preparedStatement.executeUpdate();
			
			if(i>0) Utility.print("Utente Registrato");
		}catch(SQLException e) {
			Utility.print(e);
		}finally {
			preparedStatement.close();
			connection.close();	
		}
		
	}
	
	public UserBean canLogin(String username, String password) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM Customers WHERE Customers.username LIKE '"+username+"' AND Customers.passw LIKE '"+password+"';");
			
			UserBean user = new UserBean();
			rs = preparedStatement.executeQuery();
			Utility.print("Sono qua");
			while(rs.next()) {
				user.setUsername(username);
				user.setPassword(password);
				user.setCarrello(null);
			}
			
			return user;
		}finally {
			rs.close();
			preparedStatement.close();
			connection.close();	
		}
	}
	
}
