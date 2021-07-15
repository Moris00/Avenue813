package it.avenue813.model;

public class OrderBean {
	int id_order;
	int id_customer;
	int id_product;
	String nome;
	String cognome;
	String indirizzo;
	String data;
	double amount;
	String telefono;
	
	public OrderBean() {
		id_order = -1;
		id_customer = -1;
		id_product = -1;
		nome ="";
		cognome = "";
		indirizzo ="";
		data = "";
		amount = 0.00;
		telefono ="";
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

}
