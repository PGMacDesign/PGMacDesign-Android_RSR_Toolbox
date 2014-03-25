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
import android.app.LocalActivityManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;

public class InputSchedule extends Activity implements View.OnClickListener, OnItemSelectedListener {

	//Shared Preferences
	public static final String PREFS_NAME = "RSRToolboxData";	
	SharedPrefs sp = new SharedPrefs();
	SharedPreferences settings;
	SharedPreferences.Editor editor;
	
	//XML Variables
	//Spinners
		Spinner spinner_daily;
		String[]daily_paths = {"CSR Open", "Open", "Sunday Open", "Mid", "Late Mid", "Close"};
	
	//Tabs
		TabHost host;
		TabWidget tabWidget;
	
	
	//Main - When the activity starts
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.input_schedule);
		
		Initialize();

		//Deprecated atm
		LocalActivityManager mLocalActivityManager = new LocalActivityManager(this, false);
	    mLocalActivityManager.dispatchCreate(savedInstanceState); // state will be bundle your activity state which you get in onCreate
	    host.setup(mLocalActivityManager);

		
	}

	//Initialize Variables
	private void Initialize(){
		//Shared Preferences Stuff
			settings = getSharedPreferences(PREFS_NAME, 0);
			settings = getSharedPreferences(PREFS_NAME, 1);
			editor = settings.edit();
		
		//Array Adapter for Spinner use with the daily tab
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, daily_paths);
			
		//Spinner setup
			spinner_daily = (Spinner) findViewById(R.id.input_schedule_spinner_daily_shift_choice); //Define from input_schedule.xml
			spinner_daily.setAdapter(adapter);
			spinner_daily.setOnItemSelectedListener(this);
			
		//TabHost
			host = (TabHost)findViewById(android.R.id.tabhost);
		    host.setup();
		    
		    /*
		    host.addTab(host.newTabSpec("one")
                    .setIndicator("First Results")
	                .setContent(new TabContentFactory() {

	                    public View createTabContent(String tag) {
	                        return new TextView(TestActivity.this);
	                    }
	                }));
		    
		    host.addTab(host.newTabSpec("two")
                    .setIndicator("Second Results")
	                .setContent(new TabContentFactory() {

	                    public View createTabContent(String tag) {
	                        return new TextView(TestActivity.this);
	                    }
	                }));
		    
		    host.getTabWidget().getChildAt(0).getLayoutParams().height = 35;
		    host.getTabWidget().getChildAt(1).getLayoutParams().height = 35;
			*/
		    
	}
	
	//On Click Method
	@Override
	public void onClick(View arg0) {
		/*
		switch (arg0.getId()){
		
		case R.id.button_ID_That_Was_Clicked:
			
			break;
			
		case R.id.button_ID_That_Was_Clicked:
			
			break;
			
		}
		*/
	}
	
	protected void onPause() {

		super.onPause();
		finish();
	}

	//Simple class that makes a popup (toast) with the activity name the user chose
	public void makeToast(String activityChosen){
		Toast.makeText(getApplicationContext(), activityChosen, Toast.LENGTH_SHORT).show();
	}

	//When an item is selected with the spinner
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		
		int position = spinner_daily.getSelectedItemPosition();
		switch (position){
		
		//CSR Open
		case 0:
			//Do stuff
			break;
			
		//Open
		case 1:
			//Do stuff
			break;
			
		//Sunday Open
		case 2:
			//Do stuff
			break;
							
		//Mid
		case 3:
			//Do stuff
			break;
			
		//Late Mid
		case 4:
			//Do stuff
			break;	
			
		//Close
		case 5:
			//Do stuff
			break;							
		}
	}
	
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
