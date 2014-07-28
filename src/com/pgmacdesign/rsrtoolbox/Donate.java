package com.pgmacdesign.rsrtoolbox;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

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
		ArrayList skuList = new ArrayList ();
		//ArrayList<String> skuList = new ArrayList<String> ();
		Bundle querySkus;
			
	//Misc
		String donate_amount_string;
		int donate_amount_int;
		String inAppID = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAl5OixjcBpSOF1AKINQhOCHSayREQsiuh5zUQaTmt7/OVYgn0lLQFk+RjuaXk+8mhb15LmpN"
				+ "PRvFy70nG7BQ8o8ZXbLJ18y2C40xgWdi1rdYVdBguxyykmxuiC77FNP583+VOZMIp5jR868DToBJjThfaJtlMsyKjsT7PHcHR979NBAXR+auY4Oob6WIqutVdv"
				+ "TGkFO0XpzBOHEc1MfQ4n5V1y9u9SyY6cjTVZ9KXsqrya2RrFQsHdwoFsSBQ22iIXBrtzoqYSBm+95GygdJxdbLyF/1KgligBRJ2kKPYZYKqqAiRkXZ5rUshY82"
				+ "ec9w7+6WwKOL0Eq6+wA2qohzmmQIDAQAB";
		ServiceConnection mServiceConn;
		
	//Button
		Button donate_button;
	
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
		
		//Button
		donate_button = (Button) findViewById(R.id.donate_button);
		donate_button.setOnClickListener(this);
		
		//Initialize Misc Variables
		donate_amount_string = "1";
		donate_amount_int = 1;
		//base64EncodedPublicKey = "123";
		
		//SKU list
		skuList.add("donate_1_dollar");
		skuList.add("donate_5_dollars");
		skuList.add("donate_10_dollar");
		skuList.add("donate_20_dollars");
		//skuList.add("donate_$other");
		querySkus = new Bundle();
		querySkus.putStringArrayList("ITEM_ID_LIST", skuList);
		
		
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
			
			skuList.add(inAppID);
			

			//querySkus.putStringArrayList("ITEM_ID_LIST", skuList);
			
			Bundle skuDetails;
			
			try{
				
				Log.d("Look Here", "Line " + "141" + " works.");
				skuDetails = mService.getSkuDetails(3, getPackageName(), "inAppID", querySkus);
				
				int response = skuDetails.getInt("RESPONSE_CODE");
				
				if (response == 0){
					ArrayList<String> responseList = skuDetails.getStringArrayList("DETAILS_LIST");
					Log.d("Look Here", "Line " + "148" + " works.");
					
					for (String thisResponse : responseList){
						JSONObject object = new JSONObject (thisResponse);
						String sku = object.getString("productid");
						String price = object.getString("price");
						Log.d("Look Here", "Line " + "154" + " works.");
						
						if (sku.equals(inAppID)){
							Bundle buyIntentBundle = mService.getBuyIntent(3, getPackageName(), sku, "inapp", "donate_1_dollar_managed");
							
							
							
							
							Log.d("Look Here", "Line " + "162" + " works.");
							
							PendingIntent pendingIntent = buyIntentBundle.getParcelable("BUY_INTENT");
							startIntentSenderForResult(
									pendingIntent.getIntentSender(),
									1001, new Intent(), Integer.valueOf(0),
									Integer.valueOf(0), Integer.valueOf(0));
						}
					}
				} else if (response == 1){
					Log.d("Response Code Error:", "BILLING_RESPONSE_RESULT_USER_CANCELED");
				} else if (response == 3){
					Log.d("Response Code Error:", "BILLING_RESPONSE_RESULT_BILLING_UNAVAILABLE");
				} else if (response == 4){
					Log.d("Response Code Error:", "BILLING_RESPONSE_RESULT_ITEM_UNAVAILABLE");
				} else if (response == 5){
					Log.d("Response Code Error:", "BILLING_RESPONSE_RESULT_DEVELOPER_ERROR");
				} else if (response == 6){
					Log.d("Response Code Error:", "BILLING_RESPONSE_RESULT_ERROR");
				} else if (response == 7){
					Log.d("Response Code Error:", "BILLING_RESPONSE_RESULT_ITEM_ALREADY_OWNED");
				} else if (response == 8){
					Log.d("Response Code Error:", "BILLING_RESPONSE_RESULT_ITEM_NOT_OWNED");
				}
			} catch (RemoteException e){
				//
				Log.d("Das Error Yo", e.toString());
			} catch (JSONException e){
				//
				Log.d("Das Error Yo", e.toString());
			} catch (SendIntentException e){
				//
				Log.d("Das Error Yo", e.toString());
			}
			
			
			
			

			break;

			
		}
		
	}

	//OnActivity
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		
		Log.d("Look Here", "Line " + "211" + " works.");
		
		if (requestCode == 1001){
			String purchaseData = data.getStringExtra("INAPP_PURCHASE_DATA");
			Log.d("Look Here", "Line " + "215" + " works.");
		
			if (resultCode == RESULT_OK){
				try{
					JSONObject jo = new JSONObject(purchaseData);
					String sku = jo.getString(inAppID);
					Toast.makeText(Donate.this, 
							"Thank you for your donation of: " + sku + "!", 
							Toast.LENGTH_SHORT).show();
					Log.d("Look Here", "Line " + "224" + " works.");
				} catch (JSONException e){
					Toast.makeText(Donate.this, 
							"Oh Noes! Something Went Wrong?!?!", 
							Toast.LENGTH_SHORT).show();
					e.printStackTrace();
				}
			}
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