package it.avenue813.control;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.DataSource;

import it.avenue813.model.ProductBean;
import it.avenue813.model.ProductModelDS;
import it.avenue813.utils.Utility;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 3,
				maxFileSize = 1024 * 1024 * 10,
				maxRequestSize = 1024 * 1024 * 50)

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
	
		HttpSession session = request.getSession();
		
		
		String nome = request.getParameter("nome_prodotto");
		int quantita = Integer.parseInt(request.getParameter("quantita"));
		double prezzo = Double.parseDouble(request.getParameter("prezzo"));
		
		
		
		try {
			ProductBean product = modelProduct.doRetrieveByKey(nome);
			if(product != null && product.getPrice() == prezzo) {
				product.setStocks(product.getStocks() + quantita);
				modelProduct.doUpdate(product);
				modelProduct.doUpdateDisp(product, true);
				session.setAttribute("error", null);
				response.sendRedirect("/Avenue813/PaginaShop/shop.jsp");
				return;
			}else if(product != null) {
				Utility.print("nome gia usato");
				session.setAttribute("error", "Nome già esistente");
				response.sendRedirect("/Avenue813/PaginaShop/admin/aggiungi_prodotti.jsp");
				return;
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		

		String categoria = request.getParameter("categoria");
		String sesso = request.getParameter("sesso");
		String descrizione = request.getParameter("descrizione");
		ArrayList<String> files = null;
		String savePath = "C:\\Users\\Utente\\git\\gitTutorial14\\Avenue813\\WebContent\\immagini_prodotti";
		String savePath2 = "/Avenue813/immagini_prodotti/";
		Utility.print(savePath);
		String stringa = "";
		int flag = 1;
		if(request.getParts() != null && request.getParts().size() > 0) {
			for(Part part: request.getParts()) {
				String filename = extractFileName(part);
				Utility.print(filename);
				Utility.print("Eccomi qua!");
					try {
						files = modelProduct.getFileNameProducts();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					for(String e: files) {
						if(filename.equals(e)) {
							String temp = filename;
							String[] temp1 = temp.split(Pattern.quote("."));
							
							temp1[0] = nome+"_"+categoria;
							filename = temp1[0]+"."+temp1[1];
							if(filename != null && !filename.equals("")) {
								part.write(savePath +File.separator +filename);
								stringa = savePath2+filename;
								flag = 0;
							}
						}
					}
				 
				if(filename != null && !filename.equals("") && flag == 1) {
					part.write(savePath +File.separator +filename);
					stringa = savePath2+filename;
				}
			}
		}
		
		ProductBean bean = new ProductBean();
		
		bean.setName(nome);
		bean.setPrice(prezzo);
		bean.setStocks(quantita);
		bean.setCategory(categoria);
		bean.setSesso(sesso);
		bean.setDesc(descrizione);
		bean.setPath(stringa);
		
		try {
			modelProduct.doSave(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.setAttribute("error", null);
		response.sendRedirect("/Avenue813/PaginaShop/shop.jsp?Sesso=uomo");
	}
	
	private String extractFileName(Part part) {
		//content-disposition: form-data; name="foto"; filename="file.txt";
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for(String s: items) {
			if(s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=")+2, s.length() - 1);
			}
		}
		return "";
	}

}
