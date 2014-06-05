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
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ShareThisApp extends Activity implements View.OnClickListener{

	//Global Variables
	ImageButton share_this_app_image;
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
		share_this_app_image = (ImageButton) findViewById(R.id.share_this_app_image);
		
		share_this_app_button = (Button) findViewById(R.id.share_this_app_button);
		
		share_this_app_button.setOnClickListener(this);
		
		share_this_app_image.setOnClickListener(this);
	}
	
	//On Click Method
	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()){
		
		case R.id.share_this_app_button:
			try	{ 
				
				//Creates an Intent for choosing a way to share said link. Can be done in text, email, etc.
				Intent i = new Intent(Intent.ACTION_SEND);  
				i.setType("text/plain");
				i.putExtra(Intent.EXTRA_SUBJECT, "RSR Toolbox");
				String sAux = "\nLet me recommend you this application, RSR Toolbox:\n\n";
				sAux = sAux + "https://play.google.com/store/apps/details?id=com.pgmacdesign.rsrtoolbox";
				i.putExtra(Intent.EXTRA_TEXT, sAux);  
				startActivity(Intent.createChooser(i, "Choose a Way to Share This App: "));
				
			} catch(Exception e){ 
				  //e.toString();
			} 
			
			break;
			
		case R.id.share_this_app_image:
			try{
				
				//Opens a link directly to my play store download
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.pgmacdesign.rsrtoolbox"));
				startActivity(browserIntent);
				
			} catch(Exception e){ 
				  //e.toString();
			}  
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
