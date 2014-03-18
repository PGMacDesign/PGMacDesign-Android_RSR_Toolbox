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
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

//Main menu class. Supports a Grid View
public class Main extends Activity implements OnItemClickListener {
	
	//Gridview to match the xml
	GridView gridView;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);
		
		gridView = (GridView) findViewById(R.id.main_menu_grid_view);
		
		gridView.setAdapter(new ActivityAdapter(getApplicationContext()));
		
		gridView.setOnItemClickListener(this);
	}

	

	//This onItemClick method jumps to the ActivityAdapter class to determine which item was chosen from the grid and then opens the respective activity
	@Override
	public void onItemClick(AdapterView<?> parentView, View v, int position, long id) {

		int activityChosen;
		
		//Calls the method to determine which point in the Array the choice is
		activityChosen = ActivityAdapter.getActivityPosition(position);
		
		//Switch case to open the respective activity that the user chooses. 
	    switch(position){
        case 0:
        	try {
				makeToast("Vacation Quota");
	        	Intent a = new Intent(v.getContext(), VacationQuotaRelief.class);
		        startActivity(a);
        	} catch (Exception e) {
        		String error = e.toString();
        		makeToast(error);
        	}
	        break;
        case 1:
        	try{
	        	makeToast("Revenue Deficit");
	        	Intent b = new Intent(v.getContext(), RevenueDeficit.class);
		        startActivity(b);
        	} catch (Exception e) {
        		String error = e.toString();
        		makeToast(error);
        	}
	        break;
        case 2:
        	try {
        		makeToast("Enter Commissions Info");
	        	Intent c = new Intent(v.getContext(), EnterCommissionsInfo.class);
		        startActivity(c);
        	} catch (Exception e) {
        		String error = e.toString();
        		makeToast(error);
        	}
        	break;
        case 3:
        	try {
        		makeToast("Commissions");
	        	Intent c = new Intent(v.getContext(), Commissions.class);
		        startActivity(c);
        	} catch (Exception e) {
        		String error = e.toString();
        		makeToast(error);
        	}
        	break;
        case 4:
        	try{
	        	makeToast("Useful SKUs");
	        	Intent d = new Intent(v.getContext(), UsefulSKUs.class);
		        startActivity(d);
        	} catch (Exception e) {
        		String error = e.toString();
        		makeToast(error);
        	}
        	break;
        case 5:
        	try{
	        	makeToast("Input Schedule");
	        	Intent e = new Intent(v.getContext(), InputSchedule.class);
		        startActivity(e);
	    	} catch (Exception e) {
	    		String error = e.toString();
	    		makeToast(error);
	    	}
        	break;
        case 6:
        	try{
	        	makeToast("Follow-Up");
	        	Intent f = new Intent(v.getContext(), FollowUp.class);
		        startActivity(f);
        	} catch (Exception e) {
        		String error = e.toString();
        		makeToast(error);
        	}
        	break;
        case 7:
        	try{
	        	makeToast("Lunch Timer");
	        	Intent g = new Intent(v.getContext(), LunchTimer.class);
		        startActivity(g);
        	} catch (Exception e) {
        		String error = e.toString();
        		makeToast(error);
        	}
        	break;
        case 8:
	        try{
	        	makeToast("Calculator");
	        	Intent h = new Intent(v.getContext(), Calculator.class);
		        startActivity(h);
        	} catch (Exception e) {
        		String error = e.toString();
        		makeToast(error);
        	}
        	break;
        case 9:
        	try{
	        	makeToast("Share This App");
	        	Intent i = new Intent(v.getContext(), ShareThisApp.class);
		        startActivity(i);
        	} catch (Exception e) {
        		String error = e.toString();
        		makeToast(error);
        	}
        	break;
        case 10:
        	try{
	        	makeToast("Edge");
	        	Intent j = new Intent(v.getContext(), Edge.class);
		        startActivity(j);
        	} catch (Exception e) {
        		String error = e.toString();
        		makeToast(error);
        	}
        	break;
        case 11:
        	try{
	        	makeToast("Important Contact Numbers");
	        	Intent k = new Intent(v.getContext(), ImportantContactNumbers.class);
		        startActivity(k);
        	} catch (Exception e) {
        		String error = e.toString();
        		makeToast(error);
        	}
        	break;
        case 12:
        	try{
	        	makeToast("Stress Relief");
	        	Intent l = new Intent(v.getContext(), StressRelief.class);
		        startActivity(l);
        	} catch (Exception e) {
        		String error = e.toString();
        		makeToast(error);
        	}
        	break;
        case 13:
        	try{
	        	makeToast("Magic Ball");
	        	Intent m = new Intent(v.getContext(), MagicBall.class);
		        startActivity(m);
        	} catch (Exception e) {
        		String error = e.toString();
        		makeToast(error);
        	}
        	break;        	
	    }
		
	}
	
	
	//Creates a boolean where the user hits the menu/ settings/ 3 little line button/ checkerbox (on the old Droid X).
	public boolean onCreateOptionsMenu(android.view.Menu menu_settings) {
		
		//menu inflater 
		MenuInflater blowUp = getMenuInflater(); 
		blowUp.inflate(R.menu.cool_menu, menu_settings);
		return true;
		
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
						
		case R.id.Exit:
			//Bring up a page for the user to adjust preferences
			finish();
			
			break;
		}
		
		return false;
	}

	//Simple class that makes a popup (toast) with the activity name the user chose
	public void makeToast(String activityChosen){
		Toast.makeText(getApplicationContext(), activityChosen, Toast.LENGTH_SHORT).show();
	}



}
	
