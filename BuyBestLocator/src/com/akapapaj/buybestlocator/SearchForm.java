package com.akapapaj.buybestlocator;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class SearchForm extends LinearLayout{
	
	EditText _searchField;
	Button _searchButton;
	
	
	public SearchForm(Context context, String hint, String buttonText){
		super(context);
		
		LayoutParams lp;
		
		_searchField = new EditText(context);
		lp = new LayoutParams(0, android.view.ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f);
		_searchField.setLayoutParams(lp);
		_searchField.setHint(hint);
		
		_searchButton = new Button(context);
		_searchButton.setText(buttonText);
		
		this.addView(_searchField);
		this.addView(_searchButton);
		
		lp = new LayoutParams(android.view.ViewGroup.LayoutParams.MATCH_PARENT, android.view.ViewGroup.LayoutParams.WRAP_CONTENT);
		this.setLayoutParams(lp);
	}
	
	public EditText getField(){
		return _searchField;
	}
	public Button getButton(){
		return _searchButton;
	}

}
