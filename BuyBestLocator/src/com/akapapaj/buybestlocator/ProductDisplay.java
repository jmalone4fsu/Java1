package com.akapapaj.buybestlocator;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.widget.GridLayout;
import android.widget.TextView;

public class ProductDisplay extends GridLayout {
	
	
	String _current = "";
	TextView _info;
	TextView _sku;
	TextView _name;
	TextView _desc;
	TextView _price;
	TextView _location;
	Context _context;
	LayoutParams lp;
	
	
	public ProductDisplay(Context context){
		super(context);
		
		_context = context;
		
		this.setColumnCount(2);
		this.setBackgroundColor(0Xff1e90ff);
		
		//this.setUseDefaultMargins(true);
		//TextView infoLabel = new TextView(_context);
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		TextView infoLabel = (TextView)inflater.inflate(R.layout.activity_main, null);
		infoLabel.setText("Test Info");
		infoLabel.setTextSize(10);
		infoLabel.setBackgroundColor(0Xff1e90ff);
		infoLabel.setTextColor(Color.BLACK);
		_info = new TextView(_context);
		_info.setTextSize(10);
		_info.setText("try 6936592 or 4837446 or 4983015");
		_info.setBackgroundColor(0Xff1e90ff);
		_info.setTextColor(Color.BLACK);
		
		TextView skuLabel = new TextView(_context);
		skuLabel.setText("Sku: "+"\n");
		skuLabel.setTextColor(Color.YELLOW);
		_sku = new TextView(_context);
		_sku.setTextColor(Color.YELLOW);
		_sku.setTypeface(null, Typeface.BOLD);
		
		//TextView nameLabel = new TextView(_context);
		TextView nameLabel = (TextView)inflater.inflate(R.layout.activity_main, null);
		nameLabel.setText("Name: "+"\n");
		
		_name = (TextView)inflater.inflate(R.layout.activity_main, null);
		_name.setWidth(350);
		
		TextView descLabel = (TextView)inflater.inflate(R.layout.activity_main, null);
		descLabel.setText("Desc: "+"\n");
		
		
		_desc = (TextView)inflater.inflate(R.layout.activity_main, null);
		_desc.setWidth(350);
		
		TextView priceLabel = (TextView)inflater.inflate(R.layout.activity_main, null);
		priceLabel.setText("Price: "+"\n");
		_price = (TextView)inflater.inflate(R.layout.activity_main, null);
		_price.setTypeface(null, Typeface.BOLD);
		
		TextView locationLabel = (TextView)inflater.inflate(R.layout.activity_main, null);
		locationLabel.setText("Location:  "+"\n");
		_location = (TextView)inflater.inflate(R.layout.activity_main, null);
		_location.setTypeface(null, Typeface.BOLD);
		_location.setTextSize(12);
		 
		this.addView(infoLabel);
		this.addView(_info);
		this.addView(skuLabel);
		this.addView(_sku);
		this.addView(nameLabel);
		this.addView(_name);
		this.addView(descLabel);
		this.addView(_desc);
		this.addView(priceLabel);
		this.addView(_price);
		this.addView(locationLabel);
		this.addView(_location);
	}
	
}
