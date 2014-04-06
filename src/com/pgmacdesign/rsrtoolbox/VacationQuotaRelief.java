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

import java.math.BigDecimal;
import java.math.RoundingMode;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//This class calculates quota relief days obtained via personal time or vacation time off and also offers the option to input it into the commissions activity
public class VacationQuotaRelief extends Activity implements View.OnClickListener {

	//Global Variables
	EditText vacation_days;
	TextView tv_quota_relief_percent;
	Button button_calculate_quota_relief, button_jump_to_commissions;
	
	double quota_relief_percent = 0.0;
	
	DatabaseAdmin db = new DatabaseAdmin(this);
	
	//SharedPreferences
	//Make changes to the Prefs File
	public static final String PREFS_NAME = "RSRToolboxData";	
	SharedPrefs sp = new SharedPrefs();
	SharedPreferences settings;
	SharedPreferences.Editor editor;
	
	//Main - When the activity starts
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vacation_quota_relief);
		
		Initialize();

		
	}

	//Initialize Variables
	private void Initialize(){

		vacation_days = (EditText) findViewById(R.id.vacation_quota_relief_enter_days);
		
		button_calculate_quota_relief = (Button) findViewById(R.id.vacation_quota_relief_button_calculate);
		button_jump_to_commissions = (Button) findViewById(R.id.vacation_quota_relief_button_to_commissions);
		
		tv_quota_relief_percent = (TextView) findViewById(R.id.vacation_quota_relief_percent);
		
		button_calculate_quota_relief.setOnClickListener(this);
		button_jump_to_commissions.setOnClickListener(this);
		
		vacation_days.setText("0");  //May need to make this a string, unsure if it will auto-parse an int
		
		//SharedPreferences
		settings = getSharedPreferences(PREFS_NAME, 0);
		editor = settings.edit();
	}
	
	//On Click Method
	@Override
	public void onClick(View arg0) {

		switch (arg0.getId()){
		
		//Calculate the Percent of quota relief they receive
		case R.id.vacation_quota_relief_button_calculate:
			
			//Get info from editText
			String vaca_days_entered_string = vacation_days.getText().toString();
			//Parse into double
			double vaca_days_entered = Double.parseDouble(vaca_days_entered_string);
			
			//Make if statement to confirm they typed a real number (Also one that is in bounds)
			if (vaca_days_entered < 0){
				tv_quota_relief_percent.setText("Please enter a correct number...");
				
			} else if (vaca_days_entered == 0){
				tv_quota_relief_percent.setText("0");
				quota_relief_percent = 0;
				
			} else if (vaca_days_entered > 0 && vaca_days_entered < 3){
				tv_quota_relief_percent.setText("You only get quota relief for 3+ days");
				
			} else if (vaca_days_entered >= 3 && vaca_days_entered < 22){
				quota_relief_percent = (vaca_days_entered/22);
				Double dbl = quota_relief_percent * 100; //So it will be a %
				dbl = round(dbl, 2);
				String str1 = Double.toString(dbl);
				tv_quota_relief_percent.setText(str1 + "%");
				
			} else if (vaca_days_entered >= 22){
				tv_quota_relief_percent.setText("Please enter a correct number...");
				
			}
			
			break;
			
		//Starts the commissions activity and also inputs the information from the relief % discount into the database
		case R.id.vacation_quota_relief_button_to_commissions:
			
			//If there is a quota relief amount, write it to the database
			if (quota_relief_percent == 0){
				sp.putDouble(editor, "vaca_relief", quota_relief_percent);
				editor.commit();
				makeToast("Vacation Relief Entered");
			}
			if (quota_relief_percent > 0){
				try{
					sp.putDouble(editor, "vaca_relief", quota_relief_percent);
					editor.commit();
					makeToast("Vacation Relief Entered");
				} catch (Exception e){
					e.printStackTrace();
				}
			}
			
			//Open activity to commissions
        	try{
	        	makeToast("Opening Commissions");
	        	Intent intent0 = new Intent(arg0.getContext(), Commissions.class);
		        startActivity(intent0);
        	} catch (Exception e) {
        		makeToast(e.toString());
        	}

			break;			
		}
	}
	
	//On Pause
	protected void onPause() {

		super.onPause();
		quota_relief_percent = 0.0;
		finish();
	}
	
	//This method is for rounding numbers
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	
	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	//Simple class that makes a popup (toast) with the activity name the user chose
	public void makeToast(String activityChosen){
		Toast.makeText(getApplicationContext(), activityChosen, Toast.LENGTH_SHORT).show();
	}

}
