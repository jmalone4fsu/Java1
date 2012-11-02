package com.akapapaj.mylib;
/*
 *  Author: Joseph Malone akaPapaJ
 *  Class:  Java 1 - Week 2
 *  Instructor: Josh Donlan
 *  Date: November 1, 2012
 */
public class Product {
	public String prod_sku;
	public String prod_name;
	public String prod_desc;
	public String prod_price;
	public Product(String sku, String name, String desc, String price){
		prod_sku = sku;
		prod_name = name;
		prod_desc = desc;
		prod_price = price;
	}
}
