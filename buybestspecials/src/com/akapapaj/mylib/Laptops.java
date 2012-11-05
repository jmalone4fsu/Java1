package com.akapapaj.mylib;

public class Laptops implements SomeProduct {
	String name;
	String desc;
	double price;
	int sku;
	
	public Laptops(String name, String desc, double price, int sku)
	{
		setName(name);
		setDesc(desc);
		setPrice(price);
		setSku(sku);
		
	}
	@Override
	public boolean setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
		return true;
	}

	@Override
	public boolean setDesc(String desc) {
		// TODO Auto-generated method stub
		this.desc = desc;
		return true;
	}

	@Override
	public boolean setPrice(double price) {
		// TODO Auto-generated method stub
		this.price = price;
		return true;
	}

	@Override
	public boolean setSku(int sku) {
		// TODO Auto-generated method stub
		this.sku = sku;
		return true;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return this.desc;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}

	@Override
	public int getSku() {
		// TODO Auto-generated method stub
		return this.sku;
	}

}
