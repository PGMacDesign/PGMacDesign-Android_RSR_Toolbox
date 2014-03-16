package com.pgmacdesign.rsrtoolbox;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class ShareThisApp extends Activity implements View.OnClickListener {

	//Global Variables
	
	
	//Main - When the activity starts
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.XML_FILE);
		Initialize();
		
		
	}

	//Initialize Variables
	private void Initialize(){
		
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
