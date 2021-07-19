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
				
				<form name="dati" action="/Avenue813/UpdateDatiServlet" method="POST" onsubmit="return isValidForm()">
				
				<div id = "dati_profile">
					
					<h2>Nome :        <input type="text"  id="nome" value="<%=bean.getName()%>" name="nome" onblur="return isValidName()"></h2><br>
					<h2>Cognome :      <input type="text" id="cognome" value="<%=bean.getSecond_name()%>" name="cognome" onblur="return isValidSName()"></h2><br>
					<h2>Username :     <input type="text"  id="username" value="<%=bean.getUsername()%>" name="username" onblur="return isValidUsername()"></h2><br>
					<h2>E-mail :           <input type="text" value="<%=bean.getEmail()%>" name="email" id="email" onblur="return isValidEmail()"> </h2><br>
					<h2>Password:  <input type="password" id="pass1" value="<%=bean.getPassword() %>" name="password" onblur="return isValidPassword()"><input type="button" class ="btn" onclick="showPass1()" value="Mostra"></h2><br>
					<div class="pulsanti">
						<div class="error">
							<p id="errore"></p>
						</div>
						<input type="submit" value="Modifica">
					</div>
				</div>
				
				
				</form>
				
			</div>
		</div>
	
		
	</body>
</html>

<% }%>