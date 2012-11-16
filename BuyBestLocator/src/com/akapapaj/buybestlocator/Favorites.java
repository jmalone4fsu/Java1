package com.akapapaj.buybestlocator;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class Favorites extends LinearLayout {
	
	Button _add;
	Spinner _list;
	Context _context;
	ArrayList<String> _products = new ArrayList<String>();
	
	public Favorites(Context context){
		super(context);
		favoritesDisplay(context);
	}
	public Favorites(Context context, ArrayList<String> items){
		super(context);
		favoritesDisplay(context);
		for(int i=0, j=items.size(); i<j; i++){
			_products.add(items.get(i));
		}
	}
	private void favoritesDisplay(Context context){
	
		_context = context;
		
		LayoutParams lp;
		lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		this.setLayoutParams(lp);
		_products.add("Select Favorite");
		
		_list = new Spinner(_context);
		_list.setBackgroundColor(Color.DKGRAY);
		lp = new LayoutParams(0,LayoutParams.WRAP_CONTENT, 1.0f);
		_list.setLayoutParams(lp);
		
		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(_context, android.R.layout.simple_spinner_item, _products);
		listAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		_list.setAdapter(listAdapter);

		_add = new Button(_context);
		_add.setTextColor(Color.YELLOW);
		_add.getBackground().setColorFilter(new LightingColorFilter(0xff000000, 0xff00ff00));
		_add.setText("+");
		
		this.addView(_list);
		this.addView(_add);
		
	
	}
	
}
