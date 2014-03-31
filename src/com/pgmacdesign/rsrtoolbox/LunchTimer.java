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
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//This class is currently on hold. It will eventually be implemented as a countdown timer to mark 30 minutes for lunch
public class LunchTimer extends Activity implements View.OnClickListener {

	//Global Variables
	CountDownTimer cdt;
	
	EditText lunch_timer_edit_text_clock;
	Button lunch_timer_start;
	
	//Main - When the activity starts
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lunch_timer);
		Initialize();

	}

	//Initialize Variables
	private void Initialize(){
		lunch_timer_edit_text_clock = (EditText) findViewById(R.id.lunch_timer_edit_text_clock);
		lunch_timer_start = (Button) findViewById(R.id.lunch_timer_start);
		lunch_timer_start.setOnClickListener(this);
	}
	
	//On Click Method
	@Override
	public void onClick(View arg0) {
		
		switch (arg0.getId()){
		
		case R.id.lunch_timer_start:
			cdt = new CountDownTimer(1800000, 1000) {

			     public void onTick(long millisUntilFinished) {
			    	 lunch_timer_edit_text_clock.setText("seconds remaining: " + millisUntilFinished / 1000);
			     }

			     public void onFinish() {
			    	 lunch_timer_edit_text_clock.setText("done!");
			     }
			  };
			  cdt.start();
			break;
		}	
	}
	
	protected void onPause() {

		super.onPause();
	}

}
