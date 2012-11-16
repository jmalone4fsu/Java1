package com.akapapaj.buybestlocator;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.akapapaj.lib.FileStuff;
import com.akapapaj.lib.WebStuff;
/*  Owner: Joseph Malone
 *  Course: Java 1   Instructor: J.Donlan
 *  Project: Buy Best Locator  Week: 3
 *  Date: November 9, 2012
 */

public class MainActivity extends Activity {
	Context _context;
	LinearLayout _appLayout;
	SearchForm _search;
	ListView listView;
	ProductDisplay _product;
	Favorites _favorites;
	Boolean _connected = false;
	double price;
	String name;
	String desc;
	int sku;
	String stringSku;
	String stringPrice;
	double doublePrice;
	HashMap<String, String> _history;
	ImageView image;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(android.R.style.Theme_Holo);
        _context = this;
        _appLayout = new LinearLayout(this);
        _history = getHistory();
        Log.i("HISTORY READ", _history.toString());
        
        _search = new SearchForm(_context, "Search by SKU", "GO");
        
        //ADD SEARCH HANDLER
        
        Button searchButton = _search.getButton();
        
        searchButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(_search._searchButton.getWindowToken(), 0);
				_connected = WebStuff.getConnectionStatus(_context);
				if(_connected){
					getAvailable(_search.getField().getText().toString());
					
				} else {
					Toast toast2 = Toast.makeText(_context, "No Network Connection", Toast.LENGTH_SHORT);
					toast2.show();
				}
				
			}
        	
        });
        
        
        //ADD PRODUCT DISPLAY
        _product = new ProductDisplay(_context);
        
        //add imageView
        ImageView imageView = new ImageView(MainActivity.this);
        imageView.setId(R.id.image_id);
        imageView.setImageResource(R.drawable.buybestsave);
        LayoutParams imageViewLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        imageView.setLayoutParams(imageViewLayoutParams);
       
        //ADD FAVORITES DISPLAY
        ArrayList<String> favorites = new ArrayList<String>(Arrays.<String>asList(FileStuff.readStringFile(_context, "favorites", true).split(",")));
        _favorites = new Favorites(_context, favorites);
        _favorites._list.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> parent, View v,
					int pos, long id) {
				if(pos > 0){
					String theSku = parent.getItemAtPosition(pos).toString();
					_search.getField().setText(theSku);
					getAvailable(theSku);
				}
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				Log.i("FAVORITE SELECTED", "NONE");
				
			}
        	
        });
        _favorites._add.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				String _sku = _product._current;
				if(_sku.length()>0){
					Boolean found = false;
					int foundpos = 0;
					for(int i=1, j=_favorites._products.size(); i<j; i++){
						if(_favorites._products.get(i).compareTo(_sku)==0){
							found = true;
							foundpos= i;
							break;
						}
					}
					if(!found){
						_favorites._products.add(_sku);
						Toast myalert = Toast.makeText(_context, "Favorite Added", Toast.LENGTH_LONG);
						myalert.show();
						storeFavorites(_sku);
						_favorites._list.setSelection(_favorites._products.size()-1);
						
					}else {
						_favorites._list.setSelection(foundpos);
					}
				} else {
					Toast myalert = Toast.makeText(_context, "Sku not found", Toast.LENGTH_LONG);
					myalert.show();
				}
				
			}
        	
        });
        //ADD VIEWS TO MAIN LAYOUT
        _appLayout.addView(_search);
        _appLayout.addView(_product);
        _appLayout.addView(imageView);
        _appLayout.addView(_favorites);
        
        _appLayout.setOrientation(LinearLayout.VERTICAL);
        
        setContentView(_appLayout);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    private void storeFavorites(String item){
    	StringBuilder sb = new StringBuilder();
    	for(int i=1, j=_favorites._products.size(); i<j; i++){
    		sb.append(_favorites._products.get(i));
    		sb.append(",");
    	}
    	String productString = sb.toString().substring(0, sb.toString().length()-1);
    	Boolean stored = FileStuff.storeStringFile(_context, "favorites", productString, true);
    	Toast myAlert;
    	if(stored){
    		myAlert = Toast.makeText(_context, "Added to Favorites", Toast.LENGTH_LONG);
    		myAlert.show();
    	}else {
    		myAlert = Toast.makeText(_context, "Favorites NOT Updated", Toast.LENGTH_LONG);
    		myAlert.show();
    	}
    }
    @SuppressWarnings("unused")
	private void getAvailable(String name){
    	
    	String apikey = "q5hfdc2etg6qsjyzsd4huba5";
    	String baseURL = "http://api.remix.bestbuy.com/v1/products(sku="+name+")?show=sku,name,shortDescription,salePrice&apiKey=q5hfdc2etg6qsjyzsd4huba5&format=json";
    	String qs;
    	try{
    		qs = URLEncoder.encode(baseURL, "UTF-8");
    	} catch (Exception e) {
    		Log.e("BAD URL", "ENCODING PROBLEM");
    		qs = "";
    	}
    	URL finalURL;
    	try {
    		finalURL = new URL(baseURL);
    		LocationRequest lr = new LocationRequest();
    		lr.execute(finalURL);
    		
    	} catch(MalformedURLException e){
    		Log.e("BAD URL", "MALFORMED URL");
    		finalURL = null;
    	}
    }
    @SuppressWarnings("unchecked")
	private HashMap<String, String> getHistory(){
    	Object stored = FileStuff.readObjectFile(_context,  "history", false);
    	
    	HashMap<String, String> history;
    	if(stored ==null){
    		Log.i("HISTORY", "NO HISTORY FILE FOUND");
    		history = new HashMap<String, String>();
    	} else {
    		history = (HashMap<String, String>) stored;
    	}
    	return history;
    }
    private class LocationRequest extends AsyncTask<URL, Void, String>{

		@Override
		protected String doInBackground(URL... urls) {
			String response = "";
			for(URL url : urls){
				response = WebStuff.getURLStringResponse(url);
			}
			return response;
		}
    	@Override
    	protected void onPostExecute(String result){
    		Log.i("URL RESPONSE", result);
    		
    		try{
    			JSONObject json = new JSONObject(result);
    			JSONArray jArray = json.getJSONArray("products");
    			//JSONArray results = json.getJSONArray("product");
    			
    			System.out.println("******JARRAY********"+jArray.length());
    			for(int i=0;i<jArray.length();i++) {
    				JSONObject json_data = jArray.getJSONObject(i);
    				
    				_history.put("name", json_data.getString("name"));
    				_history.put("saleprice", String.valueOf(json_data.getDouble("salePrice")));
    				_history.put("sku", String.valueOf(json_data.getInt("sku")));
    				_history.put("desc", json_data.getString("shortDescription"));
    				_history.put("location", "Best Buy Johnson City TN 37601");
    				FileStuff.storeObjectFile(_context, "history", _history, false);
    				FileStuff.storeStringFile(_context, "temp", json_data.toString(), true);
    				
    				Log.i("log_tag", "Name: "+json_data.getString("name")+ "\n" +
    						"Sale Price: "+json_data.getDouble("salePrice")+ "\n" +
    						"Sku: "+json_data.getInt("sku")+ "\n" +
    						"Desc: "+json_data.getString("shortDescription"));
    				_product._sku.setText(""+String.valueOf(json_data.getInt("sku")));
    				_product._current= (""+String.valueOf(json_data.getInt("sku")));
    				_product._name.setText(json_data.getString("name"));
    				_product._desc.setText(json_data.getString("shortDescription"));
    				_product._price.setText("$"+String.valueOf(json_data.getDouble("salePrice")));
    				_product._location.setText("Best Buy Johnson City TN 37601");
    				if(json_data.getString("name")==""){
    					Toast toast = Toast.makeText(_context, "Invalid Search", Toast.LENGTH_SHORT);
    					toast.show();
    				} else {
    					Toast toast = Toast.makeText(_context, "Valid Search", Toast.LENGTH_SHORT);
    					toast.show();
    					
    				
    				}
    			}
    			} catch (JSONException e){
        			Log.e("JSON", "JSON OBJECT EXCEPTION");
    			
    		}
    		
    	}
    }
}
