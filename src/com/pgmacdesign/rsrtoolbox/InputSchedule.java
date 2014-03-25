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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
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
		TabSpec specs;
		
	//EditTexts
		EditText input_schedule_edit_text_daily_start_time, input_schedule_edit_text_daily_shift_length, input_schedule_edit_text_daily_address, 
		input_schedule_edit_text_meeting_start_time, input_schedule_edit_text_meeting_shift_length, input_schedule_edit_text_meeting_address,
		input_schedule_edit_text_other_start_time, input_schedule_edit_text_other_shift_length, input_schedule_edit_text_other_address;
		
	//Buttons
		Button input_schedule_button_daily_enter_calendar_event, input_schedule_button_daily_remind_me_later, input_schedule_button_meeting_enter_calendar_event,
		input_schedule_button_meeting_remind_me_later, input_schedule_button_other_enter_calendar_event, input_schedule_button_other_remind_me_later;
		
	//Date Picker
		DatePicker input_schedule_datePicker_daily, input_schedule_datePicker_meeting, input_schedule_datePicker_other;
	
	
	//Main - When the activity starts
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.input_schedule);
		//Setup all variables and listeners
		Initialize();


		
	}

	//Initialize Variables
	private void Initialize(){
		//Shared Preferences Stuff
			settings = getSharedPreferences(PREFS_NAME, 0);
			editor = settings.edit();
		
		//Array Adapter for Spinner use with the daily tab
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, daily_paths);
			
		//Spinner setup
			spinner_daily = (Spinner) findViewById(R.id.input_schedule_spinner_daily_shift_choice); //Define from input_schedule.xml
			spinner_daily.setAdapter(adapter);
			spinner_daily.setOnItemSelectedListener(this);
			
		//TabHost <--Creates the tab host and sets it up
			host = (TabHost)findViewById(android.R.id.tabhost);
		    host.setup(); //Host Initialization
		    
		//Refer to tab specs, create first tab and add it <--Formats and assigns tabs to the tab host
		    specs = host.newTabSpec("tag1");
		    specs.setContent(R.id.Daily); //First Tab
		    specs.setIndicator("Weekly Schedule");
		    host.addTab(specs);
		    
		//Refer to tab specs, create second tab and add it
		    specs = host.newTabSpec("tag2");
		    specs.setContent(R.id.Meetings); //First Tab
		    specs.setIndicator("Meetings");
		    host.addTab(specs);		    
		
		//Refer to tab specs, create third tab and add it
		    specs = host.newTabSpec("tag3");
		    specs.setContent(R.id.Other); //First Tab
		    specs.setIndicator("Other/ Misc");
		    host.addTab(specs);	
		    
		//Variables for Tab 1 - Daily
		    input_schedule_edit_text_daily_start_time = (EditText) findViewById(R.id.input_schedule_edit_text_daily_start_time);
		    input_schedule_edit_text_daily_shift_length = (EditText) findViewById(R.id.input_schedule_edit_text_daily_shift_length);
		    input_schedule_datePicker_daily = (DatePicker) findViewById(R.id.input_schedule_datePicker_daily);
		    input_schedule_edit_text_daily_address = (EditText) findViewById(R.id.input_schedule_edit_text_daily_address);
		    input_schedule_button_daily_enter_calendar_event = (Button) findViewById(R.id.input_schedule_button_daily_enter_calendar_event);
		    input_schedule_button_daily_remind_me_later = (Button) findViewById(R.id.input_schedule_button_daily_remind_me_later);
		    
		//Variables for Tab 2 - Meeting
		    input_schedule_edit_text_meeting_start_time = (EditText) findViewById(R.id.input_schedule_edit_text_meeting_start_time);
		    input_schedule_edit_text_meeting_shift_length = (EditText) findViewById(R.id.input_schedule_edit_text_meeting_shift_length);
		    input_schedule_datePicker_meeting = (DatePicker) findViewById(R.id.input_schedule_datePicker_meeting);
		    input_schedule_edit_text_meeting_address = (EditText) findViewById(R.id.input_schedule_edit_text_meeting_address);
		    input_schedule_button_meeting_enter_calendar_event = (Button) findViewById(R.id.input_schedule_button_meeting_enter_calendar_event);
		    input_schedule_button_meeting_remind_me_later = (Button) findViewById(R.id.input_schedule_button_meeting_remind_me_later);
		    
		//Variables for tab 3 - Other
		    input_schedule_edit_text_other_start_time = (EditText) findViewById(R.id.input_schedule_edit_text_other_start_time);
		    input_schedule_edit_text_other_shift_length = (EditText) findViewById(R.id.input_schedule_edit_text_other_shift_length);
		    input_schedule_datePicker_other = (DatePicker) findViewById(R.id.input_schedule_datePicker_other);
		    input_schedule_edit_text_other_address = (EditText) findViewById(R.id.input_schedule_edit_text_other_address);
		    input_schedule_button_other_enter_calendar_event = (Button) findViewById(R.id.input_schedule_button_other_enter_calendar_event);
		    input_schedule_button_other_remind_me_later = (Button) findViewById(R.id.input_schedule_button_other_remind_me_later);
		
		//Buttons to onClickListener
		    input_schedule_button_daily_enter_calendar_event.setOnClickListener(this);
		    input_schedule_button_daily_remind_me_later.setOnClickListener(this);
		    input_schedule_button_meeting_enter_calendar_event.setOnClickListener(this);
		    input_schedule_button_meeting_remind_me_later.setOnClickListener(this);
		    input_schedule_button_other_enter_calendar_event.setOnClickListener(this);
		    input_schedule_button_other_remind_me_later.setOnClickListener(this);

	}
	
	//On Click Method
	@Override
	public void onClick(View arg0) {
		//Switch case for all buttons on screen
		switch (arg0.getId()){
		
		case R.id.input_schedule_button_daily_enter_calendar_event:
			
			break;
			
		case R.id.input_schedule_button_daily_remind_me_later:
			
			break;
			
		case R.id.input_schedule_button_meeting_enter_calendar_event:
			
			break;
			
		case R.id.input_schedule_button_meeting_remind_me_later:
			
			break;
			
		case R.id.input_schedule_button_other_enter_calendar_event:
			
			break;
			
		case R.id.input_schedule_button_other_remind_me_later:
			
			break;
							
		}
		
	}
	
	protected void onPause() {

		super.onPause();
		finish();
	}

	//Simple class that makes a popup (toast) with text
	public void makeToast(String activityChosen){
		Toast.makeText(getApplicationContext(), activityChosen, Toast.LENGTH_SHORT).show();
	}

	//When an item is selected with the spinner
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		//Position variable to determine which option the spinner is pointing to
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
	
	@Override //Not used atm
	public void onNothingSelected(AdapterView<?> arg0) {		
	}
	
}
