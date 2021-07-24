<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.avenue813.model.* , javax.sql.DataSource"%>
<!DOCTYPE html>
<html>
	<%
	if(request.getSession() == null || request.getSession().getAttribute("username") == "" || request.getSession().getAttribute("username") == null){
		response.sendRedirect("/Avenue813/PaginaUtili/errorpage.jsp");
		return;
	}
		
		String id = request.getParameter("id");
		ProductModelDS model = new ProductModelDS( (DataSource) getServletContext().getAttribute("DataSource"));
		ProductBean bean = model.doRetrieveById(Integer.parseInt(id));
		
		
	%>

	<head>
		<meta charset="ISO-8859-1">
		<title><%= bean.getName()%></title>
		<style><%@include file="product.css"%></style>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
	</head>
	<body>
		<div class="main">
			<div class="head">
				<%@include file="../../PaginaUtili/header.jsp"%>
			</div>
			<form action="../../CarrelloServlet" method="POST">
				<div class="product_div">
				
					<div class="product_image">
						<img src="<%= bean.getPath()%>" alt="/Avenue813/immagini_prodotti/error.png">
				
					</div>
					<div class="product_description">
						<div class="title">
							<input type="text" value="<%=bean.getName()%>" name="product_name" readonly>
					
						</div>
						<div class="description">
							<p><%=bean.getDesc()%></p>
						</div>
						<div class="prezzo">
							<p><%=bean.getPrice()%> &euro;</p>
						
						</div>
						<div class="taglie_acquisto">
				
							<input type="submit" value="Aggiungi al carrello">
					
						</div>
					</div>
				</div>
			</form>
		</div>
	</body>
</html>