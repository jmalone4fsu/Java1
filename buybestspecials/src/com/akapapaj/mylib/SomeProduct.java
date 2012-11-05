package com.akapapaj.mylib;

public interface SomeProduct {
	//set product name
	public boolean setName(String name);
	
	//set product desc
	public boolean setDesc(String desc);
	
	//set product price
	public boolean setPrice(double price);
	
	//set product sku
	public boolean setSku(int sku);
	
	//get product name
	public String getName();
	
	//get product desc
	public String getDesc();
	
	//get product price
	public double getPrice();
	
	//get product sku
	public int getSku();
	
	
}
