<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.avenue813.utils.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<style><%@include file="../styles/header.css" %></style>
<style>
.selected{
 color: white;
}

</style>
</head>
<body>
	<%
		HttpSession userSession = request.getSession();
	%>

<div class="header">
				<div class="content">
							<div class="colonna1">
								<div class="logoimg">

									<a href="/Avenue813/PaginaHome/home.jsp"><img  class="logo" src="/Avenue813/immagini/logoavenue1.png" width=100px; height=100px;></a>

								</div>
							</div>
							<div class="colonna2">
								<div class="menu">
									<div class="content-menu">
										<ul id="lista">
										<li><a href="/Avenue813/PaginaHome/home.jsp" class="cool-link">Home</a></li>
											<%if(userSession.getAttribute("username") == null){ %>
											<li><a href="/Avenue813/PaginaShop/shop.jsp?Sesso=uomo" class="cool-link">Uomo</a></li>
											<li><a href="/Avenue813/PaginaShop/shop.jsp?Sesso=donna" class="cool-link">Donna</a></li>
											<% }else{ if(userSession.getAttribute("Sesso").equals("donna")){ userSession.setAttribute("Sesso", "uomo"); %>
												<li><a href="/Avenue813/PaginaShop/shop.jsp?Sesso=<%=userSession.getAttribute("Sesso")%>" class="cool-link">Uomo</a></li>
												<li><a class="selected" >Donna</a></li>
											<% }else{  if(userSession.getAttribute("Sesso").equals("uomo")) {userSession.setAttribute("Sesso", "donna");%>
													<li><a class="selected" >Uomo</a></li>
													<li><a href="/Avenue813/PaginaShop/shop.jsp?Sesso=<%=userSession.getAttribute("Sesso")%>" class="cool-link">Donna</a></li>
											<% }}} %>
											<li><a href="/Avenue813/PaginaAutenticazione/login.jsp" class="cool-link">Login</a></li>
											
										</ul>
									</div>
								</div>
							</div>
							<div class="colonna3">
								<div class="logindiv">
								<%   if(userSession.getAttribute("username") == null && userSession.getAttribute("passw") == null){ %>
									<a id="login" href="/Avenue813/PaginaShop/carrello.jsp"><img src="/Avenue813/immagini/carrello-png-2.png" width= 50px; height=50px;></a>
								<% } else{
										%>
									<div class="user"><%= userSession.getAttribute("username")%></div>
									<div class="info"><a href="/Avenue813/LogoutServlet">Logout</a></div>
									<div class="info"><a href="/Avenue813/PaginaShop/carrello.jsp">Carrello</a></div>
										<% } %>
								</div>
							</div>
					
				</div>
		</div>
</body>
</html>