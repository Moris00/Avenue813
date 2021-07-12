package it.avenue813.model;

import java.util.ArrayList;

public class CarrelloBean {

	ArrayList<ProductBean> list;
	double costoTot;
	
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
	
	public void removeProduct(ProductBean product) {
		list.remove(searchProduct(product));
		costoTot = costoTot - product.getPrice();
	}
	
	public boolean isEmpty() {
		if(list.size() == 0) return true;
		else return false;
	}
	
	public ProductBean getAProduct(int index) {
		return list.get(index);
	}
	
	public int getSizeList() {
		return list.size();
	}
	
	public double giveTot() {return costoTot;}
	
	public int searchProduct(ProductBean product) {
		int i = 0;
		
		while(i < getSizeList()) {
			if(list.get(i).equals(product)) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
	
	public ArrayList<ProductBean> getProducts(){return list;}
}
