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
			<div class="product_div">
				<div class="product_image">
					<img src="<%= bean.getPath()%>">
				
				</div>
				<div class="product_description">
					<div class="title">
						<p><%=bean.getName()%></p>
					
					</div>
					<div class="description">
						<p><%=bean.getDesc()%></p>
					</div>
					<div class="prezzo">
						<p><%=bean.getPrice()%> &euro;</p>
					
					</div>
					<div class="taglie_acquisto">
						<select>
							<option>S</option>
							<option>M</option>
							<option>L</option>
							<option>XL</option>
						</select>
						<input type="button" value="Acquista">
					</div>
				</div>
			
			
			</div>
		</div>
	</body>
</html>