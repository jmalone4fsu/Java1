package com.akapapaj.buybestlocator;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.GridLayout;
import android.widget.TextView;

public class ProductDisplay extends GridLayout {
	
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
		
		//this.setUseDefaultMargins(true);
		TextView infoLabel = new TextView(_context);
		infoLabel.setText("Info");
		infoLabel.setTextSize(10);
		_info = new TextView(_context);
		_info.setTextSize(10);
		_info.setText("try 6936592 or 4837446 or 4983015");
		
		TextView skuLabel = new TextView(_context);
		skuLabel.setText("Sku: "+"\n");
		_sku = new TextView(_context);
		_sku.setTypeface(null, Typeface.BOLD);
		
		TextView nameLabel = new TextView(_context);
		nameLabel.setText("Name: "+"\n");
		
		_name = new TextView(_context);
		_name.setWidth(350);
		_name.setTextSize(12);
		
		TextView descLabel = new TextView(_context);
		descLabel.setText("Desc: "+"\n");
		_desc = new TextView(_context);
		_desc.setWidth(350);
		_desc.setTextSize(12);
		
		TextView priceLabel = new TextView(_context);
		priceLabel.setText("Price: "+"\n");
		_price = new TextView(_context);
		_price.setTypeface(null, Typeface.BOLD);
		
		TextView locationLabel = new TextView(_context);
		locationLabel.setText("Location:  "+"\n");
		_location = new TextView(_context);
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
