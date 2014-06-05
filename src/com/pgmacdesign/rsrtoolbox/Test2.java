package com.pgmacdesign.rsrtoolbox;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class Test2 extends Activity implements View.OnClickListener {

	//Shared Preferences
	public static final String PREFS_NAME = "RSRToolboxData";	
	SharedPrefs sp = new SharedPrefs();
	SharedPreferences settings;
	SharedPreferences.Editor editor;
	
	//Main - When the activity starts
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.XML_FILE);

		//Initialize Variables
		Initialize();
		
		
	}

	//Initialize Variables
	private void Initialize(){
		//Shared Preferences Stuff
		settings = getSharedPreferences(PREFS_NAME, 0);
		editor = settings.edit();
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

}
