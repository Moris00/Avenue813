package it.avenue813.model;

import java.util.ArrayList;

public class CarrelloBean {

	private ArrayList<ProductBean> list;
	private double costoTot;
	
	public CarrelloBean() {
		list = new ArrayList<ProductBean>();
		costoTot = 0.00;
	}
	
	public boolean addProduct(ProductBean product) {
		if(product.getStocks() <= 0) return false;
		
		list.add(product);
		costoTot = costoTot + product.getPrice();
		return true;
	}
	
	public boolean removeProduct(ProductBean product) {
		list.remove(product);
		costoTot = costoTot - product.getPrice();
		return true;
	}
	
	public boolean isEmpty() {
		if(list.size() == 0) return true;
		else return false;
	}
	
	public ProductBean getAProduct(int index) {
		return list.get(index);
	}
	
	public double giveTot() {return costoTot;}
	
	
	public ArrayList<ProductBean> getProducts(){return list;}
}
