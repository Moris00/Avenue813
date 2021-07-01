<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.* , it.avenue813.model.*"%>
    
<%
	Collection <?> products = (Collection<?>)request.getAttribute("products");

	String error = (String) request.getAttribute("error");
	
	if(products == null && error == null){
		response.sendRedirect(response.encodeRedirectURL("../ProductControl"));
		return;
	}
%>    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Benvenuti nello Shop Avenue813</title>
		<style><%@include file="shopstyle.css" %></style>
	</head>
	
	<body>
		
		<div class="main">
			<div class="head">
			<%@ include file="../PaginaUtili/header.jsp"%>
			</div>
			<div class="shopmain">	
					<div class="category">
					
						<div class="content_category">
							<input type="text"><br>
							<input type="button"><br>
							<input type="button"><br>
							<input type="button"><br>
							<input type="button"><br>
							<input type="button"><br>
							<input type="button"><br>
							<input type="button"><br>
							<input type="button"><br>
							<input type="button"><br>
							<input type="button"><br>
							<input type="button"><br>
							<input type="button"><br>
							<input type="button"><br>
						</div>
						
					</div>
					<div class="products">
				
					<div class="products_title">
						<span>Category</span>
					</div>
					
					<div class="products_content">
					
						<div class="list">
						<%
							if(products != null && products.size() > 0 ){
								Iterator<?> it = products.iterator();
								while(it.hasNext()){
									ProductBean bean = (ProductBean)it.next();
						%>
						
						
							<div class="product">
								
							</div>
						
						<%
								}
							} 
						%>
						
						</div>
					
					</div>
				</div>
				<div class="carrello">
						<div class="content_carrello">
							<div class="item">
								
							</div>
							<div class="item">
								
							</div>
							<div class="item">
								
							</div>
							<div class="item">
								
							</div>
							<div class="item">
								
							</div>
							<div class="item">
								
							</div>
						</div>
					
				</div>
					
				</div>
			
				
		</div>
	</body>
</html>