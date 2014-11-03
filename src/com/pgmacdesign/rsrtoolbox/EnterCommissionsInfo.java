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
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//This is where people input their commissions information that puts into shared preferences and calculates their commissions payout (estimated)
//Updated on 2014-11-03 to remove strategic multiplier stuff
public class EnterCommissionsInfo extends Activity implements View.OnClickListener {

	
	//Object for accessing the DatabaseAdmin class
	DatabaseAdmin db = new DatabaseAdmin(this);
	
	//EditText windows pulled from the xml
	EditText upgrade_quota, gg_quota, gg_current, gg_charge_backs, sales_dollars_quota, sales_dollars_current, working_days_left, spiffs;
	
	//Buttons pulled from the xml
	Button b_upgrade_quota, b_gg_quota, b_gg_current, b_gg_charge_backs, b_sales_dollars_quota, b_sales_dollars_current, b_working_days_left, b_spiffs;
	
	//Make changes to the Prefs File
	public static final String PREFS_NAME = "RSRToolboxData";	
	SharedPrefs sp = new SharedPrefs();
	SharedPreferences settings;
	SharedPreferences.Editor editor;
		
	//Main - When the activity starts
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.enter_commissions_information);
		
		settings = getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();
		
		Initialize();

	}

	//Initialize Variables
	private void Initialize(){

		//EditTexts
		upgrade_quota = (EditText) findViewById(R.id.enter_commissions_information_edit_text_upgrade_quota);
		gg_quota = (EditText) findViewById(R.id.enter_commissions_information_edit_text_gg_quota);
		gg_current = (EditText) findViewById(R.id.enter_commissions_information_edit_text_gg_curent);
		gg_charge_backs = (EditText) findViewById(R.id.enter_commissions_information_edit_text_gg_charge_backs);
		sales_dollars_quota = (EditText) findViewById(R.id.enter_commissions_information_edit_text_sales_dollars_quota);
		sales_dollars_current = (EditText) findViewById(R.id.enter_commissions_information_edit_text_sales_dollars_current);
		spiffs = (EditText) findViewById(R.id.enter_commissions_information_edit_text_spiffs);
		working_days_left = (EditText) findViewById(R.id.enter_commissions_information_edit_text_working_days_left);
		
		//Buttons
		b_upgrade_quota = (Button) findViewById(R.id.enter_commissions_information_button_upgrade_quota);
		b_gg_quota = (Button) findViewById(R.id.enter_commissions_information_button_gg_quota);
		b_gg_current = (Button) findViewById(R.id.enter_commissions_information_button_gg_current);
		b_gg_charge_backs = (Button) findViewById(R.id.enter_commissions_information_button_gg_charge_backs);
		b_sales_dollars_quota = (Button) findViewById(R.id.enter_commissions_information_button_sales_dollars_quota);
		b_sales_dollars_current = (Button) findViewById(R.id.enter_commissions_information_button_sales_dollars_current);
		b_spiffs = (Button) findViewById(R.id.enter_commissions_information_button_spiffs);
		b_working_days_left = (Button) findViewById(R.id.enter_commissions_information_button_working_days_left);
		
		//Set buttons to onClickListener
		b_upgrade_quota.setOnClickListener(this);
		b_gg_quota.setOnClickListener(this);
		b_gg_current.setOnClickListener(this);
		b_gg_charge_backs.setOnClickListener(this);
		b_sales_dollars_quota.setOnClickListener(this);
		b_sales_dollars_current.setOnClickListener(this);
		b_spiffs.setOnClickListener(this);
		b_working_days_left.setOnClickListener(this);
		
		//SharedPreferences
		settings = getSharedPreferences(PREFS_NAME, 0);
		editor = settings.edit();
	}
	
	//On Click Method
	@Override
	public void onClick(View arg0) {
		
		String success = "Data has been entered successfully";
		
		switch (arg0.getId()){
		
		case R.id.enter_commissions_information_button_upgrade_quota:
			
			try {
				String str1 = upgrade_quota.getText().toString();
				double dbl = Double.parseDouble(str1);

				sp.putDouble(editor, "up_quota", dbl);
				editor.commit();
				makeToast(success);
				
			} catch (Exception e){
				makeToast(e.toString());
			}
			break;
			
		case R.id.enter_commissions_information_button_gg_quota:
			
			try {
				String str1 = gg_quota.getText().toString();
				double dbl = Double.parseDouble(str1);

				sp.putDouble(editor, "gg_quota", dbl);
				editor.commit();
				makeToast(success);
				
			} catch (Exception e){
				makeToast(e.toString());
			}
			break;	
			
		case R.id.enter_commissions_information_button_gg_current:
			
			try {
				String str1 = gg_current.getText().toString();
				double dbl = Double.parseDouble(str1);

				sp.putDouble(editor, "gg_current", dbl);
				editor.commit();
				makeToast(success);

			} catch (Exception e){
				makeToast(e.toString());
			}
			break;
			
		case R.id.enter_commissions_information_button_gg_charge_backs:
			
			try {
				String str1 = gg_charge_backs.getText().toString();
				double dbl = Double.parseDouble(str1);

				sp.putDouble(editor, "charge_backs", dbl);
				editor.commit();
				makeToast(success);

			} catch (Exception e){
				makeToast(e.toString());
			}
			break;
			
		case R.id.enter_commissions_information_button_sales_dollars_quota:
			
			try {
				String str1 = sales_dollars_quota.getText().toString();
				double dbl = Double.parseDouble(str1);

				sp.putDouble(editor, "sales_dollars_quota", dbl);
				editor.commit();
				makeToast(success);
		
			} catch (Exception e){
				makeToast(e.toString());
			}
			break;
			
		case R.id.enter_commissions_information_button_sales_dollars_current:
			
			try {
				String str1 = sales_dollars_current.getText().toString();
				double dbl = Double.parseDouble(str1);

				sp.putDouble(editor, "sales_dollars_current", dbl);
				editor.commit();
				makeToast(success);
				
			} catch (Exception e){
				makeToast(e.toString());
			}
			break;	
			
			
		case R.id.enter_commissions_information_button_spiffs:
			
			try {
				String str1 = spiffs.getText().toString();
				double dbl = Double.parseDouble(str1);

				sp.putDouble(editor, "spiffs", dbl);
				editor.commit();
				makeToast(success);

			} catch (Exception e){
				makeToast(e.toString());
			}
			break;
		
		case R.id.enter_commissions_information_button_working_days_left:
			settings = getSharedPreferences(PREFS_NAME, 0); //wtf java
			SharedPreferences.Editor editor = settings.edit(); //Why do I need this twice
			
			try {
				String str1 = working_days_left.getText().toString();
				double dbl = Double.parseDouble(str1);

				sp.putDouble(editor, "work_days_left", dbl);
				editor.commit();
				makeToast(success);

			} catch (Exception e){
				makeToast(e.toString());
			}
			break;	
		}
	}
	
	protected void onPause() {

		super.onPause();
		finish();
	}
	
	//Simple class that makes a popup (toast) with the activity name the user chose
	public void makeToast(String string){
		Toast.makeText(getApplicationContext(), string, Toast.LENGTH_SHORT).show();
	}

}
