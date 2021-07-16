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


@WebServlet("/ProductControl1")
public class ProductControl1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProductControl1() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		ProductModelDS model = new ProductModelDS(ds);
		
		String sesso = request.getParameter("Sesso");
		Utility.print(request.getQueryString());
		String category = request.getParameter("Category");
		Utility.print(category);
		
		request.setAttribute("produtcs", null);
		response.sendRedirect("/Avenue813/PaginaShop/shop.jsp?Sesso="+sesso+"&Category="+category);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
