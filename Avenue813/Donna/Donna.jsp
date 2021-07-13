<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.* , it.avenue813.model.*"%>
    
<%
	Collection <?> products = (Collection<?>) request.getAttribute("products");

	String error = (String) request.getAttribute("error");
	
	if(products == null && error == null){
		response.sendRedirect(response.encodeRedirectURL("../ProductControl"));
		return;
	}
	
	HttpSession sessionUser = request.getSession();
%>    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Benvenuti nello Shop Avenue813</title>
		 <style><%@include file="/Avenue813/PaginaShop/shopstyle.css" %></style>
	</head>
	
	<body>
		
		<div class="main">
			<div class="head">
			<%@ include file="../PaginaUtili/header.jsp"%>
			</div>
			<div class="shopmain">	
					<div class="category">
					
						<div class="content_category">
							<form action="ProductControl1" method="GET">
							<input type="text"> <%if(session.getAttribute("role") == "Admin"){ %>
								<button>Aggiungi prodotto</button>
							<% } %><br>
							<input type="button"  class="btn" name="btn" value="Maglie" onclick=" clickButton()"><br>
							<div class="subMaglie">
								<input type="button" value="T-shirt"><br>
								<input type="button" value="Felpe"><br>
							</div>
							<input type="button" value="Pantaloni"><br>
							<input type="button" value="Sneakers"><br>
							<input type="button" value="Accessori"><br>
							<input type="button" value="Saldi"><br>
							</form>
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
										<span class="nome_prodotto"><%= bean.getName() %></span>
									
									</div>
									<div class="buy_button">
									<form action="/Avenue813/ViewProductServlet" method="GET">
										<input type="submit" value="Dettagli" name=<%=bean.getId()%>>
									</form>
									</div>
									<div class="price">
										<% if(sessionUser.getAttribute("username") == null && sessionUser.getAttribute("passw") == null) { %>
											<span> <a href="/Avenue813/PaginaAutenticazione/login.jsp">Accedi!!</a></span>
										<%	}else{ %>
											<span class="prezzo_prodotto"><%= bean.getPrice() %> &euro;</span>
										<%} %>
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
	<script type="text/javascript">
		function clickButton(){
			var xhr = new XMLHttpRequest();
			
			xhr.open('GET', 'ProductControl1', true);
			xhr.send(null);
			
		}
	</script>
</html>