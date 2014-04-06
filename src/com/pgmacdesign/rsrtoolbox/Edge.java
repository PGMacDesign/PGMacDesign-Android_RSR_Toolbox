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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class Edge extends Activity implements OnCheckedChangeListener {

	//EditTexts
	EditText edge_full_retail, edge_monthly_cost, edge_2year, edge_1year;
	
	//RadioButtons 
	RadioGroup selection_list;
	RadioButton edge_10gb_or_higher, edge_8gb_or_lower, edge_qualified_plan, edge_other;
	
	double full_retail_cost, monthly_payment, discount, one_year, two_year;
	
	
	//Main - When the activity starts
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edge);
		Initialize();
		
		
	}

	//Initialize Variables
	private void Initialize(){
		one_year = two_year = monthly_payment = discount = full_retail_cost = 0.0;
		
		//EditTexts
		edge_full_retail = (EditText) findViewById(R.id.edge_full_retail);
		edge_monthly_cost = (EditText) findViewById(R.id.edge_monthly_cost);
		edge_1year = (EditText) findViewById(R.id.edge_1year);
		edge_2year = (EditText) findViewById(R.id.edge_2year);
		
		//SetTexts
		edge_full_retail.setText("0");
		edge_monthly_cost.setText("0");
		edge_1year.setText("0");
		edge_2year.setText("0");
		
		//Radio Buttons -- Do not need these as radio group covers it
		//edge_10gb_or_higher = (RadioButton) findViewById(R.id.edge_10gb_or_higher);
		//edge_8gb_or_lower = (RadioButton) findViewById(R.id.edge_8gb_or_lower);
		//edge_qualified_plan = (RadioButton) findViewById(R.id.edge_qualified_plan);
		//edge_other = (RadioButton) findViewById(R.id.edge_other);
		selection_list = (RadioGroup) findViewById(R.id.edge_price_plans);
		selection_list.setOnCheckedChangeListener(this);
		
	}
	

	protected void onPause() {

		super.onPause();
		finish();
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		switch (arg1){
		
		case R.id.edge_10gb_or_higher:
			discount = 25.00;
			CalculateNumbers(discount);
			edge_monthly_cost.setText(Double.toString(monthly_payment));
			edge_1year.setText(Double.toString(one_year));
			edge_2year.setText(Double.toString(two_year));
			
			break;
			
		case R.id.edge_8gb_or_lower:
			discount = 10.00;
			CalculateNumbers(discount);
			edge_monthly_cost.setText(Double.toString(monthly_payment));
			edge_1year.setText(Double.toString(one_year));
			edge_2year.setText(Double.toString(two_year));
			
			break;
			
		case R.id.edge_qualified_plan:
			discount = 10.00;
			CalculateNumbers(discount);
			edge_monthly_cost.setText(Double.toString(monthly_payment));
			edge_1year.setText(Double.toString(one_year));
			edge_2year.setText(Double.toString(two_year));
			
			break;
			
		case R.id.edge_other:
			discount = 0.0;
			CalculateNumbers(discount);
			edge_monthly_cost.setText(Double.toString(monthly_payment));
			edge_1year.setText(Double.toString(one_year));
			edge_2year.setText(Double.toString(two_year));
			
			break;
		}
			
		
	}
	
	public void CalculateNumbers(double input_discount){
		
		//These specifically check to make sure that the edittext fields have a value
		if (edge_full_retail.getText().toString().equals("")){
			//
		} else {
			full_retail_cost = Double.parseDouble(edge_full_retail.getText().toString());
		}
		
		double tempMonthlyPayment = full_retail_cost / 24;
		
		monthly_payment = tempMonthlyPayment - input_discount;
		one_year = monthly_payment * 12;
		two_year = monthly_payment * 24;
		
		//Round the numbers
		monthly_payment = round(monthly_payment, 2);
		one_year = round(one_year, 2);
		two_year = round(two_year, 2);
	}

	//This method is for rounding numbers
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	
	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
}
