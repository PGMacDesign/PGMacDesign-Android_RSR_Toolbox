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
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//This class calculates quota relief days obtained via personal time or vacation time off
public class VacationQuotaRelief extends Activity implements View.OnClickListener {

	//Global Variables
	EditText vacation_days;
	TextView quota_relief_percent;
	Button button_calculate_quota_relief, button_jump_to_commissions;
	
	//Main - When the activity starts
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vacation_quota_relief);
		Initialize();
		
		vacation_days.setText(0);  //May need to make this a string, unsure if it will auto-parse an int

		
	}

	//Initialize Variables
	private void Initialize(){
		
		vacation_days = (EditText) findViewById(R.id.vacation_quota_relief_enter_days);
		
		button_calculate_quota_relief = (Button) findViewById(R.id.vacation_quota_relief_button_calculate);
		button_jump_to_commissions = (Button) findViewById(R.id.vacation_quota_relief_button_to_commissions);
		
		quota_relief_percent = (TextView) findViewById(R.id.vacation_quota_relief_percent);
		
		button_calculate_quota_relief.setOnClickListener(this);
		button_jump_to_commissions.setOnClickListener(this);
	}
	
	//On Click Method
	@Override
	public void onClick(View arg0) {

		switch (arg0.getId()){
		
		//Calculate the Percent of quota relief they receive
		case R.id.vacation_quota_relief_button_calculate:
			
			//Add if >21 and if <0 statement for calculation
			//Check to make sure it is a number (should be?)
			
			break;
			
		//Starts the commissions activity and also inputs the information from the relief % discount into the database
		case R.id.vacation_quota_relief_button_to_commissions:
			
			//Input data to database
			//If statement to check if there is information in the (quota_relief_percent) field, try to enter it
			//Also add information from (vacation_days) field to database. Another if statement here too
			
			//Open activity to commissions. 
			
			
			
			break;			
		}
	}
	
	//On Pause
	protected void onPause() {

		super.onPause();
		finish();
	}

}
