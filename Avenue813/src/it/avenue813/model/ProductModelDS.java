package it.avenue813.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

import javax.sql.DataSource;

public class ProductModelDS implements ProductModel {

	private DataSource ds = null;
	
	public ProductModelDS(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public Object doRetrieveByKey(String code) throws SQLException {
		return null;
	}

	@Override
	public Collection doRetrieveAll() throws SQLException {
		
		
		
		return null;
	}

	@Override
	public void doSave(Object item) throws SQLException {

	}

	@Override
	public void doUpdate(Object item) throws SQLException {

	}

	@Override
	public void doDelete(Object item) throws SQLException {

	}
}
