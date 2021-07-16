package it.avenue813.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import it.avenue813.model.ProductBean;
import it.avenue813.model.ProductModelDS;
import it.avenue813.utils.Utility;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddProductServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		ProductModelDS modelProduct = new ProductModelDS(ds);
		
		String nome = request.getParameter("nome_prodotto");
		double prezzo = Double.parseDouble(request.getParameter("prezzo"));
		int quantita = Integer.parseInt(request.getParameter("quantita"));
		String categoria = request.getParameter("categoria");
		String sesso = request.getParameter("sesso");
		String descrizione = request.getParameter("descrizione");
		
		ProductBean bean = new ProductBean();
		
		bean.setName(nome);
		bean.setPrice(prezzo);
		bean.setStocks(quantita);
		bean.setCategory(categoria);
		bean.setSesso(sesso);
		bean.setDesc(descrizione);
		
		try {
			modelProduct.doSave(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
