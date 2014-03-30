/*
        Copyright (C) <2014>  <Patrick Gray MacDowell>

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package com.pgmacdesign.rsrtoolbox;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ImportantContactNumbers extends Activity implements View.OnClickListener {

	//Buttons
	Button call_aol, call_asurion, call_coos, call_customer_service, call_financial_services, 
	call_IT, call_ivr, call_port_center, call_rebate_center, call_tech_support, call_trade_in_center;
	
	
	//Main - When the activity starts
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.important_contact_numbers);
		Initialize();
		
		
	}

	//Initialize Variables
	private void Initialize(){
		
		//Button Assignments
		call_aol = (Button) findViewById(R.id.call_aol);
		call_asurion = (Button) findViewById(R.id.call_asurion);
		call_coos = (Button) findViewById(R.id.call_coos);
		call_customer_service = (Button) findViewById(R.id.call_customer_service);
		call_financial_services = (Button) findViewById(R.id.call_financial_services);
		call_IT = (Button) findViewById(R.id.call_IT);
		call_ivr = (Button) findViewById(R.id.call_ivr);
		call_port_center = (Button) findViewById(R.id.call_port_center);
		call_rebate_center = (Button) findViewById(R.id.call_rebate_center);
		call_tech_support = (Button) findViewById(R.id.call_tech_support);
		call_trade_in_center = (Button) findViewById(R.id.call_trade_in_center);
		
		//Set the onClickListeners
		call_aol.setOnClickListener(this);
		call_asurion.setOnClickListener(this);
		call_coos.setOnClickListener(this);
		call_customer_service.setOnClickListener(this);
		call_financial_services.setOnClickListener(this);
		call_IT.setOnClickListener(this);
		call_ivr.setOnClickListener(this);
		call_port_center.setOnClickListener(this);
		call_rebate_center.setOnClickListener(this);
		call_tech_support.setOnClickListener(this);
		call_trade_in_center.setOnClickListener(this);
		
	}
	
	//On Click Method
	@Override
	public void onClick(View arg0) {

		switch (arg0.getId()){
		
		case R.id.call_aol:
			//Intent to call the number associated with the department
			Intent intent1 = new Intent(Intent.ACTION_DIAL);
			intent1.setData(Uri.parse("tel:8888324540"));
			startActivity(intent1); 
			
			break;
			
		case R.id.call_asurion:
			//Intent to call the number associated with the department
			Intent intent2 = new Intent(Intent.ACTION_DIAL);
			intent2.setData(Uri.parse("tel:8888812622"));
			startActivity(intent2); 
						
			break;
			
		case R.id.call_coos:
			//Intent to call the number associated with the department
			Intent intent3 = new Intent(Intent.ACTION_DIAL);
			intent3.setData(Uri.parse("tel:8888666924"));
			startActivity(intent3); 
			
			break;
			
		case R.id.call_customer_service:
			//Intent to call the number associated with the department
			Intent intent4 = new Intent(Intent.ACTION_DIAL);
			intent4.setData(Uri.parse("tel:8009220204"));
			startActivity(intent4); 
			
			break;
			
			
		case R.id.call_IT:
			//Intent to call the number associated with the department
			Intent intent5 = new Intent(Intent.ACTION_DIAL);
			intent5.setData(Uri.parse("tel:8668994872"));
			startActivity(intent5); 
			
			break;
			
		case R.id.call_ivr:
			//Intent to call the number associated with the department
			Intent intent6 = new Intent(Intent.ACTION_DIAL);
			intent6.setData(Uri.parse("tel:8778074646"));
			startActivity(intent6); 
			
			break;
			
			
		case R.id.call_port_center:
			//Intent to call the number associated with the department
			Intent intent7 = new Intent(Intent.ACTION_DIAL);
			intent7.setData(Uri.parse("tel:8664655415"));
			startActivity(intent7); 
			
			break;
			
		case R.id.call_rebate_center:
			//Intent to call the number associated with the department
			Intent intent8 = new Intent(Intent.ACTION_DIAL);
			intent8.setData(Uri.parse("tel:8004570864"));
			startActivity(intent8); 
			
			break;
			
			
		case R.id.call_tech_support:
			//Intent to call the number associated with the department
			Intent intent9 = new Intent(Intent.ACTION_DIAL);
			intent9.setData(Uri.parse("tel:8662214096"));
			startActivity(intent9); 
			
			break;
			
		case R.id.call_trade_in_center:
			//Intent to call the number associated with the department
			Intent intent10 = new Intent(Intent.ACTION_DIAL);
			intent10.setData(Uri.parse("tel:8777848473"));
			startActivity(intent10); 
			
			break;
			
			
		case R.id.call_financial_services:
			//Intent to call the number associated with the department
			Intent intent11 = new Intent(Intent.ACTION_DIAL);
			intent11.setData(Uri.parse("tel:8005287594"));
			startActivity(intent11); 
			
			break;
				
		}

	}
	
	protected void onPause() {

		super.onPause();
		//finish();
	}

}
