package com.pgmacdesign.rsrtoolbox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class BugReport extends Activity implements View.OnClickListener, OnCheckedChangeListener {

	//Fields to actually edit and send text to the console/ memory
	EditText bug_report_stuff, recommendations;
	
	String emailAdd, to_field, subject, reference_point, bulk_message;
	
	//sends the email to the pgmacdesign email
	Button send_bug_report;
	
	//Radio Button group for the choice of bug report or recommendation
	RadioGroup bug_or_recommend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bug_report);
		
		//Initializing method
		initialize();
		
		//The OnCheckChangeListener, when the radio button is selected
		bug_or_recommend.setOnCheckedChangeListener(this);
		
		//The onclicklistener, when the button is clicked
		send_bug_report.setOnClickListener(this);
		
	}

	//Initializes variables
	private void initialize() {
		
		to_field = "PGMacDesign@gmail.com";
		subject = "null";
		reference_point = "null";
		bug_report_stuff = (EditText) findViewById(R.id.info_for_bug_report);
		send_bug_report = (Button) findViewById(R.id.send_bug_report);

		bug_or_recommend = (RadioGroup) findViewById(R.id.radio_group_bug);

		
	}
	
	//Grabs text from the fields and converts it to strings
	private void convertEditTextVarsIntoStrings() {

		bulk_message = bug_report_stuff.getText().toString();

	}

	//This is what happens when the button is clicked
	public void onClick(View v) {
		// TODO Auto-generated method stub

		//Run the method that makes strings from the fields
		convertEditTextVarsIntoStrings();
		
		//Email address (to send to) Creates an array of a single string
		String emailaddress[] = { to_field };
		
		
		
		//The"Message" portion of the email
		String message = "\n     "
				+ bulk_message
				+ "\n\n DO NOT EDIT BELOW THIS LINE:\n"
				+ reference_point
				+ "\n /End";
		
		

		//Below code is to actually send an email. Use this for report a bug
		
		//android.content.Intent.Action_X has a ton of stuff, look it up for more
		Intent email_Intent_Bug = new Intent(android.content.Intent.ACTION_SEND);
		
		//Takes in a string array as second parameter, IE, why line: String emailaddress[] = { emailAdd }; exists
		//This is the "to" field of the email
		email_Intent_Bug.putExtra(android.content.Intent.EXTRA_EMAIL, emailaddress);
		
		//For the subject line
		email_Intent_Bug.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
		
		//Standard formatting/ font
		email_Intent_Bug.setType("plain/text");
		
		//Adds in the message/ bulk of the email
		email_Intent_Bug.putExtra(android.content.Intent.EXTRA_TEXT, message);
		
		//Actually starts the activity, don't forget or it won't work!
		startActivity(email_Intent_Bug);
		
	}

	@Override
	/*
	 * On pause method needed because this opens up the new window to the "choose email"
	 * function and causes the program to move to the background. Needs to stay open
	 * @see android.app.Activity#onPause()
	 */
	protected void onPause() {

		super.onPause();
		finish();
	}

	@Override
	//Choose which radio button to pick (bug or recommendation)
	public void onCheckedChanged(RadioGroup bug_or_recommend, int arg1) {
		
		//
		switch(arg1){
		case R.id.bugReport:
			subject = "Bug Report";
			reference_point = "App_thenewbostoneclipsetest01, ID_Bug_Report";
			
			break;
			
		case R.id.feedback:
			subject = "Feedback";
			reference_point = "App_thenewbostoneclipsetest01, ID_Feedback";
			
			break;
		}
		
	}

}