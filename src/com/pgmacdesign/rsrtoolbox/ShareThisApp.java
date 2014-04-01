package com.pgmacdesign.rsrtoolbox;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ShareThisApp extends Activity implements View.OnClickListener{

	//Global Variables
	ImageView share_this_app_image;
	Button share_this_app_button;
	
	//Main - When the activity starts
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.share_this_app);
		Initialize();
		
	}

	//Initialize Variables
	private void Initialize(){
		share_this_app_image = (ImageView) findViewById(R.id.share_this_app_image);
		
		share_this_app_button = (Button) findViewById(R.id.share_this_app_button);
		share_this_app_button.setOnClickListener(this);	
	}
	
	//On Click Method
	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()){
		
		case R.id.share_this_app_button:
			try	{ 
				  Intent i = new Intent(Intent.ACTION_SEND);  
				  i.setType("text/plain");
				  i.putExtra(Intent.EXTRA_SUBJECT, "RSR Toolbox");
				  String sAux = "\nLet me recommend you this application, RSR Toolbox:\n\n";
				  sAux = sAux + "-----------------https://play.google.com/store/apps/details?id=Orion.Soft \n\n   -----------INSERT PLAYSTORE LINK HERE";
				  i.putExtra(Intent.EXTRA_TEXT, sAux);  
				  startActivity(Intent.createChooser(i, "Choose an Option"));
			} catch(Exception e){ 
				  //e.toString();
			} 
			
			break;
		}
	}
	
	protected void onPause() {
		super.onPause();
		finish();
	}

	/*
	 * Extra Code for later:
	 
	 	//This is for sharing all of the apps I have published:
	 	Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("market://search?q=pub:Your Publisher Name"));
		startActivity(intent);

		//This is for sharing a specific app
		Intent intent = new Intent(Intent.ACTION_VIEW);
   		intent.setData(Uri.parse("market://details?id=com.android.example"));
   		startActivity(intent);

	 */

}
