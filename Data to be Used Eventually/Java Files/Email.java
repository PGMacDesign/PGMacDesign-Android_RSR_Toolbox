package com.pgmacdesign.rsrtoolbox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email extends Activity implements View.OnClickListener {

	//Fields to actually edit and send text to the console/ memory
	EditText personsEmail, intro, personsName, stupidThings, hatefulAction,
			outro;
	
	//These strings are input by the sender
	String emailAdd, beginning, name, stupidAction, hatefulAct, out;
	
	//sends the email
	Button sendEmail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email);
		
		//Initializing method
		initialize();
		
		//The onclicklistener, when the button is clicked
		sendEmail.setOnClickListener(this);
	}

	//Initializes variables
	private void initialize() {
		// TODO Auto-generated method stub
		personsEmail = (EditText) findViewById(R.id.etEmails);
		intro = (EditText) findViewById(R.id.etIntro);
		personsName = (EditText) findViewById(R.id.etName);
		stupidThings = (EditText) findViewById(R.id.etThings);
		hatefulAction = (EditText) findViewById(R.id.etAction);
		outro = (EditText) findViewById(R.id.etOutro);
		sendEmail = (Button) findViewById(R.id.bSentEmail);
	}
	
	//Grabs text from the fields and converts it to strings
	private void convertEditTextVarsIntoStringsAndYesThisIsAMethodWeCreated() {
		// TODO Auto-generated method stub
		emailAdd = personsEmail.getText().toString();
		beginning = intro.getText().toString();
		name = personsName.getText().toString();
		stupidAction = stupidThings.getText().toString();
		hatefulAct = hatefulAction.getText().toString();
		out = outro.getText().toString();
	}

	//This is what happens when the button is clicked
	public void onClick(View v) {
		// TODO Auto-generated method stub

		//Run the method that makes strings from the fields
		convertEditTextVarsIntoStringsAndYesThisIsAMethodWeCreated();
		
		//Email address (to send to) Creates an array of a single string
		String emailaddress[] = { emailAdd };
		
		//The"Message" portion of the email
		String message = "Well hello "
				+ name
				+ " I just wanted to say "
				+ beginning
				+ ".  Not only that but I hate when you "
				+ stupidAction
				+ ", that just really makes me crazy.  I just want to make you "
				+ hatefulAct
				+ ".  Well, thats all I wanted to chit-chatter about, oh and"
				+ out
				+ ".  Oh also if you get bored you should check out www.mybringback.com"
				+ '\n' + "PS. I think I love you...   :( ";

		//Below code is to actually send an email. Use this for report a bug
		
		//android.content.Intent.Action_X has a ton of stuff, look it up for more
		//Also, look up android.content.Intent.EXTRA_X
		Intent email_Intent = new Intent(android.content.Intent.ACTION_SEND);
		
		//Takes in a string array as second parameter, IE, why line: String emailaddress[] = { emailAdd }; exists
		//This is the "to" field of the email
		email_Intent.putExtra(android.content.Intent.EXTRA_EMAIL, emailaddress);
		
		//For the subject line
		email_Intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Bug Report");
		
		//Standard formatting/ font
		email_Intent.setType("plain/text");
		
		//Adds in the message/ bulk of the email
		email_Intent.putExtra(android.content.Intent.EXTRA_TEXT, message);
		
		//Actually starts the activity, don't forget or it won't work!
		startActivity(email_Intent);
		
		
	}

	@Override
	/*
	 * On pause method needed because this opens up the new window to the "choose email"
	 * function and causes the program to move to the background. Needs to stay open
	 * @see android.app.Activity#onPause()
	 */
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}