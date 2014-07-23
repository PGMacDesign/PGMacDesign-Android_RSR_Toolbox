package com.pgmacdesign.rsrtoolbox;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.android.vending.billing.IInAppBillingService;

public class Donate extends Activity implements View.OnClickListener, OnItemSelectedListener {

	//Shared Preferences
		public static final String PREFS_NAME = "RSRToolboxData";	
		SharedPrefs sp = new SharedPrefs();
		SharedPreferences settings;
		SharedPreferences.Editor editor;
	
	//Billing
		IInAppBillingService mService;
		
	//Spinners
		Spinner donate_spinner_var;
		String[]donate_choices = {"$1", "$5", "$10", "$20"};
		
	//List to ping the Google server 
		ArrayList<String> skuList = new ArrayList<String> ();
		Bundle querySkus;
			
	//Misc
		String donate_amount_string;
		int donate_amount_int;
		String base64EncodedPublicKey;
		ServiceConnection mServiceConn;
	
	//Main - When the activity starts
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.donate);

		//Initialize Variables
		Initialize();
		
		
	}

	//Initialize Variables
	private void Initialize(){
		//Shared Preferences Stuff
		settings = getSharedPreferences(PREFS_NAME, 0);
		editor = settings.edit();
		
		//Initialize Misc Variables
		donate_amount_string = "1";
		donate_amount_int = 1;
		base64EncodedPublicKey = "123";
		
		//SKU list
		skuList.add("donate_$1");
		skuList.add("donate_$5");
		skuList.add("donate_$10");
		skuList.add("donate_$20");
		skuList.add("donate_$other");
		querySkus = new Bundle();
		//querySkus.putStringArrayList(“ITEM_ID_LIST”, skuList); //?
		
		//Array Adapter for Spinner use with the daily tab
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, donate_choices);
		
		//Other spinner details
		donate_spinner_var = (Spinner) findViewById(R.id.donate_spinner); 
		donate_spinner_var.setAdapter(adapter);
		donate_spinner_var.setOnItemSelectedListener(this);
		
		mServiceConn = new ServiceConnection() {
			   @Override
			   public void onServiceDisconnected(ComponentName name) {
			       	mService = null;
			   }
			
			   @Override
			   public void onServiceConnected(ComponentName name, 
			      IBinder service) {
			       mService = IInAppBillingService.Stub.asInterface(service);
			   }
			};
			
		bindService(new Intent("com.android.vending.billing.InAppBillingService.BIND"), mServiceConn, Context.BIND_AUTO_CREATE);
	}
	
	//On Click Method
	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()){
		
		case R.id.donate_button:
			
			//Starts the intent to donate

			
			
			
			

			break;

			
		}
		
	}

	//Used for the spinner choice
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		
		switch (position){
				
				//$1
				case 0:
					donate_amount_string = "1";
					donate_amount_int = 1;
					break;
					
				//$5
				case 1:
					donate_amount_string = "5";
					donate_amount_int = 5;
					break;
					
				//$10
				case 2:
					donate_amount_string = "10";
					donate_amount_int = 10;			
					break;
					
				//$20
				case 3:
					donate_amount_string = "20";
					donate_amount_int = 20;	
					break;					
			}
	}


	
	//Used for the spinner choice (when nothing selected)
	public void onNothingSelected(AdapterView<?> parent) {
		
	}
	
	protected void onPause() {
		super.onPause();
		
	}
	
	public void onDestroy() {
	    super.onDestroy();
	    if (mService != null) {
	        unbindService(mServiceConn);
	    }   
	}

}



/*


*/