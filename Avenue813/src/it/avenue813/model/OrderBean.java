package it.avenue813.model;

public class OrderBean {
	int id_order;
	int id_customer;
	String nome;
	String cognome;
	String indirizzo;
	String data;
	
	public OrderBean() {
		id_order = -1;
		id_customer = -1;
		nome ="";
		cognome = "";
		indirizzo ="";
		data = "";
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


}
