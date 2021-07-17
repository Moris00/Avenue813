package it.avenue813.control;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	
		
		
		
		String nome = request.getParameter("nome_prodotto");
		double prezzo = Double.parseDouble(request.getParameter("prezzo"));
		int quantita = Integer.parseInt(request.getParameter("quantita"));
		String categoria = request.getParameter("categoria");
		String sesso = request.getParameter("sesso");
		String descrizione = request.getParameter("descrizione");
		ArrayList<String> files = null;
		String savePath = "C:\\Users\\Utente\\git\\gitTutorial14\\Avenue813\\WebContent\\immagini_prodotti";
		Utility.print(savePath);
		
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
							String[] temp1 = temp.split(".");
							temp1[0] = nome+"_"+categoria;
							filename = temp1[0]+"."+temp1[1];
						}
					}
				 
				if(filename != null && !filename.equals("")) {
					part.write(savePath +File.separator +filename);
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
		
		try {
			modelProduct.doSave(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
