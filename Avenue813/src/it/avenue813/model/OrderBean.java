package it.avenue813.model;

public class OrderBean {
	int numero_order;
	int id_order;
	int id_customer;
	int id_product;
	String nome;
	String cognome;
	String indirizzo;
	String data;
	double amount;
	String telefono;
	String method_pagament;
	
	public OrderBean() {
		numero_order = 0;
		id_order = -1;
		id_customer = -1;
		id_product = -1;
		nome ="";
		cognome = "";
		indirizzo ="";
		data = "";
		amount = 0.00;
		telefono ="";
		method_pagament = "";
	}

	public int getId_order() {
		return id_order;
	}

	public void setId_order(int id_order) {
		this.id_order = id_order;
	}

	public int getId_customer() {
		return id_customer;
	}

	public void setId_customer(int id_customer) {
		this.id_customer = id_customer;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public int getIdProduct() {
		return id_product;
	}
	
	public void setIdProduct(int id) {
		this.id_product = id;
	}
	
	public String getMethod() {
		return method_pagament;
	}
	
	public void setMethod(String method_pagament) {
		this.method_pagament = method_pagament;
	}
	
	public int getNumOrder() {
		return numero_order;
	}
	
	public void setNumOrder(int numero_order) {
		this.numero_order = numero_order;
	}

}
