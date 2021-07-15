package it.avenue813.utils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

@WebListener
public class MainContext implements ServletContextListener {	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		Utility.print("Startup web application");
		
		ServletContext context = sce.getServletContext(); //Serve per salvare il nostro database
		
		DataSource ds = null;
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			
			ds = (DataSource) envCtx.lookup("jdbc/database");
				try {
					Connection con = null;
					try {
						con = ds.getConnection();
				
						DatabaseMetaData metaData = con.getMetaData();
						Utility.print("DBMS name: "+ metaData.getDatabaseProductName());
						Utility.print("DBMS name: "+ metaData.getDatabaseProductVersion());
				
					}finally {
						if(con != null) con.close();
					}
			
				}catch(SQLException e) {
					Utility.print(e);
				}
			}catch(NamingException e) {
				Utility.print(e);
			}
		
		context.setAttribute("DataSource", ds); //Database visto da tutte le servlet
		Utility.print("DataSource creation: "+ds.toString());
	}
	
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		context.removeAttribute("DataSource");
		Utility.print("Shutdown web application");
	}
}
