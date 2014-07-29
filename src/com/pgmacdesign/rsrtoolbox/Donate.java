package com.pgmacdesign.rsrtoolbox;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import com.pgmacdesign.rsrtoolbox.inappbilling.*;


public class Donate extends PGMacActivity implements View.OnClickListener, OnItemSelectedListener {

	//Shared Preferences
		public static final String PREFS_NAME = "RSRToolboxData";	
		SharedPrefs sp = new SharedPrefs();
		SharedPreferences settings;
		SharedPreferences.Editor editor;
		
	//Spinners
		Spinner donate_spinner_var;
		String[]donate_choices = {"$1", "$5", "$10", "$20"};
		
	//Button
		Button donate_button;
		
	//String to be shared across to the PurchasePassportActivity
		public static String user_donate_choice;
	
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
		
		user_donate_choice = "donate_1_dollar_managed";
		
		//Button
		donate_button = (Button) findViewById(R.id.donate_button);
		donate_button.setOnClickListener(this);		
		
		//Array Adapter for Spinner use with the daily tab
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, donate_choices);
		
		//Other spinner details
		donate_spinner_var = (Spinner) findViewById(R.id.donate_spinner); 
		donate_spinner_var.setAdapter(adapter);
		donate_spinner_var.setOnItemSelectedListener(this);
		
		
	}
	
	//On Click Method
	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()){
		
		case R.id.donate_button:
			
			navigate().toPurchasePassportActivityForResult();

			break;

		}	
	}

	//
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (Navigator.REQUEST_PASSPORT_PURCHASE == requestCode) {
            if (RESULT_OK == resultCode) {
                dealWithSuccessfulPurchase();
            } else {
                dealWithFailedPurchase();
            }
        }
    }
	
	//Used for the spinner choice
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		
		switch (position){
				
				//$1
				case 0:
					user_donate_choice = "donate_1_dollar";
					break;
					
				//$5
				case 1:
					user_donate_choice = "donate_5_dollars";
					break;
					
				//$10
				case 2:
					user_donate_choice = "donate_10_dollars";		
					break;
					
				//$20
				case 3:
					user_donate_choice = "donate_20_dollars";
					break;					
			}
	}


	
	//Used for the spinner choice (when nothing selected)
	public void onNothingSelected(AdapterView<?> parent) {
		
	}
	
    private void dealWithSuccessfulPurchase() {
        Log.d("Donation Complete", "Donation Complete. Thank you!");
        popToast("Donation Complete. Thank you!");
    }

    private void dealWithFailedPurchase() {
        Log.d("Donate Failed!","Donation Failed /Sad Panda!");
        popToast("Donation Failed /Sad Panda!");
    }
    
	protected void onPause() {
		super.onPause();
		
	}
	


}

