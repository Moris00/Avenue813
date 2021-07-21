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
	
	public boolean isFreeUsername(String username) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		String sql = "Select * FROM Customers WHERE Customers.username LIKE '"+username+"'";
		
		connection = ds.getConnection();
		preparedStatement = connection.prepareStatement(sql);
		rs = preparedStatement.executeQuery();
		
		while(rs.next()) {
			rs.close();
			preparedStatement.close();
			connection.close();
			
			return false;
		}
		rs.close();
		preparedStatement.close();
		connection.close();
		
		return true;
	}
	
	public boolean isFreeEmail(String email) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		String sql = "Select * FROM Customers WHERE Customers.email LIKE '"+email+"'";
		
		connection = ds.getConnection();
		preparedStatement = connection.prepareStatement(sql);
		rs = preparedStatement.executeQuery();
		
		while(rs.next()) {
			rs.close();
			preparedStatement.close();
			connection.close();
			
			return false;
		}
		rs.close();
		preparedStatement.close();
		connection.close();
		
		return true;
	}
	
	public String isNew(UserBean user) throws SQLException {
		
		String email = user.getEmail();

		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM Customers WHERE Customers.email LIKE '"+email+"';");
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				return "Email già usata!";
			}
			
			String username = user.getUsername();
			
			rs.close();
			preparedStatement.close();
			
			preparedStatement = connection.prepareStatement("SELECT * FROM Customers WHERE Customers.username LIKE '"+username+"';");
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				return "Username già usata";
			}
			
			return "";
			
		}catch(SQLException e) {
			Utility.print(e);
		}finally {
			rs.close();
			preparedStatement.close();
			connection.close();
		}
		
		return "";
	}
	
	public void toSave(UserBean user) throws SQLException{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String pass_cod = Utility.encode(user.getPassword());
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO Customers (email, passw, pname, secondname, username) VALUES (?,?,?,?,?);");
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, pass_cod);
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
		
		String pass_cod = Utility.encode(password);
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM Customers WHERE Customers.username LIKE ? AND Customers.passw LIKE ?;");
			
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, pass_cod);
			
			
			UserBean user = new UserBean();
			rs = preparedStatement.executeQuery();
			Utility.print("Sono qua");
			while(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(Utility.decode(rs.getString("passw")));
				user.setNumero_ordini(rs.getInt("numero_ordini"));
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("pname"));
				user.setSecond_name(rs.getString("secondname"));
				if(rs.getBoolean("amministrator")) {
					user.setRole("Admin");
				}else {
					user.setRole("User");
				}
				return user;
			}
			Utility.print(user.getRole());
			return null;
		}finally {
			rs.close();
			preparedStatement.close();
			connection.close();	
		}
	}
	
	public void toUpdateOrdini(UserBean user) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rs = 0;
		
		connection = ds.getConnection();
		String sql ="UPDATE Customers SET numero_ordini = "+user.getNumero_ordini()+" WHERE Customers.username LIKE ? AND Customers.passw LIKE ?;";

		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, user.getUsername());
		preparedStatement.setString(2, Utility.encode(user.getPassword()));
		
		rs = preparedStatement.executeUpdate();

		preparedStatement.close();
		connection.close();	
	}
	
	public void toUpdate(UserBean user, String username, String passw) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rs = 0;
		
		String sql ="SELECT Customers.email FROM Customers";
		String passw_code = Utility.encode(passw);
		
		connection = ds.getConnection();
		Utility.print(user.getEmail());
		Utility.print(user.getPassword()+"qua qua");
		sql ="UPDATE Customers SET Customers.email = ? , Customers.pname = ? , Customers.secondname = ?, Customers.username = ?, Customers.passw = ? WHERE Customers.username LIKE ? AND Customers.passw LIKE ?";
		preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, user.getEmail());
		preparedStatement.setString(2, user.getName());
		preparedStatement.setString(3, user.getSecond_name());
		preparedStatement.setString(4, user.getUsername());
		preparedStatement.setString(5, Utility.encode(user.getPassword()));
		preparedStatement.setString(6, username);
		preparedStatement.setString(7, passw_code);
		
		rs = preparedStatement.executeUpdate();
		
		preparedStatement.close();
		connection.close();
	}
	
}
