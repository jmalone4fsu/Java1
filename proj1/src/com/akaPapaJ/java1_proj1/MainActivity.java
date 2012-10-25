package com.akaPapaJ.java1_proj1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
/*
 *  Author: Joseph Malone akaPapaJ
 *  Class:  Java 1 - Week 1
 *  Instructor: Josh Donlan
 *  Date: October 24, 2012
 */
public class MainActivity extends Activity {

	LinearLayout ll;
	LinearLayout.LayoutParams lp;
	TextView myHeader;
	TextView mainTv;
	TextView mainTv2;
	TextView moreTv;
	TextView headerTwo;
	TextView orderTv;
	EditText et;
	int itemCount1;
	int itemCount2;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Morgia's Pizza & More");

        //Setup Layout
        ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(lp);
        
        //Setup myHeader TextView
        myHeader = new TextView(this);
        myHeader.setText("Morgia's Pizza Menu");
        myHeader.setHeight(50);
        myHeader.setTextSize(18);
        myHeader.setTextColor(Color.YELLOW);
        myHeader.setBackgroundColor(Color.RED);
        
        ll.addView(myHeader);
        
        //setup mainTv textView
        mainTv = new TextView(this);
        
        // set text from Resource values to cyan on black background
        mainTv.setTextColor(Color.CYAN);
        mainTv.setBackgroundColor(Color.BLACK);
        
        //Menu Items loaded from Resource values
        Resources res = getResources();
        String[] pizzaItems = res.getStringArray(R.array.items);
        itemCount1 = pizzaItems.length;
        for (int i=0; i < itemCount1; i++) {
        	mainTv.append((pizzaItems[i]+"\n"));
        }
        //setup mainTv2 textView  
        mainTv2 = new TextView(this);
        
        //set text from array to green on black background
        mainTv2.setTextColor(Color.GREEN);
        mainTv2.setBackgroundColor(Color.BLACK);
        
        //Menu Items loaded from Array
        String[] menuItems = {"12 Wings", "Garlic Knots", "Cheese Bread"};
        itemCount2 = menuItems.length;
        for (int i=0; i < itemCount2; i++) {
        	mainTv2.append((menuItems[i]+"\n"));
        }
        ll.addView(mainTv);
        ll.addView(mainTv2);
        
        //Setup the Order header
        headerTwo = new TextView(this);
        headerTwo.setText("Your Order");
        headerTwo.setTextColor(Color.YELLOW);
        headerTwo.setBackgroundColor(Color.RED);
        
        //Setup the Order TextView
        orderTv = new TextView(this);
        
        //Set background color to Yellow
        orderTv.setBackgroundColor(Color.YELLOW);
        
        //Set text to Bold
        orderTv.setTypeface(null, Typeface.BOLD);
        
        //add views to linear layout
        ll.addView(headerTwo);
        ll.addView(orderTv);
        
        et = new EditText(this);
        et.setHint("Add to Order");
        
        Button b = new Button(this);
        b.setText("Add");
        
        // listen for user to click Add button
        b.setOnClickListener(new View.OnClickListener() {
			@Override
			// function to invoke when Add button is pressed
			public void onClick(View v) {
	        	boolean isGood = true;

				String entry = et.getText().toString();
				// check if entry is null or empty
				if(entry == null || entry.equals("")){
					isGood = false;
					// show user that input value is empty
					Toast.makeText(getApplicationContext(), "Cannot input empty value", Toast.LENGTH_SHORT).show();
					return;
				}
				// if entry is not empty, add entry to text view
				if(isGood) orderTv.append(entry+"\r\n");
				
					// method to close the keyboard
					InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(orderTv.getWindowToken(), 0);
					
					// show user that entry was added to the order view
					Toast.makeText(getApplicationContext(), "Entry Added", Toast.LENGTH_SHORT).show();
					
					// clear the edit text
					et.setText("");
				
			}
			

		});
        
        LinearLayout form = new LinearLayout(this);
        form.setOrientation(LinearLayout.HORIZONTAL);
        
        form.setLayoutParams(lp);
        form.addView(et);
        form.addView(b);
        
        ll.addView(form);
        
        setContentView(ll);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}