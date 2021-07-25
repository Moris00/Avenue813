package it.avenue813.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import it.avenue813.model.*;
import it.avenue813.utils.Utility;

/**
 * Servlet implementation class SearchProductServlet
 */
@WebServlet("/SearchProductServlet")
public class SearchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/xml");
		
		ProductModelDS productModel = new ProductModelDS((DataSource) getServletContext().getAttribute("DataSource"));
		
		
		StringBuffer packed = new StringBuffer();
		
		String search = request.getParameter("param");
		if(search.equals("")) {
			response.getWriter().write(packed.toString());
			return;
		}
		
		packed.append("<info>");
		Utility.print(search);
		try {
			ArrayList<ProductBean> products = productModel.doRetrieveByLetter(search);
			System.out.println(products.get(0).getName());
			for(int i = 0; i < products.size(); i++) {
				packed.append("<prodotto>");
				packed.append("<product_name>");
				packed.append(products.get(i).getName());
				packed.append("</product_name>");
				packed.append("<product_id>");
				packed.append(products.get(i).getId());
				packed.append("</product_id>");
				packed.append("<product_sesso>");
				packed.append(products.get(i).getSesso());
				packed.append("</product_sesso>");
				packed.append("</prodotto>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		packed.append("</info>");
		Utility.print(packed.toString());

		
		response.getWriter().write(packed.toString());
		
		
	}

}
