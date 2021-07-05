package it.avenue813.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import it.avenue813.model.ProductModelDS;
import it.avenue813.utils.Utility;


@WebServlet("/ProductControl")
public class ProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		ProductModelDS model = new ProductModelDS(ds);
		
		try {
			request.setAttribute("products", model.doRetrieveAll(""));
		}catch(SQLException e) {
			Utility.print(e);
			request.setAttribute("error", e.getMessage());
		}
		
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/PaginaShop/shop.jsp");
		dispatcher.include(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
