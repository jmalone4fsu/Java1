package com.akapapaj.buybestspecials;



import java.util.ArrayList;
import java.util.Arrays;

import com.akapapaj.mylib.FormStuff;
import com.akapapaj.mylib.Product;
import com.akapapaj.mylib.SpecialDays;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/*
 *  Author: Joseph Malone akaPapaJ
 *  Class:  Java 1 - Week 2
 *  Instructor: Josh Donlan
 *  Date: November 1, 2012
 */

public class MainActivity extends Activity {
	TextView detailsView;
	private ArrayAdapter<String> listAdapter;
	private ListView mainListView;
	String shortDesc;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.view.View truckLL = findViewById(R.id.truck);
        
        //Find the ListView resource
        mainListView = (ListView) findViewById( R.id.mainListView);
        //This was for testing purposes
        //Create and populate a list of planets
        //String[] planets = new String[] {
        //		"Mercury", "Venus", "Earth", "Mars", "Jupiter"};
        
        
        Product macbook = new Product(getString(R.string.macbook_sku), getString(R.string.macbook_name), getString(R.string.macbook_desc), getString(R.string.macbook_price));
        Product iphone = new Product(getString(R.string.iphone_sku), getString(R.string.iphone_name), getString(R.string.iphone_desc), getString(R.string.iphone_price));
        Product macpro = new Product(getString(R.string.macpro_sku), getString(R.string.macpro_name), getString(R.string.macpro_desc), getString(R.string.macpro_price));
        Product imac = new Product(getString(R.string.imac_sku), getString(R.string.imac_name), getString(R.string.imac_desc), getString(R.string.imac_price));

        final Product[] allProducts = {
        		macbook, iphone, macpro, imac
        };
        String[] ProNames = {
        		macbook.prod_name, iphone.prod_name, macpro.prod_name, imac.prod_name
        		
        };
        //Log.i("Product Sku", productSku[0]);
        for(int i=0; i<ProNames.length; i++){
        	Log.i("List Items", ProNames[i]+"\n");
        }
        
        ArrayList<String> productList = new ArrayList<String>();
        productList.addAll( Arrays.asList(ProNames) );
        
        //Create ArrayAdapter using product list.
        listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, productList);
        
        //Add more product - showing how to add to listAdapter
        listAdapter.add( "Samdung Nexless");
        listAdapter.add("THC OhYeah");
        
        detailsView = (TextView) findViewById(R.id.detailsView);
        
        mainListView.setAdapter(listAdapter);
        //set onlick listener for the listAdapter
        mainListView.setOnItemClickListener(new OnItemClickListener() {
        	@Override
        	public void onItemClick(AdapterView<?> arg0,
        			View theListAdapter, int arg2, long arg3){
        		TextView slick = (TextView) theListAdapter;
        		String transName = slick.getText().toString() + "\n";
        		
        		detailsView.setText("");
        		detailsView.append(transName);
        		
        		Log.i("Product Name: ", slick.getText().toString());
        		//Find what product was selected by user
        		String prodSelected = slick.getText().toString();
        		for(int i=0; i<allProducts.length; i++){
        			
        			//setup detailsView to display product details
        			//This information will be loaded from the BestBuy api
        			Product findProduct = allProducts[i];
        			if (prodSelected == findProduct.prod_name) {
        				String sku = ("SKU :" + findProduct.prod_sku + "\n");
        				String name = findProduct.prod_name + "\n";
        				shortDesc = findProduct.prod_desc +"\n";
        				String price = findProduct.prod_price;
        				String[] prod_details = {sku, name, shortDesc, price};
        				detailsView.setText("");
        				for(int k=0; k<4; k++){
        					String mydet = prod_details[k];
        					detailsView.append(mydet);
        					Log.i("Product Details", prod_details[k]+"\n");
        				}
        			}
        		}
        	}
        });
        
        
        // setup Linear Layout from FormStuff

        LinearLayout ll = new LinearLayout(this);
        ((LinearLayout) truckLL).addView(ll);

        LinearLayout entryBox = FormStuff.enterTextWithButton(this, "Search Specials", "Go");
        
        ListView simpleList = new ListView(this);
        simpleList.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        
        //setContentView(ll);
        
        ll.addView(entryBox);
       
        
        // Using and testing functionality of my ENUM
        String mon = SpecialDays.MONDAY.toString();
        String tue = SpecialDays.TUESDAY.toString();
        String wed = SpecialDays.WEDNESDAY.toString();
        String thr = SpecialDays.THURSDAY.toString();
        String fri = SpecialDays.FRIDAY.toString();
        String sat = SpecialDays.SATURDAY.toString();
        String sun = SpecialDays.SUNDAY.toString();
        //Add all to an array and Log contents of Enums
        String[] dayArray = {mon, tue, wed, thr, fri, sat, sun};
        for(int i=0; i<dayArray.length; i++){
        	String day = dayArray[i];
        	if(day !=null){
        		Log.i("Specials", day);
        	}else{
            	Log.i("Specials", "No Specials Found");
        	}
        }
        
    }
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
