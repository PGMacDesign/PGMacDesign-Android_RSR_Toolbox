package com.pgmacdesign.rsrtoolbox;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

/*
 * This class is the Splash Screen. It shows an image (PGMacDesign) as
 * well as an intro music/ song (cinematic_impact).
 */
public class Splash extends Activity{

	//Media Player is defined/ explained in onCreate method below
	MediaPlayer ourIntroSong, doorClose;
	
	@Override
	//Right-click --> Source --> Override/ Implement Methods --> onCreate(Bundle)
	protected void onCreate(Bundle inputVariableToSendToSuperClass) {
		// TODO Auto-generated method stub
		super.onCreate(inputVariableToSendToSuperClass);
		setContentView(R.layout.splash);
		
		//Sound pool used for small clips (gun, explosion, etc.)
		//Media player used for larger clips (background music)
		//In this example, create media player variable
		ourIntroSong = MediaPlayer.create(Splash.this, R.raw.cinematic_impact);
		MediaPlayer doorClose = MediaPlayer.create(Splash.this, R.raw.door_close_1);
		
		
		/*
		 * Video 057, setting up access to preferences to have user choose
		 * the intro music for the splash screen. "Shared Preferences"
		 */
		//getPrefs variable checks if something is used
		SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		
		/*
		 * Translates to: If person chooses to have music intro on splash screen,
		 * then it will play. If they do not choose, defaults to true. If they
		 * choose to change it to false, no intro music will play
		 */
		boolean music = getPrefs.getBoolean("checkBox", true);
		
		//
		if (music == true){
			ourIntroSong.start();
		}
		

		
		
		Thread timer = new Thread()
		{
			//Thread is looking for a run method
			public void run()
			{
				try
				{
					//Sleep method is from the thread class. 
					//@Param -- Milliseconds. 5 Seconds = 5000.
					sleep(3000);
				} catch (InterruptedException e01) {
					e01.printStackTrace();
				} finally {
					//Need to import the intent package
					Intent openStartingPoint = new Intent("com.macdowell.thenewbostoneclipsetest01.MENU");
					//@Param -- 'intent' type of variable
					startActivity(openStartingPoint);
				}
			}
		};
		//Thread Variable will start after it has been created above
		timer.start();
		
	}

	//Right-click --> Source --> Override/ Implement Methods --> onPause
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		//This kills the music so it isn't carried over between splash screens
		ourIntroSong.release();
		
		//This destroys the class (deconstruct) when it goes on pause. Not ideal for most programs, but, for
		//...a splash screen, this works fine as we don't want it to show up again. 
		finish(); //Similar to myScanner.close();
		
	}
    
	
}
