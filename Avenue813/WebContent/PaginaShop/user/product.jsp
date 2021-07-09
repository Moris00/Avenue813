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
	</head>
	<body>
		<div class="main">
			<div class="head">
				<%@include file="../../PaginaUtili/header.jsp"%>
			</div>
			<div class="product_div">
				<div class="product_image">
				
				
				</div>
			
			
			</div>
		</div>
	</body>
</html>