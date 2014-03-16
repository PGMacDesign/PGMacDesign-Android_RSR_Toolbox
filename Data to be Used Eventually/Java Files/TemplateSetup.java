package com.pgmacdesign.rsrtoolbox;

import java.util.Scanner;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TemplateSetup extends Activity implements View.OnClickListener {

	//Global Variables
	
	/*
	 * 
	Button sendEmail;
	EditText personsEmail, intro, personsName, stupidThings, hatefulAction, outro;
	Button checkCommand;
	ToggleButton passwordToggle;
	EditText input;
	TextView displayText;	
	ImageButton image_Button;
	Button button1;
	ImageView image_View;
	Intent intent1;
	Bitmap bmp;	
	*
	*/
	
	
	
	//Initializes all buttons, views, etc
	private void Initialize(){
		
		//Examples of variables to create below
		/*
 
		image_Button = (ImageButton) findViewById(R.id.ID GOES HERE);
		image_View = (ImageView) findViewById(R.id.ID GOES HERE);
		button1 = (Button) findViewById(R.id.ID GOES HERE);	
		checkCommand = (Button) findViewById(R.id.ID GOES HERE);
		passwordToggle = (ToggleButton) findViewById(R.id.ID GOES HERE);
		input = (EditText) findViewById(R.id.ID GOES HERE);
		displayText = (TextView) findViewById(R.id.ID GOES HERE);
		personsEmail = (EditText) findViewById(R.id.ID GOES HERE);
		intro = (EditText) findViewById(R.id.ID GOES HERE);
		personsName = (EditText) findViewById(R.id.ID GOES HERE);
		stupidThings = (EditText) findViewById(R.id.ID GOES HERE);
		hatefulAction = (EditText) findViewById(R.id.ID GOES HERE);
		outro = (EditText) findViewById(R.id.ID GOES HERE);
		sendEmail = (Button) findViewById(R.id.ID GOES HERE);
		
		button1.setOnClickListener(this);
		image_Button.setOnClickListener(this);	
		
		*/
	}
		
	@Override
	//Main
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.put_the_name_of_the_xml_file_here);
		Initialize();
		//
		
	}

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
	
	
}
