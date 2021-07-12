package it.avenue813.model;

import java.io.Serializable;

public class ProductBean implements Serializable {

	private static final long serialVersionUID = 1;
	
	int id;
	String name;
	double price;
	double weight;
	String desc;
	String category;
	String create_date;
	int stocks;
	String path;
	
	public ProductBean(){
		id = -1;
		name = "";
		price = 0;
		weight = 0;
		desc = "";
		category = "";
		create_date = "";
		stocks = 0;
		path="";
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

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
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

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
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
	
	public boolean equals(Object x) {
		ProductBean o = (ProductBean) x;
		
		return o.getId() == id;
	}
}
