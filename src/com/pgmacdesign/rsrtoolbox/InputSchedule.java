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


import java.util.Calendar;


import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.view.View.OnClickListener;
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
		EditText input_schedule_edit_text_daily_start_time_hour, input_schedule_edit_text_daily_start_time_minute, input_schedule_edit_text_daily_shift_length, input_schedule_edit_text_daily_address, 
		input_schedule_edit_text_meeting_start_time_hour, input_schedule_edit_text_meeting_start_time_minute, input_schedule_edit_text_meeting_shift_length, input_schedule_edit_text_meeting_address,
		input_schedule_edit_text_other_start_time_hour, input_schedule_edit_text_other_start_time_minute, input_schedule_edit_text_other_shift_length, input_schedule_edit_text_other_address;
		
	//Buttons
		Button input_schedule_button_daily_enter_calendar_event, input_schedule_button_daily_remind_me_later, input_schedule_button_meeting_enter_calendar_event,
		input_schedule_button_meeting_remind_me_later, input_schedule_button_other_enter_calendar_event, input_schedule_button_other_remind_me_later;
		
	//Date Picker
		DatePicker input_schedule_datePicker_daily, input_schedule_datePicker_meeting, input_schedule_datePicker_other;
	
	//Misc Variables
		int daily_hour_start, daily_hour_end, meeting_hour_start, meeting_hour_end, other_hour_start, other_hour_end,
		daily_min_start, daily_min_end, meeting_min_start, meeting_min_end, other_min_start, other_min_end;
		
	//StatusBar and Notification Manager Stuff
	    NotificationManager nm;
	    static final int uniqueID = 8675379;
	
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
		    input_schedule_edit_text_daily_start_time_hour = (EditText) findViewById(R.id.input_schedule_edit_text_daily_start_time_hour);
		    input_schedule_edit_text_daily_start_time_minute = (EditText) findViewById(R.id.input_schedule_edit_text_daily_start_time_minute);
		    input_schedule_edit_text_daily_shift_length = (EditText) findViewById(R.id.input_schedule_edit_text_daily_shift_length);
		    input_schedule_datePicker_daily = (DatePicker) findViewById(R.id.input_schedule_datePicker_daily);
		    input_schedule_edit_text_daily_address = (EditText) findViewById(R.id.input_schedule_edit_text_daily_address);
		    input_schedule_button_daily_enter_calendar_event = (Button) findViewById(R.id.input_schedule_button_daily_enter_calendar_event);
		    input_schedule_button_daily_remind_me_later = (Button) findViewById(R.id.input_schedule_button_daily_remind_me_later);
		    
		//Variables for Tab 2 - Meeting
		    input_schedule_edit_text_meeting_start_time_hour = (EditText) findViewById(R.id.input_schedule_edit_text_meeting_start_time_hour);
		    input_schedule_edit_text_meeting_start_time_minute = (EditText) findViewById(R.id.input_schedule_edit_text_meeting_start_time_minute);
		    input_schedule_edit_text_meeting_shift_length = (EditText) findViewById(R.id.input_schedule_edit_text_meeting_shift_length);
		    input_schedule_datePicker_meeting = (DatePicker) findViewById(R.id.input_schedule_datePicker_meeting);
		    input_schedule_edit_text_meeting_address = (EditText) findViewById(R.id.input_schedule_edit_text_meeting_address);
		    input_schedule_button_meeting_enter_calendar_event = (Button) findViewById(R.id.input_schedule_button_meeting_enter_calendar_event);
		    input_schedule_button_meeting_remind_me_later = (Button) findViewById(R.id.input_schedule_button_meeting_remind_me_later);
		    
		//Variables for tab 3 - Other
		    input_schedule_edit_text_other_start_time_hour = (EditText) findViewById(R.id.input_schedule_edit_text_other_start_time_hour);
		    input_schedule_edit_text_other_start_time_minute = (EditText) findViewById(R.id.input_schedule_edit_text_other_start_time_minute);
		    input_schedule_edit_text_other_shift_length = (EditText) findViewById(R.id.input_schedule_edit_text_other_shift_length);
		    input_schedule_datePicker_other = (DatePicker) findViewById(R.id.input_schedule_datePicker_other);
		    input_schedule_edit_text_other_address = (EditText) findViewById(R.id.input_schedule_edit_text_other_address);
		    input_schedule_button_other_enter_calendar_event = (Button) findViewById(R.id.input_schedule_button_other_enter_calendar_event);
		    input_schedule_button_other_remind_me_later = (Button) findViewById(R.id.input_schedule_button_other_remind_me_later);
		
		//Buttons to onClickListener
		    input_schedule_button_daily_enter_calendar_event.setOnClickListener(this);
		    input_schedule_button_meeting_enter_calendar_event.setOnClickListener(this);
		    input_schedule_button_other_enter_calendar_event.setOnClickListener(this);
		    
		//Hours and Minutes
		    daily_hour_start = daily_hour_end = meeting_hour_start = meeting_hour_end = other_hour_start = other_hour_end = 1;
		    daily_min_start = daily_min_end = meeting_min_start = meeting_min_end = other_min_start = other_min_end = 0;
		    
		//Setup default values for shift length
		    input_schedule_edit_text_daily_shift_length.setText("8.5");
		    input_schedule_edit_text_meeting_shift_length.setText("2");
		    input_schedule_edit_text_other_shift_length.setText("4.5");
		    
		//Notification Manager/ Drop-down reminders
		    //Define the notification manager
			nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
			
			//Cancel the specific ID once the app has been re-opened/ resumed
			nm.cancel(uniqueID);
			
			//IMPORTANT: Must call this to remove the notification bar. If calling different class, have to put this method call in there so it can close the notification
			removeNotification();
			
		//Specialty Buttons for NotificationManager. Nested OnClicklisteners
			input_schedule_button_daily_remind_me_later.setOnClickListener(new OnClickListener(){
				public void onClick(View v){
					addNotification();
					finish();
				}
			});
			
			input_schedule_button_meeting_remind_me_later.setOnClickListener(new OnClickListener(){
				public void onClick(View v){
					addNotification();
					finish();
				}
			});
			
			input_schedule_button_other_remind_me_later.setOnClickListener(new OnClickListener(){
				public void onClick(View v){
					addNotification();
					finish();
				}
			});		    
	}
	
	//On Click Method
	@Override
	public void onClick(View arg0) {
		//Switch case for all buttons on screen
		switch (arg0.getId()){
		
		case R.id.input_schedule_button_daily_enter_calendar_event:
			//Create a calendar event for the weekly/ daily schedule
			CreateEvent("Work", input_schedule_edit_text_daily_address.getText().toString(), "Sales Shift", input_schedule_datePicker_daily);
			makeToast("Event Created Successfully");
			break;
			
		case R.id.input_schedule_button_meeting_enter_calendar_event:
			//Create a calendar event for a meeting
			CreateEvent("Meeting", input_schedule_edit_text_meeting_address.getText().toString(), "Work Meeting", input_schedule_datePicker_meeting);
			makeToast("Event Created Successfully");
			break;
			
		case R.id.input_schedule_button_other_enter_calendar_event:
			//Create a calendar event for some misc event
			CreateEvent("Event", input_schedule_edit_text_other_address.getText().toString(), "Misc Event", input_schedule_datePicker_other);
			makeToast("Event Created Successfully");
			break;			
		}	
	}

	//When an item is selected with the spinner
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		//Position variable to determine which option the spinner is pointing to
		int position = spinner_daily.getSelectedItemPosition();
		switch (position){
		
		//CSR Open
		case 0:
			daily_hour_start = 8;
			daily_min_start = 30;
			String hour0 = Integer.toString(daily_hour_start);
			String min0 = Integer.toString(daily_min_start);
			input_schedule_edit_text_daily_start_time_hour.setText(hour0);
			input_schedule_edit_text_daily_start_time_minute.setText(min0);			
			break;
			
		//Open
		case 1:
			daily_hour_start = 9;
			daily_min_start = 30;
			String hour1 = Integer.toString(daily_hour_start);
			String min1 = Integer.toString(daily_min_start);
			input_schedule_edit_text_daily_start_time_hour.setText(hour1);
			input_schedule_edit_text_daily_start_time_minute.setText(min1);	
			break;
			
		//Sunday Open
		case 2:
			daily_hour_start = 10;
			daily_min_start = 30;
			String hour2 = Integer.toString(daily_hour_start);
			String min2 = Integer.toString(daily_min_start);
			input_schedule_edit_text_daily_start_time_hour.setText(hour2);
			input_schedule_edit_text_daily_start_time_minute.setText(min2);	
			break;
							
		//Mid
		case 3:
			daily_hour_start = 11;
			daily_min_start = 0;
			String hour3 = Integer.toString(daily_hour_start);
			String min3 = Integer.toString(daily_min_start);
			input_schedule_edit_text_daily_start_time_hour.setText(hour3);
			input_schedule_edit_text_daily_start_time_minute.setText(min3);	
			break;
			
		//Late Mid
		case 4:
			daily_hour_start = 12;
			daily_min_start = 0;
			String hour4 = Integer.toString(daily_hour_start);
			String min4 = Integer.toString(daily_min_start);
			input_schedule_edit_text_daily_start_time_hour.setText(hour4);
			input_schedule_edit_text_daily_start_time_minute.setText(min4);	
			break;	
			
		//Close
		case 5:
			daily_hour_start = 13;
			daily_min_start = 0;
			String hour5 = Integer.toString(daily_hour_start);
			String min5 = Integer.toString(daily_min_start);
			input_schedule_edit_text_daily_start_time_hour.setText(hour5);
			input_schedule_edit_text_daily_start_time_minute.setText(min5);
			break;							
		}
	}
	
	@Override //Not used atm
	public void onNothingSelected(AdapterView<?> arg0) {		
	}
	
	//Create New Calendar Event
	public void CreateEvent(String title, String address, String description, DatePicker dp){
		//First run method that calculates all end times
		GetEndTimes();
		
		//Create an intent that will enter data into the calendar
		Intent calIntent = new Intent(Intent.ACTION_INSERT);
		calIntent.setType("vnd.android.cursor.item/event");
		
		//Put information in
		calIntent.putExtra(Events.TITLE, title); 
		calIntent.putExtra(Events.EVENT_LOCATION, address); 
		calIntent.putExtra(Events.DESCRIPTION, description);
		
		//Start and End Timing
		Calendar startTime = Calendar.getInstance();
		Calendar endTime = Calendar.getInstance();
			//Format: startTime.set(year, month, day, hourOfDay, minute)
		startTime.set(dp.getYear(), dp.getMonth(), dp.getDayOfMonth(), daily_hour_start, daily_min_start);
		endTime.set(dp.getYear(), dp.getMonth(), dp.getDayOfMonth(), daily_hour_end, daily_min_end);
		
		//Put the calculated start and end time into the calIntent Intent
		calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
		startTime.getTimeInMillis());
		calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
		endTime.getTimeInMillis());

		//Puts event into calendar
		startActivity(calIntent); 
	}
	
	//This calculates the end times for all of the variables based upon the duration time of event
	public void GetEndTimes(){
		
		//This section gets the start times from the editTexts and calculates the end times for the daily tab
			daily_hour_start = Integer.parseInt(input_schedule_edit_text_daily_start_time_hour.getText().toString());
			daily_min_start = Integer.parseInt(input_schedule_edit_text_daily_start_time_minute.getText().toString());
			
			double lengthOfDailyEvent1 = 0.0;
			int lengthOfDailyEventHours1 = 0;
			int lengthOfDailyEventMinutes1 = 0;
			
			lengthOfDailyEvent1 = Double.parseDouble(input_schedule_edit_text_daily_shift_length.getText().toString());
					
			int totalsecs1 = (int) (lengthOfDailyEvent1*3600);
			int hours1 = totalsecs1 - (totalsecs1 % 3600);
			int minutes1 = totalsecs1 - hours1;
			lengthOfDailyEventHours1 = hours1 / 3600;
			lengthOfDailyEventMinutes1 = minutes1 / 3600;
			
			daily_hour_end = daily_hour_start + lengthOfDailyEventHours1;
			daily_min_end = daily_min_start + lengthOfDailyEventMinutes1;

		
			
		//This section gets the start times from the editTexts and calculates the end times for the meeting tab
			meeting_hour_start = Integer.parseInt(input_schedule_edit_text_meeting_start_time_hour.getText().toString());
			meeting_min_start = Integer.parseInt(input_schedule_edit_text_meeting_start_time_minute.getText().toString());
			
			double lengthOfDailyEvent2 = 0.0;
			int lengthOfMeetingEventHours2 = 0;
			int lengthOfMeetingEventMinutes2 = 0;
			
			lengthOfDailyEvent2 = Double.parseDouble(input_schedule_edit_text_meeting_shift_length.getText().toString());
					
			int totalsecs2 = (int) (lengthOfDailyEvent2*3600);
			int hours2 = totalsecs1 - (totalsecs1 % 3600);
			int minutes2 = totalsecs1 - hours1;
			lengthOfMeetingEventHours2 = hours1 / 3600;
			lengthOfMeetingEventMinutes2 = minutes1 / 3600;
			
			meeting_hour_start = meeting_hour_start + lengthOfMeetingEventHours2;
			meeting_min_start = meeting_min_start + lengthOfMeetingEventMinutes2;
		
			
		//This section gets the start times from the editTexts and calculates the end times for the other tab
			other_hour_start = Integer.parseInt(input_schedule_edit_text_other_start_time_hour.getText().toString());
			other_min_start = Integer.parseInt(input_schedule_edit_text_other_start_time_minute.getText().toString());
			
			double lengthOfDailyEvent3 = 0.0;
			int lengthOfOtherEventHours3 = 0;
			int lengthOfOtherEventMinutes3 = 0;
			
			lengthOfDailyEvent3 = Double.parseDouble(input_schedule_edit_text_other_shift_length.getText().toString());
					
			int totalsecs3 = (int) (lengthOfDailyEvent3*3600);
			int hours3 = totalsecs1 - (totalsecs1 % 3600);
			int minutes3 = totalsecs1 - hours1;
			lengthOfOtherEventHours3 = hours1 / 3600;
			lengthOfOtherEventMinutes3 = minutes1 / 3600;
			
			other_hour_end = other_hour_start + lengthOfOtherEventHours3;
			other_min_end = other_min_start + lengthOfOtherEventMinutes3;		
	}
	
	//Adds the notification bar to the top of the 
	public void addNotification() {

    	String body = "Go back and finish putting in schedule!";
		String title = "Reminder:";
		
	    NotificationCompat.Builder builder =  
	            new NotificationCompat.Builder(this)  
	            .setSmallIcon(R.drawable.calendar_icon_large)  
	            .setContentTitle(title)  
	            .setContentText(body);  

	    //Change what you want opened here in the second Parameter VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV
	    Intent notificationIntent = new Intent(this, InputSchedule.class);  
	    PendingIntent intent = PendingIntent.getActivity(this, 0, notificationIntent,   
	            PendingIntent.FLAG_UPDATE_CURRENT);  
	    builder.setContentIntent(intent);  
	
	    // Add as notification  
	    NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);  
	    manager.notify(uniqueID, builder.build());  
    }  
	
	//This removes an item from the notification bar
	private void removeNotification() {  
	    NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);  
	    manager.cancel(uniqueID);  
	}
	
	//On pause method
	protected void onPause() {
		super.onPause();
		finish();
	}

	//Simple class that makes a popup (toast) with text
	public void makeToast(String activityChosen){
		Toast.makeText(getApplicationContext(), activityChosen, Toast.LENGTH_SHORT).show();
	}
	
	
}
