<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.avenue813.utils.*, it.avenue813.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<style><%@include file="../styles/header.css" %></style>
<style><%@include file="../PaginaHome/mobile.css"%></style>
<style>
.selected{
 color: white;
}

</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
  $(document).ready(function(){
    $("#menuButton").click(function(){
      $("#menu").slideToggle();
    }); 
  });

</script>
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
											<li><a href="/Avenue813/PaginaShop/shop.jsp?Sesso=uomo&Category=" class="cool-link">Uomo</a></li>
											<li><a href="/Avenue813/PaginaShop/shop.jsp?Sesso=donna&Category=" class="cool-link">Donna</a></li>
											<%if(userSession.getAttribute("username") == null){ %>
											<li><a href="/Avenue813/PaginaAutenticazione/login.jsp" class="cool-link">Login</a></li>
											<%}else
											{ %>
												
												
                                              <li><a id="menuButton"><%=userSession.getAttribute("username")%></a></li>
                                              
                                              <div id="menu" style="display:none;">
                                                 <p><a href="/Avenue813/PaginaAutenticazione/datipersonali.jsp"> Dati Personali</a></p>
                                                 <p><a href="/Avenue813/PaginaAutenticazione/mieiordini.jsp">I miei ordini</a></p>
                                                 <p><a href="/Avenue813/PaginaContatti/supportoemail.jsp">Contatti</a></p>
                                                 <p><a href="https://www.instagram.com/dark_anthony_spartano/">Social</a></p>
                                              </div>
				
  								
												
											
											
											<%} %> 
											</ul>
											</div>
											
											
										
										
									</div>
									
								</div>
								
															<div class="colonna3">
							

							
							<!--AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA-->
							
		
    
<input type="checkbox" id="hamburger"/>
<label class="menuicon" for="hamburger"><img src="/Avenue813/immagini/menu.png" id="imgmenu" alt="menu" width=50px height=50px></label>


<div id="bar"> 

</div>

    <nav class="menu-visibility">

         <ul>
            <li><a href="/Avenue813/PaginaHome/home.jsp">HOME</a></li>
            <li><a href="/Avenue813/PaginaShop/shop.jsp?Sesso=uomo">UOMO</a></li>       
            <li><a href="/Avenue813/PaginaShop/shop.jsp?Sesso=donna">DONNA</a></li>
            <% if(userSession.getAttribute("username") == null){ %>
            <li><a href="/Avenue813/PaginaAutenticazione/login.jsp">LOGIN</a></li>
            <%}else{ %>
            <li><a href="/Avenue813/PaginaAutenticazione/datipersonali.jsp"><%=userSession.getAttribute("username")%></a></li>
            <li><a href="/Avenue813/PaginaAutenticazione/mieiordini.jsp">I MIEI ORDINI</a></li>
            <li><a href="/Avenue813/PaginaContatti/supportoemail.jsp">CONTATTI</a></li>
            <li><a href="/Avenue813/PaginaShop/carrello.jsp">CARRELLO</a></li>
            <li><a href="/Avenue813/LogoutServlet">LOGOUT</a></li>
            
            <% } %>
           </ul>
  
</nav>
							
						
		
							
							<!--AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA-->
							
							
							
							
							
						
								<div class="logindiv">
								<%   if(userSession.getAttribute("username") == null && userSession.getAttribute("passw") == null){ %>
							
								<% } else{
										%>
										
									
										<a id="login" href="/Avenue813/PaginaShop/carrello.jsp"><img src="/Avenue813/immagini/carrello-png-2.png" id="imgcar" width= 50px; height=50px;></a>
									<div class="info"><a href="/Avenue813/LogoutServlet">Logout</a></div>
									
									<div class="numerino">
			                           <%CarrelloBean numerino = (CarrelloBean) userSession.getAttribute("carrello");
			                           		if(numerino != null){%>
		                               <h3><%= numerino.getSizeList()%></h3>
		                                 </div>
									
										<% }} %>
										
								</div>
								     
							   </div>
							</div>

					
				</div>
		
		
</body>
</html>