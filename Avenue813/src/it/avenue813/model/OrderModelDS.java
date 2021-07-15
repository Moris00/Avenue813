package it.avenue813.model;

import java.sql.SQLException;

import javax.sql.DataSource;

public class OrderModelDS {
	DataSource ds = null;
	
	public OrderModelDS(DataSource ds) {
		this.ds = ds;
	}
	
	public void doSave(OrderBean item) throws SQLException {
		
		
	}
}
