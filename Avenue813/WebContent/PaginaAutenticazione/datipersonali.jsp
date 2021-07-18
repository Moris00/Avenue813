<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.* , it.avenue813.model.*, it.avenue813.utils.* , javax.sql.DataSource"%>
    <%
		HttpSession userSessionn = request.getSession();
    	
    
    	UserModelDS modelUser = new UserModelDS((DataSource)getServletContext().getAttribute("DataSource"));
    	String username = (String) userSessionn.getAttribute("username");
    	String password = (String) userSessionn.getAttribute("passw");
    	
    	if(userSessionn.getAttribute("username") == null && userSessionn.getAttribute("passw") == null){
    		response.sendRedirect("/Avenue813/PaginaUtili/errorpage.jsp");
    	}else{
    	
    		UserBean bean = modelUser.canLogin(username, password);
	%>
<!DOCTYPE html>
<html>
	<head>

		<meta charset="ISO-8859-1">
		<title>Profilo <%=userSessionn.getAttribute("username")%></title>
		<style><%@include file="datipersonali.css"%></style>
		<script><%@include file="scripts/datipersonali.js"%></script>
	</head>
	<body>


	
		<div class="main">
			<div class="head">
				<%@include file="../PaginaUtili/header.jsp"%>
			</div>
			<div class="content">
				<div class="titolo">
					<h1> Benvenuto, <%=userSession.getAttribute("username")%></h1>
				</div>
				<div class = "image_profile">
					<img src="/Avenue813/immagini/loginimg.png" alt="immagine utente" width=300px; height=350px;>
					<input type="file" id="file" name="file" multiple > 
					<label for="file">Select a photo</label>
				</div>
				
				<form name="dati">
				
				<div id = "dati_profile">
					<h2>Nome : <%=bean.getName()%></h2><br>
					<h2>Cognome : <%=bean.getSecond_name() %></h2><br>
					<h2>Username : <%=bean.getUsername() %></h2><br>
					<h2>E-mail : <%=bean.getEmail() %></h2><br>
					<h2>Password : <%=bean.getPassword() %></h2><br>
					<div class="pulsanti">
						<input type="button" value="Modifica" onclick="return visibleModifyAccount()">
					</div>
				</div>
				
				<div id = "modifiche">
					<h2>Modifiche</h2><br>
					<h2>Cognome : <%=bean.getSecond_name() %></h2><br>
					<h2>Username : <%=bean.getUsername() %></h2><br>
					<h2>E-mail : <%=bean.getEmail() %></h2><br>
					<h2>Password : <%=bean.getPassword() %></h2><br>
					<div class="pulsanti">
						<input type="button" value="Salva"  onclick="return visibleDati()">
					</div>
				</div>
				
				</form>
				
			</div>
		</div>
	
		
	</body>
</html>

<% }%>