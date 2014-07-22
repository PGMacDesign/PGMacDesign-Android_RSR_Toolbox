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
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.provider.CalendarContract.Reminders;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class FollowUp extends Activity implements View.OnClickListener, OnItemSelectedListener {

	//Shared Preferences
		public static final String PREFS_NAME = "RSRToolboxData";	
		SharedPrefs sp = new SharedPrefs();
		SharedPreferences settings;
		SharedPreferences.Editor editor;
	
	//XML Variables
	//Spinners
		Spinner choice_spinner;
		String[]daily_paths = {"Activation Fee OCC", "Other OCC", "Change Price Plan", "Call Customer", "Speak With Manager", "Other"};

	//EditTexts
		EditText follow_up_edit_text_customer_name, follow_up_edit_text_customer_number, follow_up_edit_text_occ_amount, 
		follow_up_edit_text_manager, follow_up_edit_text_length_of_time, follow_up_edit_text_notes;
		
	//Buttons
		Button follow_up_button_create_event, follow_up_button_remind_me_later;

	//StatusBar and Notification Manager Stuff
	    NotificationManager nm;
	    static final int uniqueID = 65467537;			
	    
	//Misc Variables
	    Double occ_amount;
	    
	    long days_till_end, secondsStart, secondsEnd;
		int duration;
	    
	    String occ, manager, customer_name, customer_number, notes;
	
	//Main - When the activity starts
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.follow_up);
		Initialize();
		
		
	}

	//Initialize Variables
	private void Initialize(){
		
		//Shared Preferences Stuff
			settings = getSharedPreferences(PREFS_NAME, 0);
			editor = settings.edit();
		
		//Array Adapter for Spinner use with the daily tab
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, daily_paths); //The android.R.layout.simple_spinner_item is embedded system
			
		//Spinner setup
			choice_spinner = (Spinner) findViewById(R.id.follow_up_choice_spinner); //Define from input_schedule.xml
			choice_spinner.setAdapter(adapter);
			choice_spinner.setOnItemSelectedListener(this);
	
		//XML Variables
			follow_up_edit_text_customer_name = (EditText) findViewById(R.id.follow_up_edit_text_customer_name);
			follow_up_edit_text_customer_number = (EditText) findViewById(R.id.follow_up_edit_text_customer_number);
			follow_up_edit_text_occ_amount = (EditText) findViewById(R.id.follow_up_edit_text_occ_amount);
			follow_up_edit_text_manager = (EditText) findViewById(R.id.follow_up_edit_text_manager);
			follow_up_edit_text_length_of_time = (EditText) findViewById(R.id.follow_up_edit_text_length_of_time);
			follow_up_edit_text_notes = (EditText) findViewById(R.id.follow_up_edit_text_notes);
			follow_up_button_create_event = (Button) findViewById(R.id.follow_up_button_create_event);
			follow_up_button_remind_me_later = (Button) findViewById(R.id.follow_up_button_remind_me_later);
			
		//Buttons to onclicklistener
			follow_up_button_create_event.setOnClickListener(this);
		
		//Set default edit_text numbers
		    follow_up_edit_text_customer_name.setText("Customer");
		    follow_up_edit_text_customer_number.setText("0");
		    follow_up_edit_text_occ_amount.setText("0.0");
		    follow_up_edit_text_manager.setText("Name");
		    follow_up_edit_text_length_of_time.setText("1");
		    follow_up_edit_text_notes.setText("Notes Go Here");
		    
		//Doubles and Longs
		    secondsStart = secondsEnd = 0;
		    days_till_end = duration = 1;
		    occ_amount = 0.0;
		    
		//Remind me later
		    follow_up_button_remind_me_later.setOnClickListener(new OnClickListener(){
				public void onClick(View v){
					addNotification();
					finish();
				}
			});
		    
	    //Notification Manager/ Drop-down reminders
		//Define the notification manager
			nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
			
		//Cancel the specific ID once the app has been re-opened/ resumed
			nm.cancel(uniqueID);
			
		//IMPORTANT: Must call this to remove the notification bar. If calling different class, have to put this method call in there so it can close the notification
			removeNotification();		    
	}
	
	//On Click Method
	@Override
	public void onClick(View arg0) {
		
		switch (arg0.getId()){
		
		case R.id.follow_up_button_create_event:
			CreateEvent();
			makeToast("Creating Follow-up");
			break;
			
			
		}
	}
	
	//When an item is selected with the spinner
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		//Position variable to determine which option the spinner is pointing to
		int position = choice_spinner.getSelectedItemPosition();
		switch (position){
		
		//Activation Fee OCC
		case 0:
			occ_amount = 35.00;
			follow_up_edit_text_occ_amount.setText("35.00");
			follow_up_edit_text_length_of_time.setText("15");
			follow_up_edit_text_notes.setText("Activation fee credit. Reason = ");			
			break;
			
		//Other OCC
		case 1:
			occ_amount = 0.0;
			follow_up_edit_text_occ_amount.setText("0.0");
			follow_up_edit_text_length_of_time.setText("1");
			follow_up_edit_text_notes.setText("OCC credit. Reason = ");		
			break;
			
		//Change Price Plan
		case 2:
			occ_amount = 0.0;
			follow_up_edit_text_occ_amount.setText("0.0");
			follow_up_edit_text_length_of_time.setText("1");
			follow_up_edit_text_notes.setText("Price plan change. Change plan to ");	
			break;
							
		//Call Customer
		case 3:
			occ_amount = 0.0;
			follow_up_edit_text_occ_amount.setText("0.0");
			follow_up_edit_text_length_of_time.setText("1");
			follow_up_edit_text_notes.setText("Call Customer back! Reason = ");		
			break;
			
		//Speak With Manager
		case 4:
			occ_amount = 0.0;
			follow_up_edit_text_occ_amount.setText("0.0");
			follow_up_edit_text_length_of_time.setText("1");
			follow_up_edit_text_notes.setText("Remember to speak with ");	
			break;	
			
		//Other
		case 5:
			occ_amount = 0.0;
			follow_up_edit_text_occ_amount.setText("0.0");
			follow_up_edit_text_length_of_time.setText("1");
			follow_up_edit_text_notes.setText("Info");	
			break;							
		}
	}
	
	//Create New Calendar Event
	public void CreateEvent(){
		//First run method that calculates all end times
		
		//Gets the current time in seconds
		Calendar mycal = Calendar.getInstance();
		
		//secondsStart = c.get(Calendar.SECOND);
		GetEndTimes(); //Get the end times
		
		//Get Strings from EditTexts
		occ = follow_up_edit_text_occ_amount.getText().toString();
		manager = follow_up_edit_text_manager.getText().toString();
		customer_name = follow_up_edit_text_customer_name.getText().toString();
		customer_number = follow_up_edit_text_customer_number.getText().toString();
		notes = follow_up_edit_text_notes.getText().toString();
		
		String superString = notes + "\nOCC: " + occ + "\nManager Involved: " + manager + "\nCustomer: " + customer_name + "\nCustomer Number: " + customer_number;
		
		//Create an intent that will enter data into the calendar
		Intent calIntent = new Intent(Intent.ACTION_INSERT);
		calIntent.setType("vnd.android.cursor.item/event");
	
		//Put information in
		calIntent.putExtra(Events.TITLE, "Follow-up"); 
		calIntent.putExtra(Events.EVENT_LOCATION, sp.getString(settings, "work_address", "Address")); 
		calIntent.putExtra(Events.DESCRIPTION, superString);
		
		//Increment the date by X days
		mycal.add(mycal.DATE, duration);
		
		//Start and end time
		long startTime = mycal.getTimeInMillis(); //Convert to milliseconds
		long endTime = startTime+900000; //15 minutes
		
		//Put the calculated start and end time into the calIntent Intent
		calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTime);
		calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime);

		//Puts event into calendar
		startActivity(calIntent); 
		
	}
	
	//This calculates the end times for all of the variables based upon the duration time of event
	public void GetEndTimes(){
		//This section gets the start times from the editTexts and calculates the end time
		//These specifically check to make sure that the edittext fields have a value
		if (follow_up_edit_text_length_of_time.getText().toString().equals("")){
			//
		} else {
			duration = Integer.parseInt(follow_up_edit_text_length_of_time.getText().toString());
		}
	}	
	
	//Adds the notification bar to the top of the 
	public void addNotification() {

    	String body = "Go back and finish putting in Follow-up!";
		String title = "Reminder:";
		
	    NotificationCompat.Builder builder =  
	            new NotificationCompat.Builder(this)  
	            .setSmallIcon(R.drawable.calendar_icon_large)  
	            .setContentTitle(title)  
	            .setContentText(body);  

	    //Change what you want opened here in the second Parameter VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV
	    Intent notificationIntent = new Intent(this, FollowUp.class);  
	    PendingIntent intent = PendingIntent.getActivity(this, 0, notificationIntent,   
	            PendingIntent.FLAG_UPDATE_CURRENT);  
	    builder.setContentIntent(intent);  
	
	    //Add as notification  
	    NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);  
	    manager.notify(uniqueID, builder.build());  
    }  
	
	//This removes an item from the notification bar
	private void removeNotification() {  
	    NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);  
	    manager.cancel(uniqueID);  
	}
	

	protected void onPause() {
		super.onPause();
	}
	
	protected void onResume(){
		super.onResume();
		
	}

	//Not used atm
	public void onNothingSelected(AdapterView<?> arg0) {		
	}
	

	//Simple class that makes a popup (toast) with text
	public void makeToast(String activityChosen){
		Toast.makeText(getApplicationContext(), activityChosen, Toast.LENGTH_SHORT).show();
	}
		

}
