package com.akaPapaJ.anothertest;


import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
/*
 *  Author: Joseph Malone akaPapaJ
 *  Class:  Java 1
 *  Instructor: Josh Donlan
 *  Date: September 26, 2012
 */
public class MainActivity extends Activity {

	LinearLayout ll;
	LinearLayout.LayoutParams lp;
	TextView myHeader;
	TextView mainTv;
	TextView moreTv;
	TextView headerTwo;
	TextView orderTv;
	EditText et;
	int itemCount1;
	int itemCount2;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
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
        
        mainTv = new TextView(this);
        
        String pizzaItems[] = {getString(R.string.item1), getString(R.string.item2), getString(R.string.item3)};
        itemCount1 = pizzaItems.length;
        for (int i=0; i < itemCount1; i++) {
        	mainTv.append((pizzaItems[i]+"\n"));
        }
        //ll.addView(mainTv);
        //moreTv = new TextView(this);
        //Menu Items loaded from Array
        String menuItems[] = {"12 Wings", "Garlic Knots", "Cheese Bread"};
        itemCount2 = menuItems.length;
        for (int i=0; i < itemCount2; i++) {
        	mainTv.append((menuItems[i]+"\n"));
        }
        ll.addView(mainTv);
        
        //Setup Your Order header
        headerTwo = new TextView(this);
        headerTwo.setText("Your Order");
        //myHeader.setHeight(50);
        //myHeader.setTextSize(18);
        headerTwo.setTextColor(Color.YELLOW);
        headerTwo.setBackgroundColor(Color.RED);
        orderTv = new TextView(this);
        
        ll.addView(headerTwo);
        ll.addView(orderTv);
        
        
        et = new EditText(this);
        et.setHint("Add to Order");
        
        Button b = new Button(this);
        b.setText("Add");
        
        b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String entry = et.getText().toString();
				orderTv.append(entry+"\r\n");
				
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
