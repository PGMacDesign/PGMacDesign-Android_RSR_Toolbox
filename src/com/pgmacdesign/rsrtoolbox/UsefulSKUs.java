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
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.EditText;

//This activity will hold useful SKUs that are used on a regular basis but are generally looked up 
//Suspended at the moment pending approval on proprietary SKUs 
public class UsefulSKUs extends Activity implements View.OnClickListener {

	EditText test_height, test_width;
	
	
	//Main - When the activity starts
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);
		Initialize();
		
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int width = size.x;
		int height = size.y;
		
		test_height.setText(Integer.toString(height));
		test_width.setText(Integer.toString(width));
		
	}

	//Initialize Variables
	private void Initialize(){
		test_height = (EditText) findViewById(R.id.test_height);
		test_width = (EditText) findViewById(R.id.test_width);
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
