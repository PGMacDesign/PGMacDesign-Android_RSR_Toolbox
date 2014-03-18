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
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

//This is the splash screen that pops up when the app opens up
public class SplashScreen extends Activity {

MediaPlayer ourIntroSong, doorClose; //Doorclose not used at this point, will setup for transitional sound at some point
	
	@Override
	protected void onCreate(Bundle inputVariableToSendToSuperClass) {

		super.onCreate(inputVariableToSendToSuperClass);
		setContentView(R.layout.splash);
		
		//Remember: Sound pool used for small clips (gun, explosion, etc.) and Media player used for larger clips (background music)
		ourIntroSong = MediaPlayer.create(SplashScreen.this, R.raw.cinematic_impact);
		MediaPlayer doorClose = MediaPlayer.create(SplashScreen.this, R.raw.door_close_1);
		
		//getPrefs variable to determine if they have turned off the music preference in the introduction
		SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean music = getPrefs.getBoolean("checkBox", true);
		if (music == true){
			ourIntroSong.start();
		}
	
		//Determines length of time splash screen is open
		Thread timer = new Thread()
		{
			public void run()
			{
				try
				{
					//In Milliseconds, set to 3 seconds at this point
					sleep(1000);
				} catch (InterruptedException e01) {
					String error_in_splash = e01.toString(); //For Debugging purposes
					e01.printStackTrace();
				} finally {
					//After thread has run, transition to main class for menu options
					Intent openMain = new Intent("com.pgmacdesign.rsrtoolbox.MAIN");
					startActivity(openMain);
				}
			}
		};

		timer.start();
		
	}

	@Override
	protected void onPause() {
		super.onPause();
		
		//This kills the music so it isn't carried over between splash screens
		ourIntroSong.release();
		
		//Destroys the class when it goes on pause. Not ideal for most programs, but, for a splash screen, this works fine as we don't want it to show up again. 
		finish(); 
	}	
}