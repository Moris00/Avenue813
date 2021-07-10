<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.avenue813.model.* , javax.sql.DataSource"%>
<!DOCTYPE html>
<html>
	<%
		String id = request.getParameter("id");
		ProductModelDS model = new ProductModelDS( (DataSource) getServletContext().getAttribute("DataSource"));
		ProductBean bean = model.doRetrieveById(Integer.parseInt(id));
	%>

	<head>
		<meta charset="ISO-8859-1">
		<title><%= bean.getName()%></title>
		<style><%@include file="product.css"%></style>
	</head>
	<body>
		<div class="main">
			<div class="head">
				<%@include file="../../PaginaUtili/header.jsp"%>
			</div>
			<form action="../../CarrelloServlet" method="POST">
				<div class="product_div">
				
					<div class="product_image">
						<img src="<%= bean.getPath()%>">
				
					</div>
					<div class="product_description">
						<div class="title">
							<input type="text" value="<%=bean.getName()%>" name="product_name">
					
						</div>
						<div class="description">
							<p><%=bean.getDesc()%></p>
						</div>
						<div class="prezzo">
							<p><%=bean.getPrice()%> &euro;</p>
						
						</div>
						<div class="taglie_acquisto">
				
							<select name="size">
								<option value="S">S</option>
								<option value="M">M</option>
								<option value="L">L</option>
								<option value="XL">XL</option>
							</select>
							<input type="submit" value="Acquista">
					
						</div>
					</div>
				</div>
			</form>
		</div>
	</body>
</html>