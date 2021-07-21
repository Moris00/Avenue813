package it.avenue813.model;

import java.io.Serializable;

public class ProductBean implements Serializable {

	private static final long serialVersionUID = 1;
	
	int id;
	String name;
	double price;
	String desc;
	String category;
	int stocks;
	String path;
	String sesso;
	boolean disp;
	
	public ProductBean(){
		id = -1;
		name = "";
		price = 0;
		desc = "";
		category = "";
		stocks = 0;
		path="";
		sesso="";
		disp = true;
	}

	public boolean isDisp() {
		return disp;
	}

	public void setDisp(boolean disp) {
		this.disp = disp;
	}

	public String getSesso() {
		return sesso;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}
	
	public String getPath() {
		return path;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getStocks() {
		return stocks;
	}

	public void setStocks(int stocks) {
		this.stocks = stocks;
	}
	
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	
	public boolean equals(Object x) {
		ProductBean o = (ProductBean) x;
		
		return o.getId() == id;
	}
}
