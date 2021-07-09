<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<style><%@include file="../styles/header.css" %></style>
</head>
<body>
	<%
		HttpSession userSession = request.getSession();
	
	%>

<div class="header">
				<div class="content">
							<div class="colonna1">
								<div class="logoimg">

									<a href="PaginaHome/home.jsp"><img  class="logo" src="/Avenue813/immagini/logoavenue.png" width=80px; height=40px;></a>

								</div>
							</div>
							<div class="colonna2">
								<div class="menu">
									<div class="content-menu">
										<ul id="lista">
											<li><a href="/Avenue813/PaginaShop/shop.jsp" class="cool-link">Shop</a></li>
											<li><a href="/Avenue813/News/News.html" class="cool-link">News</a></li>
											<li><a href="/Avenue813/PaginaContatti/contatti.html" class="cool-link">Contact us</a></li>
											<li><a href="#footer" class="cool-link">Helps</a></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="colonna3">
								<div class="logindiv">
								<%   if(userSession.getAttribute("username") == null && userSession.getAttribute("passw") == null){ %>
									<a id="login" href="/Avenue813/PaginaAutenticazione/login.jsp"><img src="/Avenue813/immagini/loginimg.png" width=70px; height=80px;></a>
								<% } else{
										%>
									<div class="user"><%= userSession.getAttribute("username")%></div>
									<div class="info"><a href="LogoutServlet">Logout</a></div>
										<% } %>
								</div>
							</div>
					
				</div>
		</div>
</body>
</html>