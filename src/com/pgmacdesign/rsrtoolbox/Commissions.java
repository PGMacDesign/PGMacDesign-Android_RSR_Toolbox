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
import android.widget.EditText;

//Commissions is the class that accesses all data from the database and returns calculations to return values
public class Commissions extends Activity implements View.OnClickListener {

	//Text views that will be filled with the data from various commissions info linked from the rest of the app
	EditText working_days_left, at_risk, upgrade_quota, gg_quota, gg_current, charge_backs, net_activations, 
	gg_multiplier, gg_run_rate, sales_dollars_quota, current_sales_dollars, sales_dollars_multiplier, vaca_relief,
	strategic_pt_quota, strategic_pt_current, strategic_acc_quota, strategic_acc_current, strategic_multiplier, 
	spiffs, final_commissions, final_commissions_plus_2_a_day, to_get_to_a_1dot4, daily_to_get_to_a_1dot4, 
	to_get_to_a_1dot6, daily_to_get_to_a_1dot6 ;
	
	//Make changes to the Prefs File
	public static final String PREFS_NAME = "StoredCommissionsData";	
	SharedPrefs sp = new SharedPrefs();
	SharedPreferences settings;
	SharedPreferences.Editor editor;
	
	//Main - When the activity starts
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.commissions);
		
		Initialize();
		
		//Fill the values in the text views
		Get_ALL_DATA();
		
		settings = getSharedPreferences(PREFS_NAME, 0);
		
		/*EXAMPLE
		 
		double dbl2 = sp.getDouble(settings, "sales_dollars", 0.1);
		dbl2*=2.12;
		working_days_left.setText(Double.toString(dbl2));
		
		 */
		
	}

	//Initialize Variables
	private void Initialize(){
		//Initialize the text views to their respective IDs
		working_days_left = (EditText) findViewById(R.id.commissions_edit_text_working_days_left);
		at_risk = (EditText) findViewById(R.id.commissions_edit_text_at_risk);
		upgrade_quota = (EditText) findViewById(R.id.commissions_edit_text_upgrade_quota);
		gg_quota = (EditText) findViewById(R.id.commissions_edit_text_gg_quota);
		gg_current = (EditText) findViewById(R.id.commissions_edit_text_gg_current);
		charge_backs = (EditText) findViewById(R.id.commissions_edit_text_charge_backs);
		net_activations = (EditText) findViewById(R.id.commissions_edit_text_net_gains);
		gg_multiplier = (EditText) findViewById(R.id.commissions_edit_text_gg_multiplier);
		gg_run_rate = (EditText) findViewById(R.id.commissions_edit_text_gg_run_rate);
		sales_dollars_quota = (EditText) findViewById(R.id.commissions_edit_text_sales_dollars_quota);
		current_sales_dollars = (EditText) findViewById(R.id.commissions_edit_text_sales_dollars_current);
		sales_dollars_multiplier = (EditText) findViewById(R.id.commissions_edit_text_sales_dollars_multiplier);
		vaca_relief = (EditText) findViewById(R.id.commissions_edit_text_vaca_relief);
		strategic_pt_quota = (EditText) findViewById(R.id.commissions_edit_text_pt_quota);
		strategic_pt_current = (EditText) findViewById(R.id.commissions_edit_text_pt_current);
		//Strategic pt rank is here in string array
		strategic_acc_quota = (EditText) findViewById(R.id.commissions_edit_text_acc_quota);
		strategic_acc_current = (EditText) findViewById(R.id.commissions_edit_text_acc_current);
		//Strategic acc rank is here in string array
		strategic_multiplier = (EditText) findViewById(R.id.commissions_edit_text_strategic_multiplier);
		spiffs = (EditText) findViewById(R.id.commissions_edit_text_spiffs);
		final_commissions = (EditText) findViewById(R.id.commissions_edit_text_final_commissions);
		final_commissions_plus_2_a_day = (EditText) findViewById(R.id.commissions_edit_text_final_commissions_plus_two_a_day);
		
		/*
		 //Will add this in eventually 
		to_get_to_a_1dot4 = (EditText) findViewById(R.id.commissions_edit_text_to_get_to_a_1dot4);
		daily_to_get_to_a_1dot4 = (EditText) findViewById(R.id.commissions_edit_text_daily_to_get_to_a_1dot4);
		to_get_to_a_1dot6 = (EditText) findViewById(R.id.commissions_edit_text_to_get_to_a_1dot6);
		daily_to_get_to_a_1dot6 = (EditText) findViewById(R.id.commissions_edit_text_daily_to_get_to_a_1dot6);
		*/
		
		//Shared Preferences
		settings = getSharedPreferences(PREFS_NAME, 0);
		editor = settings.edit();
		
	}
	
	//Gets the working days left from shared preferences
	//01
	public void Get_working_days_left(){
		Double dbl = 0.0;
		String result = Double.toString(dbl);
		
		try{	
			dbl = sp.getDouble(settings, "work_days_left", 0.0);
			result = Double.toString(dbl);
			working_days_left.setText(result);	
		} catch (Exception e){
			String sresult = e.toString();
		}	
		working_days_left.setText(result);
	}

	//Gets the at risk from shared preferences
	//02
	public void Get_at_risk(){
		Double dbl = 0.0;
		String result = Double.toString(dbl);
		
		try{
			dbl = sp.getDouble(settings, "at_risk", 0.0);
			result = Double.toString(dbl);
		} catch (Exception e){
			String sresult = e.toString();
		}	
		at_risk.setText(result);
	}
	
	//Gets the upgrade quota from shared preferences
	//03
	public void Get_upgrade_quota(){
		Double dbl = 0.0;
		String result = Double.toString(dbl);
		
		try{
			dbl = sp.getDouble(settings, "up_quota", 0.0);
			result = Double.toString(dbl);
		} catch (Exception e){
			String sresult = e.toString();
		}	
		upgrade_quota.setText(result);
	}	
	
	//Gets the GG quota from the shared preferences
	//04
	public void Get_gg_quota(){
		Double dbl = 0.0;
		String result = Double.toString(dbl);
		
		try{
			dbl = sp.getDouble(settings, "gg_quota", 0.0);
			result = Double.toString(dbl);
		} catch (Exception e){
			String sresult = e.toString();
		}	
		gg_quota.setText(result);
	}
	
	//Gets the GG Current from the shared preferences
	//05
	public void Get_gg_current(){
		Double dbl = 0.0;
		String result = Double.toString(dbl);
		
		try{
			dbl = sp.getDouble(settings, "gg_current", 0.0);
			result = Double.toString(dbl);
		} catch (Exception e){
			String sresult = e.toString();
		}	
		gg_current.setText(result);
	}
	
	//Gets the GG charge backs from the shared preferences
	//06
	public void Get_charge_backs(){
		Double dbl = 0.0;
		String result = Double.toString(dbl);
		
		try{
			dbl = sp.getDouble(settings, "charge_backs", 0.0);
			result = Double.toString(dbl);
		} catch (Exception e){
			String sresult = e.toString();
		}	
		charge_backs.setText(result);
	}	
	
	//Gets the Net Activations by performing calculations from results obtained via shared preferences
	//07
	public void Get_net_activations(){ //Result written to stored preferences
		Double dbl = 0.0;
		String result = Double.toString(dbl);
		
		try{
		//Query the database for the numbers needed and set them to variables
			dbl = (sp.getDouble(settings, "gg_current", 0.0)) - (sp.getDouble(settings, "charge_backs", 0.0));
			sp.putDouble(editor, "net_gains", dbl);
			result = Double.toString(dbl);
		} catch (Exception e){
			String sresult = e.toString();
		}	
		net_activations.setText(result);
	}
	
	//Gets the GG Multiplier by performing calculations from results obtained via shared preferences and the GGMultiplier Class
	//08
	public void Get_gg_multiplier(){ //Result written to stored preferences
		Double dbl = 0.0;
		String result = Double.toString(dbl);
		
		try{
			GGMultiplier gg = new GGMultiplier();
			double input;
			double netGs = (sp.getDouble(settings, "gg_current", 0.0)) - (sp.getDouble(settings, "charge_backs", 0.0));
			double ggQuota = sp.getDouble(settings, "gg_quota", 0.0);
			
			input = netGs / ggQuota;
			
			dbl = gg.GetGGMultiplier(input);
			
			sp.putDouble(editor, "gg_multiplier", dbl);
			result = Double.toString(dbl);
		} catch (Exception e){
			String sresult = e.toString();
		}	
		gg_multiplier.setText(result);
	}
	
	//Gets the GG run rate by performing calculations from results obtained via shared preferences
	//09
	public void Get_gg_run_rate(){ //Result written to stored preferences
		Double dbl = 0.0;
		String result = Double.toString(dbl);

		try{
			double netGs = (sp.getDouble(settings, "gg_current", 0.0)) - (sp.getDouble(settings, "charge_backs", 0.0));
			double daysWorked = 22.00-(sp.getDouble(settings, "work_days_left", 0.0)); //Number of days worked already
			double runRate = ((22 * netGs)/daysWorked); //Run rate
			dbl = runRate;
			
			sp.putDouble(editor, "gg_run_rate", dbl);
			result = Double.toString(dbl);
		} catch (Exception e){
			String sresult = e.toString();
		}	
		gg_run_rate.setText(result);
	}	
	
	//Gets the sales dollars quota from the shared preferences
	//10
	public void Get_sales_dollars_quota(){
		Double dbl = 0.0;
		String result = Double.toString(dbl);
		
		try{
			
			dbl = sp.getDouble(settings, "sales_dollars_quota", 0.0);
			result = Double.toString(dbl);
		} catch (Exception e){
			String sresult = e.toString();
		}	
		sales_dollars_quota.setText(result);
	}
	
	//Gets the current sales dollars from the shared preferences
	//11
	public void Get_current_sales_dollars(){
		Double dbl = 0.0;
		String result = Double.toString(dbl);
		
		try{
			dbl = sp.getDouble(settings, "sales_dollars_current", 0.0);
			result = Double.toString(dbl);
		} catch (Exception e){
			String sresult = e.toString();
		}	
		current_sales_dollars.setText(result);
	}
	
	//Gets the sales dollars multiplier by performing calculations from results obtained via shared preferences
	//12
	public void Get_sales_dollars_multiplier(){ //Result written to stored preferences
		Double dbl = 0.0;
		String result = Double.toString(dbl);
		
		try{
			double sdMultiplier = (sp.getDouble(settings, "sales_dollars_current", 0.0)) / (sp.getDouble(settings, "sales_dollars_quota", 0.0));
			dbl = sdMultiplier;
			
			sp.putDouble(editor, "sales_dollars_multiplier", dbl);
			result = Double.toString(dbl);
		} catch (Exception e){
			String sresult = e.toString();
		}	
		sales_dollars_multiplier.setText(result);
	}	
	
	//Gets the vacation relief percent from the shared preferences
	//13
	public void Get_vaca_relief(){  
		Double dbl = 0.0;
		String result = Double.toString(dbl);
		
		try{
		//Query the database for the numbers needed and set them to variables
			dbl = sp.getDouble(settings, "vaca_relief", 0.0);
			result = Double.toString(dbl);
		} catch (Exception e){
			String sresult = e.toString();
		}	
		vaca_relief.setText(result);
	}
	
	//Gets the strategic pull-through quota by performing calculations from results obtained via shared preferences
	//14
	public void Get_strategic_pt_quota(){
		Double dbl = 0.0;
		String result = Double.toString(dbl);
		
		try{
			//Upgrade_quota + GG_quota
			dbl = (sp.getDouble(settings, "up_quota", 0.0)) + (sp.getDouble(settings, "gg_quota", 0.0));
			
			sp.putDouble(editor, "pt_quota", dbl);
			result = Double.toString(dbl);
		} catch (Exception e){
			String sresult = e.toString();
		}	
		strategic_pt_quota.setText(result);
	}
	
	//Gets the strategic pull-through current value from the shared preferences
	//15
	public void Get_strategic_pt_current(){
		Double dbl = 0.0;
		String result = Double.toString(dbl);
		
		try{
			dbl = sp.getDouble(settings, "pt_current", 0.0);
			result = Double.toString(dbl);
		} catch (Exception e){
			String sresult = e.toString();
		}	
		strategic_pt_current.setText(result);
	}	
	
	//Gets the strategic accessory quota from the shared preferences
	//16
	public void Get_strategic_acc_quota(){
		Double dbl = 0.0;
		String result = Double.toString(dbl);
		
		try{
		//Query the database for the numbers needed and set them to variables
			dbl = sp.getDouble(settings, "acc_quota", 0.0);
			result = Double.toString(dbl);
		} catch (Exception e){
			String sresult = e.toString();
		}	
		strategic_acc_quota.setText(result);
	}
	
	//Gets the strategic accessory current value from the shared preferences
	//17
	public void Get_strategic_acc_current(){
		Double dbl = 0.0;
		String result = Double.toString(dbl);
		
		try{
			dbl = sp.getDouble(settings, "acc_current", 0.0);
			result = Double.toString(dbl);
		} catch (Exception e){
			String sresult = e.toString();
		}	
		strategic_acc_current.setText(result);
	}
	
	//Gets the strategic multiplier by performing calculations from the results obtained via shared preferences and the StratetigMultiplier2 Class
	//18
	public void Get_the_strategic_multiplier(){  //Result written to stored preferences
		Double dbl = 0.0;
		String result = Double.toString(dbl);
		
		StrategicMultiplier2 sm = new StrategicMultiplier2(); //Result written to stored preferences
		
		try{
			//Pull data from Strategic Multiplier class
			dbl = sm.GetStrategicMultiplier();

			sp.putDouble(editor, "strategic_multiplier", dbl);
			result = Double.toString(dbl);
		} catch (Exception e){
			String sresult = e.toString();
		}	
		strategic_multiplier.setText(result);
	}	
	
	//Gets the spiffs value from the shared preferences
	//19
	public void Get_spiffs(){
		Double dbl = 0.0;
		String result = Double.toString(dbl);
		
		try{
		//Query the database for the numbers needed and set them to variables
			dbl = sp.getDouble(settings, "spiffs", 0.0);
			result = Double.toString(dbl);
		} catch (Exception e){
			String sresult = e.toString();
		}	
		spiffs.setText(result);
	}
	
	//Gets the final commissions value by performing calculations from the results obtained via shared preferences and the StratetigMultiplier2 Class and GGMultiplier class
	//20
	public void Get_final_commissions(){ //Result written to stored preferences
		Double dbl = 0.0;
		String result = Double.toString(dbl);
		
		StrategicMultiplier2 sm = new StrategicMultiplier2();
		GGMultiplier gg = new GGMultiplier();
		
		try{
			//Uber long calculation. Separated out to prevent any issues. At risk = 1417
			//Commissions formula: final = (1417 * strategic multiplier * GG multiplier * sales dollars multiplier) + spiffs 
			//Setup all variables via pulls from database
			double strategicMultiplier = sm.GetStrategicMultiplier();
			double ggpercent = (sp.getDouble(settings, "gg_current", 0.0) - sp.getDouble(settings, "charge_backs", 0.0)) / sp.getDouble(settings, "gg_quota", 0.0);
			double ggMultiplier = gg.GetGGMultiplier(ggpercent);
			double salesDollarsMultiplier = (sp.getDouble(settings, "sales_dollars_current", 0.0)) / (sp.getDouble(settings, "sales_dollars_quota", 0.0));
			double spiffs = sp.getDouble(settings, "spiffs", 0.0);
			double finalCheck = (1417.00 * strategicMultiplier * ggMultiplier * salesDollarsMultiplier) + spiffs;
			dbl = finalCheck;
			
			//Write to stored preferences
			sp.putDouble(editor, "final_commissions", dbl);
			result = Double.toString(dbl);
		} catch (Exception e){
			String sresult = e.toString();
		}	
		final_commissions.setText(result);
	}
	
	//Gets the final commissions value (+2 a day) by performing calculations from the results obtained via shared preferences and the StratetigMultiplier2 Class and GGMultiplier class
	//21
	public void Get_final_commissions_plus_2_a_day(){
		Double dbl = 0.0;
		String result = Double.toString(dbl);
		
		StrategicMultiplier2 sm = new StrategicMultiplier2();
		GGMultiplier gg = new GGMultiplier();
		
		try{
			//Uber long calculation. Separated out to prevent any issues. At risk = 1417
			//Commissions formula: final = (1417 * strategic multiplier * GG multiplier * sales dollars multiplier) + spiffs 
			//Setup all variables via pulls from shared preferences
			double strategicMultiplier = sm.GetStrategicMultiplier();
			double twoMoreADay = 2*(sp.getDouble(settings, "work_days_left", 0.0));
			
			double ggpercent = (twoMoreADay+(sp.getDouble(settings, "gg_current", 0.0) - sp.getDouble(settings, "charge_backs", 0.0))) / sp.getDouble(settings, "gg_quota", 0.0);
			
			double ggMultiplier = gg.GetGGMultiplier(ggpercent);
			double salesDollarsMultiplier = (sp.getDouble(settings, "sales_dollars_current", 0.0)) / (sp.getDouble(settings, "sales_dollars_quota", 0.0));
			double spiffs = sp.getDouble(settings, "spiffs", 0.0);
			double finalCheck = (1417.00 * strategicMultiplier * ggMultiplier * salesDollarsMultiplier) + spiffs;
			dbl = finalCheck;

			result = Double.toString(dbl);
		} catch (Exception e){
			String sresult = e.toString();
		}	
		final_commissions.setText(result);
	}

////////////////////////////////////

	
	/*
	//Returns calculations via values stored in database queries
	public void Get_to_get_to_a_1dot4(){
		Double dbl = 0.0;
		String result = Double.toString(dbl);
		
		try{
		//Query the database for the numbers needed and set them to variables
			result = db.getData(DatabaseAdmin.COLUMNS[0]);
		} catch (Exception e){
			result = e.toString();
		}	
		working_days_left.setText(result);
	}
	
	//Returns calculations via values stored in database queries
	public void Get_daily_to_get_to_a_1dot4(){
		Double dbl = 0.0;
		String result = Double.toString(dbl);
		
		try{
		//Query the database for the numbers needed and set them to variables
			result = db.getData(DatabaseAdmin.COLUMNS[0]);
		} catch (Exception e){
			result = e.toString();
		}	
		working_days_left.setText(result);
	}
	
	//Returns calculations via values stored in database queries
	public void Get_to_get_to_a_1dot6(){
		Double dbl = 0.0;
		String result = Double.toString(dbl);
		
		try{
		//Query the database for the numbers needed and set them to variables
			result = db.getData(DatabaseAdmin.COLUMNS[0]);
		} catch (Exception e){
			result = e.toString();
		}	
		working_days_left.setText(result);
	}	

	//Returns calculations via values stored in database queries
	public void Get_daily_to_get_to_a_1dot6(){
		Double dbl = 0.0;
		String result = Double.toString(dbl);
		
		try{
		//Query the database for the numbers needed and set them to variables
			result = db.getData(DatabaseAdmin.COLUMNS[0]);
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
		Get_the_strategic_multiplier(); 
		Get_spiffs();
		Get_final_commissions(); 
		Get_final_commissions_plus_2_a_day(); 
		
		
		
		
		
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
