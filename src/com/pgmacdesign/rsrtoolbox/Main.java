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

import java.io.File;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

//Main menu class. Supports a Grid View
public class Main extends Activity implements OnItemClickListener {
	
	//Make changes to the Prefs File
	public static final String PREFS_NAME = "RSRToolboxData";	
	SharedPrefs sp = new SharedPrefs();
	SharedPreferences settings;
	SharedPreferences.Editor editor;
	
	//Gridview to match the xml
	GridView gridView;
	
	//File for testing if a DB has been created
	File databaseFile;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);
		
		//Shared Preferences
		settings = getSharedPreferences(PREFS_NAME, 0);
		editor = settings.edit();
		
		gridView = (GridView) findViewById(R.id.main_menu_grid_view);
		
		gridView.setAdapter(new ActivityAdapter(getApplicationContext()));
		
		gridView.setOnItemClickListener(this);
		
		
		//Check to see if the SharedPreferences file has been filled/ exists
		if (sp.getDouble(settings, "at_risk", 0.0) > 999){ //Info has already been entered. Used 999 instead of 1417 as it may change at some point
			//Do nothing for now
		} else {
			try{
				
				//Enter all data to the shared preferences as 0.0 Except for at_risk
				for (int i=0; i < DatabaseAdmin.COLUMNS.length; i++ ){
					sp.putDouble(editor, DatabaseAdmin.COLUMNS[i], 0.0);
					editor.commit();
				}
				//Enter at risk
				sp.putDouble(editor, "at_risk", 1417.00);
				editor.commit();
				
				makeToast("Initial Setup Complete");
			} catch (Exception e){
				e.printStackTrace();
			}
		}	
		
		toggleActionBar();
	}

	//TEST
	private void toggleActionBar() {
		  ActionBar actionBar = getActionBar();
	}
	//TEST
	
	//This onItemClick method jumps to the ActivityAdapter class to determine which item was chosen from the grid and then opens the respective activity
	@Override
	public void onItemClick(AdapterView<?> parentView, View v, int position, long id) {

		@SuppressWarnings("unused")
		int activityChosen;
		
		//Calls the method to determine which point in the Array the choice is
		activityChosen = ActivityAdapter.getActivityPosition(position);
		
		//Switch case to open the respective activity that the user chooses. 
	    switch(position){
        case 0:
        	try {
				makeToast("Vacation Quota");
	        	Intent intent00 = new Intent(v.getContext(), VacationQuotaRelief.class);
		        startActivity(intent00);
        	} catch (Exception e) {
        		String error = e.toString();
        		makeToast(error);
        	}
	        break;
        case 1:
        	try{
	        	makeToast("Revenue Deficit");
	        	Intent intent1 = new Intent(v.getContext(), RevenueDeficit.class);
		        startActivity(intent1);
        	} catch (Exception e) {
        		String error = e.toString();
        		makeToast(error);
        	}
	        break;
        case 2:
        	try {
        		makeToast("Enter Commissions Info");
	        	Intent intent44 = new Intent(v.getContext(), EnterCommissionsInfo.class);
		        startActivity(intent44);
        	} catch (Exception e) {
        		String error = e.toString();
        		makeToast(error);
        	}

        	
        	break;
        case 3:
        	try {
        		makeToast("Commissions");
	        	Intent intent6 = new Intent(v.getContext(), Commissions.class);
		        startActivity(intent6);
        	} catch (Exception e) {
        		String error = e.toString();
        		makeToast(error);
        	}
        	break;

        case 4:
        	try{
	        	makeToast("Input Schedule");
	        	Intent intent3 = new Intent(v.getContext(), InputSchedule.class);
		        startActivity(intent3);
	    	} catch (Exception e) {
	    		String error = e.toString();
	    		makeToast(error);
	    	}
        	break;

        case 5:
        	try{
	        	makeToast("Follow-Up");
	        	Intent intent7 = new Intent(v.getContext(), FollowUp.class);
		        startActivity(intent7);
        	} catch (Exception e) {
        		String error = e.toString();
        		makeToast(error);
        	}
        	break;
        	
        case 6:
	        try{
	        	makeToast("Calculator");
	        	Intent intent8 = new Intent(v.getContext(), Calculator.class);
		        startActivity(intent8);
        	} catch (Exception e) {
        		String error = e.toString();
        		makeToast(error);
        	}
        	break;
        	
        case 7:
        	try{
	        	makeToast("Share This App");
	        	Intent intent9 = new Intent(v.getContext(), ShareThisApp.class);
		        startActivity(intent9);
        	} catch (Exception e) {
        		String error = e.toString();
        		makeToast(error);
        	}
        	break;
        	
        case 8:
        	try{
	        	makeToast("Edge");
	        	Intent intent10 = new Intent(v.getContext(), Edge.class);
		        startActivity(intent10);
        	} catch (Exception e) {
        		String error = e.toString();
        		makeToast(error);
        	}
        	break;
        	
        case 9:
        	try{
	        	makeToast("Important Contact Numbers");
	        	Intent intent11 = new Intent(v.getContext(), ImportantContactNumbers.class);
		        startActivity(intent11);
        	} catch (Exception e) {
        		String error = e.toString();
        		makeToast(error);
        	}
        	break;
        case 10:
        	try{
	        	makeToast("Stress Relief");
	        	Intent intent12 = new Intent(v.getContext(), StressRelief.class);
		        startActivity(intent12);
        	} catch (Exception e) {
        		String error = e.toString();
        		makeToast(error);
        	}
        	break;
        case 11:
        	try{
	        	makeToast("Magic Ball");
	        	Intent intent13 = new Intent(v.getContext(), MagicBall.class);
		        startActivity(intent13);
        	} catch (Exception e) {
        		String error = e.toString();
        		makeToast(error);
        	}
        	break;
        	
        case 12:   		
    		//Reset the database with zeros
        	//Reset the month
			try{
				
				//Enter all data to the shared preferences as 0.0 Except for at_risk
				for (int i=0; i < DatabaseAdmin.COLUMNS.length; i++ ){
					sp.putDouble(editor, DatabaseAdmin.COLUMNS[i], 0.0);
					editor.commit();
				}
				//Enter at risk
				sp.putDouble(editor, "at_risk", 1417.00);
				editor.commit();
				
			} catch (Exception e){
				e.printStackTrace();
			}
			makeToast("Commissions Has Been Reset");
			
			try{
				Intent intentD = new Intent(v.getContext(), Donate.class); 
				startActivity(intentD);	
			} catch (Exception e){
				Log.d("Das Error", e.toString());
			}
			
			break;
			
			/*
        case 13:
        	try{
	        	makeToast("TEST");
	        	Intent intent13 = new Intent(v.getContext(), UsefulSKUs.class);
		        startActivity(intent13);
        	} catch (Exception e) {
        		String error = e.toString();
        		makeToast(error);
        	}
        	break;
        	*/
	    }
	    
	    	
		
	}
	
	public boolean DoesDatabaseExist(){
		return databaseFile.exists();
	}
	
	//Creates a boolean where the user hits the menu/ settings/ 3 little line button/ checkerbox (on the old Droid X).
	public boolean onCreateOptionsMenu(android.view.Menu menu_settings) {
		
		//getMenuInflater().inflate(R.menu.main, menu_settings);   //This is the code for standard menu on top
		
		//menu inflater 
		MenuInflater blowUp = getMenuInflater(); 
		blowUp.inflate(R.menu.cool_menu, menu_settings);
		return super.onCreateOptionsMenu(menu_settings);
		
	}

	//When the menu button is pressed (boolean above) a mini-menu opens up with these options
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch(item.getItemId()){
		
		case R.id.aboutus:
			//Bring up a page with about us information
			Intent intent1 = new Intent("com.pgmacdesign.rsrtoolbox.ABOUTUS");
			startActivity(intent1);
			
			break;
			
		case R.id.preferences:
			//Bring up a page for the user to adjust preferences
			Intent intent2 = new Intent("com.pgmacdesign.rsrtoolbox.PREFS");
			startActivity(intent2);		
			break;
			
		case R.id.send_Bug_Report:
			//Send email to PGMacDesign@gmail.com
			Intent intent3 = new Intent("com.pgmacdesign.rsrtoolbox.BUGREPORT");
			startActivity(intent3);	
			break;
			
		case R.id.donate_money:
			//
			Intent intent4 = new Intent("com.pgmacdesign.rsrtoolbox.DONATE");
			startActivity(intent4);	
			break;
			
		case R.id.Exit:
			//Exits / Closes the application
			finish();
			
			break;
		}
		
		return false;
	}

	//Simple class that makes a popup (toast) with the activity name the user chose
	public void makeToast(String activityChosen){
		Toast.makeText(getApplicationContext(), activityChosen, Toast.LENGTH_SHORT).show();
	}


	//Will eventually add this code back in
	/*
	 * 
        case 6:
        	try{
	        	makeToast("Lunch Timer");
	        	Intent intent2 = new Intent(v.getContext(), LunchTimer.class);
		        startActivity(intent2);
        	} catch (Exception e) {
        		String error = e.toString();
        		makeToast(error);
        	}
        	break;
	 */

}
	
