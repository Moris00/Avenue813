<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Aggiungi un Prodotto</title>
		<style><%@include file="aggiungi_prodotti.css"%></style>
		<script><%@include file="validAddProduct.js"%></script>
	</head>
	<body>
		<div class="main">
			<div class="head">
				<%@include file="/../../PaginaUtili/header.jsp" %>
			</div>
			<div class="box">
				<div class="title">
					<h2>Aggiungi un prodotto</h2>
				</div>
				<div class="box_add">
					<form name="add">
						<div class="information">
							<input type="text" id="nome_prodotto" name="nome_prodotto" placeholder="Nome" onblur="return isValidName()">
							<input type="text" id="prezzo" name="prezzo" placeholder="Prezzo" onblur="return isValidPrice()">
							<select id="categoria">
								<optgroup label="Categoria">
									<option>Maglie</option>
									<option>Pantaloni</option>
									<option>Sneakers</option>
									<option>Accessori</option>
								</optgroup>
							</select>
							<select id="sesso">
								<optgroup label="Sesso">
									<option>Uomo</option>
									<option>Donna</option>
								</optgroup>
							</select>
							<input type="text" id="quantita" name="quantita" placeholder="Quantità" onblur="return isValidQuantita()">
							<input type="file" name="foto" >
							<p id="error"></p>
							<input type="submit" value="Aggiungi">
					
						</div>
					</form>
				</div>
			
			</div>
		
		</div>
	</body>
</html>