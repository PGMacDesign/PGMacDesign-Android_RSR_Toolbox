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
import android.widget.TextView;

//Commissions is the class that accesses all data from the database and returns calculations to return values
public class Commissions extends Activity implements View.OnClickListener {

	//Text views that will be filled with the data from various commissions info linked from the rest of the app
	TextView working_days_left, at_risk, upgrade_quota, gg_quota, gg_current, charge_backs, net_activations, 
	gg_multiplier, gg_run_rate, sales_dollars_quota, current_sales_dollars, sales_dollars_multiplier, vaca_relief,
	strategic_pt_quota, strategic_pt_current, strategic_acc_quota, strategic_acc_current, strategic_multiplier, 
	spiffs, final_commissions, final_commissions_plus_2_a_day, to_get_to_a_1dot4, daily_to_get_to_a_1dot4, 
	to_get_to_a_1dot6, daily_to_get_to_a_1dot6 ;
	
	//Object for accessing the DatabaseAdmin class
	DatabaseAdmin db = new DatabaseAdmin(this);
	
	//Main - When the activity starts
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.commissions);
		Initialize();
		
		//Fill the values in the text views
		Get_ALL_DATA();
		
	}

	//Initialize Variables
	private void Initialize(){
		//Initialize the text views to their respective IDs
		working_days_left = (TextView) findViewById(R.id.commissions_text_view_working_days_left);
		at_risk = (TextView) findViewById(R.id.commissions_text_view_at_risk);
		upgrade_quota = (TextView) findViewById(R.id.commissions_text_view_upgrade_quota);
		gg_quota = (TextView) findViewById(R.id.commissions_text_view_gg_quota);
		gg_current = (TextView) findViewById(R.id.commissions_text_view_gg_current);
		charge_backs = (TextView) findViewById(R.id.commissions_text_view_charge_backs);
		net_activations = (TextView) findViewById(R.id.commissions_text_view_net_gains);
		gg_multiplier = (TextView) findViewById(R.id.commissions_text_view_gg_multiplier);
		gg_run_rate = (TextView) findViewById(R.id.commissions_text_view_gg_run_rate);
		sales_dollars_quota = (TextView) findViewById(R.id.commissions_text_view_sales_dollars_quota);
		current_sales_dollars = (TextView) findViewById(R.id.commissions_text_view_sales_dollars_current);
		sales_dollars_multiplier = (TextView) findViewById(R.id.commissions_text_view_sales_dollars_multiplier);
		vaca_relief = (TextView) findViewById(R.id.commissions_text_view_vaca_relief);
		strategic_pt_quota = (TextView) findViewById(R.id.commissions_text_view_pt_quota);
		strategic_pt_current = (TextView) findViewById(R.id.commissions_text_view_pt_current);
		//Strategic pt rank is here in string array
		strategic_acc_quota = (TextView) findViewById(R.id.commissions_text_view_acc_quota);
		strategic_acc_current = (TextView) findViewById(R.id.commissions_text_view_acc_current);
		//Strategic acc rank is here in string array
		strategic_multiplier = (TextView) findViewById(R.id.commissions_text_view_strategic_multiplier);
		spiffs = (TextView) findViewById(R.id.commissions_text_view_spiffs);
		final_commissions = (TextView) findViewById(R.id.commissions_text_view_final_commissions);
		final_commissions_plus_2_a_day = (TextView) findViewById(R.id.commissions_text_view_final_commissions_plus_two_a_day);
		
		/*
		 //Will add this in eventually 
		to_get_to_a_1dot4 = (TextView) findViewById(R.id.commissions_text_view_to_get_to_a_1dot4);
		daily_to_get_to_a_1dot4 = (TextView) findViewById(R.id.commissions_text_view_daily_to_get_to_a_1dot4);
		to_get_to_a_1dot6 = (TextView) findViewById(R.id.commissions_text_view_to_get_to_a_1dot6);
		daily_to_get_to_a_1dot6 = (TextView) findViewById(R.id.commissions_text_view_daily_to_get_to_a_1dot6);
		*/
		
	}
	
	//Returns calculations via values stored in database queries
	public void Get_working_days_left(){
		String result = "";
		
		try{
		//Query the database for the numbers needed and set them to variables
			result = db.getData(db.COLUMNS[0]);
		} catch (Exception e){
			result = e.toString();
		}	
		working_days_left.setText(result);
	}
	
	//Returns calculations via values stored in database queries
	public void Get_at_risk(){
		String result = "";
		
		try{
		//Query the database for the numbers needed and set them to variables
			result = db.getData(db.COLUMNS[1]);
		} catch (Exception e){
			result = e.toString();
		}	
		at_risk.setText(result);
	}
	
	//Returns calculations via values stored in database queries
	public void Get_upgrade_quota(){
		String result = "";
		
		try{
		//Query the database for the numbers needed and set them to variables
			result = db.getData(db.COLUMNS[2]);
		} catch (Exception e){
			result = e.toString();
		}	
		upgrade_quota.setText(result);
	}	
	
	//Returns calculations via values stored in database queries
	public void Get_gg_quota(){
		String result = "";
		
		try{
		//Query the database for the numbers needed and set them to variables
			result = db.getData(db.COLUMNS[3]);
		} catch (Exception e){
			result = e.toString();
		}	
		gg_quota.setText(result);
	}
	
	//Returns calculations via values stored in database queries
	public void Get_gg_current(){
		String result = "";
		
		try{
		//Query the database for the numbers needed and set them to variables
			result = db.getData(db.COLUMNS[4]);
		} catch (Exception e){
			result = e.toString();
		}	
		gg_current.setText(result);
	}
	
	//Returns calculations via values stored in database queries
	public void Get_charge_backs(){
		String result = "";
		
		try{
		//Query the database for the numbers needed and set them to variables
			result = db.getData(db.COLUMNS[5]);
		} catch (Exception e){
			result = e.toString();
		}	
		charge_backs.setText(result);
	}	
	
	//Returns calculations via values stored in database queries
	public void Get_net_activations(){ //Result written to db
		String result = "";
		
		try{
		//Query the database for the numbers needed and set them to variables
			int netGs= (Integer.parseInt(db.getData(db.COLUMNS[4]))) - (Integer.parseInt(db.getData(db.COLUMNS[5])));
			
			result = Integer.toString(netGs);
			
			db.InsertData("net_gains", result);
			db.close();
			
		} catch (Exception e){
			result = e.toString();
		}	
		net_activations.setText(result);
	}
	
	//Returns calculations via values stored in database queries
	public void Get_gg_multiplier(){ //Result written to db
		String result = "";
		
		try{
		//Query the database for the numbers needed and set them to variables
			//Call GGMultiplier method to get result
			//Get values at gg_actual and gg_quota from database, parse into doubles
			//Perform calculations and then parse back to string. return
			GGMultiplier gg = new GGMultiplier();
			double input;
			
			double netGs= (Double.parseDouble(db.getData(db.COLUMNS[4]))) - (Double.parseDouble(db.getData(db.COLUMNS[5])));
			double gg_quota = Double.parseDouble(db.getData(db.COLUMNS[3]));
			
			input = netGs / gg_quota;
			
			double dresult = gg.GetGGMultiplier(input);
			
			result = Double.toString(dresult);
			
			db.InsertData("gg_multiplier", result);
			db.close();
			
		} catch (Exception e){
			result = e.toString();
		}	
		gg_multiplier.setText(result);
	}
	
	//Returns calculations via values stored in database queries
	public void Get_gg_run_rate(){ //Result written to db
		String result = "";

		try{
			//Net gains
			int netGs= (Integer.parseInt(db.getData(db.COLUMNS[4]))) - (Integer.parseInt(db.getData(db.COLUMNS[5]))); //Net Gains Current
			//Number of days worked already
			int daysWorked = 22-(Integer.parseInt(db.getData(db.COLUMNS[0])));
			//Run rate
			int runRate = ((22 * netGs)/daysWorked);
			
			//Convert back to string
			result = Integer.toString(runRate);
			
			db.InsertData("gg_run_rate", result);
			db.close();
			
		} catch (Exception e){
			result = e.toString();
		}	
		gg_run_rate.setText(result);
	}	
	
	//Returns calculations via values stored in database queries
	public void Get_sales_dollars_quota(){
		String result = "";
		
		try{
		//Query the database for the numbers needed and set them to variables
			result = db.getData(db.COLUMNS[9]);
		} catch (Exception e){
			result = e.toString();
		}	
		sales_dollars_quota.setText(result);
	}
	
	//Returns calculations via values stored in database queries
	public void Get_current_sales_dollars(){
		String result = "";
		
		try{
		//Query the database for the numbers needed and set them to variables
			result = db.getData(db.COLUMNS[10]);
		} catch (Exception e){
			result = e.toString();
		}	
		current_sales_dollars.setText(result);
	}
	
	//Returns calculations via values stored in database queries
	public void Get_sales_dollars_multiplier(){ //Result written to db
		String result = "";
		
		try{
		//Query the database for the numbers needed and set them to variables
			double sdMultiplier= (Double.parseDouble(db.getData(db.COLUMNS[10]))) / (Double.parseDouble(db.getData(db.COLUMNS[9])));
			
			result = Double.toString(sdMultiplier);
			
			db.InsertData("sales_dollars_quota", result);
			db.close();
			
		} catch (Exception e){
			result = e.toString();
		}	
		sales_dollars_multiplier.setText(result);
	}	
	
	//Returns calculations via values stored in database queries
	public void Get_vaca_relief(){  //STILL NEED TO WRITE DATA FROM VACA RELIEF CALCULATOR
		String result = "";
		
		try{
		//Query the database for the numbers needed and set them to variables
			result = db.getData(db.COLUMNS[12]);
		} catch (Exception e){
			result = e.toString();
		}	
		vaca_relief.setText(result);
	}
	
	//Returns calculations via values stored in database queries
	public void Get_strategic_pt_quota(){
		String result = "";
		
		try{
		//Query the database for the numbers needed and set them to variables
			
			//Upgrade_quota + GG_quota
			int pt_quota = Integer.parseInt(db.getData(db.COLUMNS[2])) + Integer.parseInt(db.getData(db.COLUMNS[3]));
			result = Integer.toString(pt_quota);
		} catch (Exception e){
			result = e.toString();
		}	
		strategic_pt_quota.setText(result);
	}
	
	//Returns calculations via values stored in database queries
	public void Get_strategic_pt_current(){
		String result = "";
		
		try{
		//Query the database for the numbers needed and set them to variables
			result = db.getData(db.COLUMNS[14]);
		} catch (Exception e){
			result = e.toString();
		}	
		strategic_pt_current.setText(result);
	}	
	
	//Returns calculations via values stored in database queries
	public void Get_strategic_acc_quota(){
		String result = "";
		
		try{
		//Query the database for the numbers needed and set them to variables
			result = db.getData(db.COLUMNS[16]);
		} catch (Exception e){
			result = e.toString();
		}	
		strategic_acc_quota.setText(result);
	}
	
	//Returns calculations via values stored in database queries
	public void Get_strategic_acc_current(){
		String result = "";
		
		try{
		//Query the database for the numbers needed and set them to variables
			result = db.getData(db.COLUMNS[17]);
		} catch (Exception e){
			result = e.toString();
		}	
		strategic_acc_current.setText(result);
	}
	
	//Returns calculations via values stored in database queries
	public void Get_strategic_multiplier(){  //Result written to db
		String result = "";
		StrategicMultiplier2 sm = new StrategicMultiplier2(); //Result written to db
		
		try{
			//Pull data from Strategic Multiplier class
			double result1 = sm.GetStrategicMultiplier();
			
			result = Double.toString(result1);
			//Write data to database
			db.InsertData("strategic_multiplier", result);
			db.close();
			
		} catch (Exception e){
			result = e.toString();
		}	
		strategic_multiplier.setText(result);
	}	
	
	//Returns calculations via values stored in database queries
	public void Get_spiffs(){
		String result = "";
		
		try{
		//Query the database for the numbers needed and set them to variables
			result = db.getData(db.COLUMNS[20]);
		} catch (Exception e){
			result = e.toString();
		}	
		spiffs.setText(result);
	}
	
	//Returns calculations via values stored in database queries
	public void Get_final_commissions(){ //Result written to db
		String result = "";
		StrategicMultiplier2 sm = new StrategicMultiplier2();
		GGMultiplier gg = new GGMultiplier();
		
		try{
			//Uber long calculation. Separated out to prevent any issues. At risk = 1417
			//Commissions formula: final = (1417 * strategic multiplier * GG multiplier * sales dollars multiplier) + spiffs 
			//Setup all variables via pulls from database
			double strategicMultiplier = sm.GetStrategicMultiplier();
			double ggpercent = ((Double.parseDouble(db.getData(db.COLUMNS[4]))) - (Double.parseDouble(db.getData(db.COLUMNS[5])))) / (Double.parseDouble(db.getData(db.COLUMNS[9])));
			double ggMultiplier = gg.GetGGMultiplier(ggpercent);
			double salesDollarsMultiplier = (Double.parseDouble(db.getData(db.COLUMNS[10]))) / (Double.parseDouble(db.getData(db.COLUMNS[9])));
			double spiffs = Double.parseDouble(db.COLUMNS[20]);
			//Uber calculation time
			double finalCheck = (1417.00 * strategicMultiplier * ggMultiplier * salesDollarsMultiplier) + spiffs;
			result = Double.toString(finalCheck);
			
			//Write result to database
			db.InsertData("final_commissions", result);
			db.close();

		} catch (Exception e){
			result = e.toString();
		}	
		final_commissions.setText(result);
	}
	
	//Returns calculations via values stored in database queries
	public void Get_final_commissions_plus_2_a_day(){
		String result = "";
		StrategicMultiplier2 sm = new StrategicMultiplier2();
		GGMultiplier gg = new GGMultiplier();
		
		try{
			//Uber long calculation. Separated out to prevent any issues. At risk = 1417
			//Commissions formula: final = (1417 * strategic multiplier * GG multiplier * sales dollars multiplier) + spiffs 
			//Setup all variables via pulls from database
			double strategicMultiplier = sm.GetStrategicMultiplier();
			double twoMoreADay = 2*((Double.parseDouble(db.getData(db.COLUMNS[0]))));
			double ggpercent = ((twoMoreADay + (Double.parseDouble(db.getData(db.COLUMNS[4])))) - (Double.parseDouble(db.getData(db.COLUMNS[5])))) / (Double.parseDouble(db.getData(db.COLUMNS[9])));
			double ggMultiplier = gg.GetGGMultiplier(ggpercent);
			double salesDollarsMultiplier = (Double.parseDouble(db.getData(db.COLUMNS[10]))) / (Double.parseDouble(db.getData(db.COLUMNS[9])));
			double spiffs = Double.parseDouble(db.COLUMNS[20]);
			//Uber calculation time
			double finalCheck = (1417.00 * strategicMultiplier * ggMultiplier * salesDollarsMultiplier) + spiffs;
			result = Double.toString(finalCheck);

		} catch (Exception e){
			result = e.toString();
		}	
		final_commissions.setText(result);
	}
	
	/*
	//Returns calculations via values stored in database queries
	public void Get_to_get_to_a_1dot4(){
		String result = "";
		
		try{
		//Query the database for the numbers needed and set them to variables
			result = db.getData(db.COLUMNS[0]);
		} catch (Exception e){
			result = e.toString();
		}	
		working_days_left.setText(result);
	}
	
	//Returns calculations via values stored in database queries
	public void Get_daily_to_get_to_a_1dot4(){
		String result = "";
		
		try{
		//Query the database for the numbers needed and set them to variables
			result = db.getData(db.COLUMNS[0]);
		} catch (Exception e){
			result = e.toString();
		}	
		working_days_left.setText(result);
	}
	
	//Returns calculations via values stored in database queries
	public void Get_to_get_to_a_1dot6(){
		String result = "";
		
		try{
		//Query the database for the numbers needed and set them to variables
			result = db.getData(db.COLUMNS[0]);
		} catch (Exception e){
			result = e.toString();
		}	
		working_days_left.setText(result);
	}	

	//Returns calculations via values stored in database queries
	public void Get_daily_to_get_to_a_1dot6(){

		String result = "";
		
		try{
		//Query the database for the numbers needed and set them to variables
			result = db.getData(db.COLUMNS[0]);
		} catch (Exception e){
			result = e.toString();
		}	
		working_days_left.setText(result);
	}
	
	*/
	
	//Get ALL data values assigned to editText fields
	public void Get_ALL_DATA(){
		Get_working_days_left();
		Get_at_risk();
		Get_upgrade_quota();
		Get_gg_quota();
		Get_gg_current();
		Get_charge_backs();
		Get_net_activations();
		Get_gg_multiplier();
		Get_gg_run_rate();
		Get_sales_dollars_quota();
		Get_current_sales_dollars();
		Get_sales_dollars_multiplier();
		Get_vaca_relief();
		Get_strategic_pt_quota();
		Get_strategic_pt_current();
		Get_strategic_acc_quota();
		Get_strategic_acc_current();
		//Get_strategic_multiplier(); //Strategic Multiplier is causing problems
		Get_spiffs();
		//Get_final_commissions(); //Strategic Multiplier is causing problems
		//Get_final_commissions_plus_2_a_day(); //Strategic Multiplier is causing problems
		
		
		
		
		
		/* Will add this in eventually
		Get_to_get_to_a_1dot4();
		Get_daily_to_get_to_a_1dot4();
		Get_to_get_to_a_1dot6();
		Get_daily_to_get_to_a_1dot6();
		*/
	}
	
	//On Click Method
	@Override
	public void onClick(View arg0) {
		//I may include a link here to other activities at some point
	}
	
	protected void onPause() {
		super.onPause();
		finish();
	}

}
