package com.pgmacdesign.rsrtoolbox;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/*
 * This Class is a menu activity that gives options. It is the introductory
 * portion that the user sees after the splash screen. There are options
 * listed as an array that the user can choose between to navigate through 
 * the application. 
 */
//Extends ListActivity instead of extends activity because this menu will have multiple options
public class Menu extends ListActivity{

	//First make a string array to hold menu items. Created as global variable as it will be used by both
	String classes[] = {"StartingPoint", "TextPlay", "Email", "Camera", "Data", 
			"Graphics", "GraphicsSurface", "SoundStuff", "Slider", "Tabs", 
			"SimpleBrowser", "Flipper", "SharedPrefs", "ExternalData", 
			"InternalData", "SQLiteExample", "Accelerate", "HttpExample", 
			"WeatherXMLParsing", "NotWorkingATM", "Voice", "TextVoice",
			"StatusBar", "SeekBarVolume"}; 
	
	
			
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		/*
		 * This section will make it full screen. I have commented it out because this is not a game/ movie at this point
		 
		//Make request for full-screen (IE youtube full screen)
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		//Essentially forcing full screen here
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		//The full window MUST be done before the setListAdapter below
		*
		*/
		
		
		//@Param within ArrayAdapter -- middle variable refers to single item within list
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_expandable_list_item_1, classes)); 
	
	}
		
	
	@Override
	//
	protected void onListItemClick(ListView l, View v, int position, long id) {
		//
		super.onListItemClick(l, v, position, id);
		
		String str1 = classes[position]; //This is set to the X position in the class array (example4)
		
		//Try/ Catch starts here
		try
		{
		//This is similar to string for directory/ file -IE- File I/O, String direct = "C:users\doc..." and openFile(direct); 
		Class ourClass = Class.forName("com.macdowell.thenewbostoneclipsetest01." + str1); //Package name + () which can be example4, StartingPoint, etc
		
		//Start a new activity
		//lol at Intent Var Name
		Intent ourIntentIsClear = new Intent(Menu.this, ourClass);
		startActivity(ourIntentIsClear);
		} catch (ClassNotFoundException e02){
			e02.printStackTrace();
		}
	}
	

	@Override
	//
	public boolean onCreateOptionsMenu(android.view.Menu menu_settings) {
		
		//menu inflater 
		MenuInflater blowUp = getMenuInflater(); 
		blowUp.inflate(R.menu.cool_menu, menu_settings);
		return true;
		
	}


	
	@Override
	//
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch(item.getItemId()){
		
		case R.id.aboutus:
			//Bring up a page with about us information
			Intent intent1 = new Intent("com.macdowell.thenewbostoneclipsetest01.ABOUTUS");
			startActivity(intent1);
			
			break;
			
		case R.id.preferences:
			//Bring up a page for the user to adjust preferences
			Intent intent2 = new Intent("com.macdowell.thenewbostoneclipsetest01.PREFS");
			startActivity(intent2);		
			break;
			
		case R.id.send_Bug_Report:
			//Send email to PGMacDesign@gmail.com
			Intent intent3 = new Intent("com.macdowell.thenewbostoneclipsetest01.BUGREPORT");
			startActivity(intent3);	
			break;
						
		case R.id.Exit:
			//Bring up a page for the user to adjust preferences
			finish();
			
			break;
		}
		
		return false;
	}
	
	//
	
	
}
