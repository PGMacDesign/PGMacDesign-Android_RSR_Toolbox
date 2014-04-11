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
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//This class asks for user input to determine the accessory revenue deficit to hit certain ard goals
public class RevenueDeficit extends Activity implements View.OnClickListener {

	//EditTexts
	EditText revenue_deficit_ard, revenue_deficit_devices, revenue_deficit_80, revenue_deficit_90, revenue_deficit_100;
	
	//Buttons
	Button revenue_deficit_calculate;
	
	//Ints and Doubles
	double current_revenue, rev_to_80, rev_to_90, rev_to_100;
	int devices_sold;
	String s_rev_to_80, s_rev_to_90, s_rev_to_100;
	
	//Main - When the activity starts
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.revenue_deficit);
		Initialize();

	}

	//Initialize Variables
	private void Initialize(){
		//Edit Texts that user will enter into
		revenue_deficit_ard = (EditText) findViewById(R.id.revenue_deficit_ard);
		revenue_deficit_devices = (EditText) findViewById(R.id.revenue_deficit_devices);
		
		//Edit Texts I will set with numbers obtained
		revenue_deficit_80 = (EditText) findViewById(R.id.revenue_deficit_80);
		revenue_deficit_90 = (EditText) findViewById(R.id.revenue_deficit_90);;
		revenue_deficit_100 = (EditText) findViewById(R.id.revenue_deficit_100);;
		
		//Button
		revenue_deficit_calculate = (Button) findViewById(R.id.revenue_deficit_calculate);
		revenue_deficit_calculate.setOnClickListener(this);
		
		//Set default EditTexts
		revenue_deficit_ard.setText("0");
		revenue_deficit_devices.setText("0");
		revenue_deficit_80.setText("0");
		revenue_deficit_90.setText("0");
		revenue_deficit_100.setText("0");
	}
	
	//On Click Method
	@Override
	public void onClick(View arg0) {

		switch (arg0.getId()){
		
		//When button is pressed, CalculateDeficit is run and numbers are posted
		case R.id.revenue_deficit_calculate:
			CalculateDeficit();
			makeToast("Calculating");
			revenue_deficit_80.setText(s_rev_to_80);
			revenue_deficit_90.setText(s_rev_to_90);
			revenue_deficit_100.setText(s_rev_to_100);
			break;
		}

	}
	
	//Performs calculations using input data from EditTexts.
	public void CalculateDeficit(){
		rev_to_100 = rev_to_90 = rev_to_80 = current_revenue = 0.0;
		devices_sold = 0;
		
		//Calculate info from EditText Fields. Check if valid input
		if (revenue_deficit_ard.getText().toString().equals("")){
			//
		} else {
			current_revenue = Double.parseDouble(revenue_deficit_ard.getText().toString());
		}
		
		if (revenue_deficit_devices.getText().toString().equals("")){
			//
		} else {
			devices_sold = Integer.parseInt(revenue_deficit_devices.getText().toString());
		}
		
		//Calculate the deficit and put into variables
		rev_to_80 = (devices_sold * 80)-(devices_sold * current_revenue);
		rev_to_90 = (devices_sold * 90)-(devices_sold * current_revenue);
		rev_to_100 = (devices_sold * 100)-(devices_sold * current_revenue);
		
		//Round the numbers to 2 decimal places (Cents)
		rev_to_80 = round(rev_to_80, 2);
		rev_to_90 = round(rev_to_90, 2);
		rev_to_100 = round(rev_to_100, 2);
		
		//If they have already hit $80 in rev
		if (rev_to_80 > 0){
			s_rev_to_80 = Double.toString(rev_to_80);
		} else {
			s_rev_to_80 = "Great Job!";
		}
		
		//If they have already hit $90 in rev
		if (rev_to_90 > 0){
			s_rev_to_90 = Double.toString(rev_to_90);
		} else {
			s_rev_to_90 = "Great Job!";
		}
		
		//If they have already hit $100 in rev
		if (rev_to_100 > 0){
			s_rev_to_100 = Double.toString(rev_to_100);
		} else {
			s_rev_to_100 = "Great Job!";
		}				
		
	}
	
	//This method is for rounding numbers
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	
	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	//Simple class that makes a popup (toast) with text
	public void makeToast(String string){
		Toast.makeText(getApplicationContext(), string, Toast.LENGTH_SHORT).show();
	}
	
	//On Pause method
	protected void onPause() {

		super.onPause();
		//finish();
	}

}
