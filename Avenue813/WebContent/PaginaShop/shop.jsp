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
							<input type="button" value="Maglie"><br>
							<input type="button" value="Pantaloni"><br>
							<input type="button" value="Sneakers"><br>
							<input type="button" value="Accessori"><br>
							<input type="button" value="Saldi"><br>
						</div>
						
					</div>
					<div class="products">
				
					<div class="products_title">
						<span></span>
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
								<div class="image_product">
									<img src="<%=bean.getPath()%>" width=150px height="150px">
								</div>
								<div class="buy_price">
									<div class="product_name">
										<span><%= bean.getName() %></span>
									
									</div>
									<div class="buy_button">
										<input type="button" value="Compra">
									</div>
									<div class="price">
										<span><%= bean.getPrice() %> &euro;</span>
									</div>
										
								</div>
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
			
				<div id="footer">
					<%@ include file="../PaginaUtili/footer.jsp"%>
				</div>
		</div>
	</body>
</html>