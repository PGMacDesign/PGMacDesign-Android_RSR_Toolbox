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
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SharedPrefs extends Activity implements OnClickListener {
	
	//EditTexts
	EditText name, sales_dollars;
	//Button
	Button save_prefs;
	public static final String PREFS_NAME = "RSRToolboxData";
	
	//SharedPreferences Object
	SharedPreferences settings;
	
	
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shared_preferences);
		Initialize();
	}
	
	private void Initialize(){
		
		name = (EditText) findViewById(R.id.shared_preferences_edit_text1);
		sales_dollars = (EditText) findViewById(R.id.shared_preferences_edit_text2);
		
		save_prefs = (Button) findViewById(R.id.shared_preferences_button_share_data);
		save_prefs.setOnClickListener(this);
	}
	
	public void onClick (View v){
		//@Params, 1) String is value of preferences file, 2) 0 
		
		//This code is all needed for putting in data to a Prefs file
		settings = getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString("name", name.getText().toString());
		putDouble(editor, "sales_dollars", 2.4231);
		editor.commit();
		//End putting in data to a Prefs file
		//Begin retrieving data from file
		getDouble(settings, "sales_dollars", 0.0);
		//End retrieving data from file
	}
	
	/*
	 * This allows doubles to be entered into the data field.  
	 * IE) sp.putDouble(editor, "sales_dollars", 2.4231);  @Params,
	 * 1) Editor being used 
	 * 2) Which 'column' the data is being entered to
	 * 3) Value To Enter
	 */
	Editor putDouble (final Editor edit, final String key, final double value){
		return edit.putLong(key, Double.doubleToRawLongBits(value));
	}
	
	/*
	 * Returns a double from the shared preferences data field. @Params,
	 * IE) sp.getDouble(settings, "sales_dollars", 0.0);  @Params,
	 * 1) SharedPreferences Variable (Defined in global variables)
	 * 2) Which 'column' the data is being pulled from
	 * 3) A Default value that will be returned if no value exists there
	 */
	double getDouble(final SharedPreferences prefs, final String key, final double defaultValue){
		return Double.longBitsToDouble(prefs.getLong(key, Double.doubleToLongBits(defaultValue)));
	}
	
	/*
	 * This allows Strings to be entered into the data field.  
	 * IE) sp.putString(editor, "work_location_home", "1401 W Imperial Hwy, La Habra, CA 90631");  @Params,
	 * 1) Editor being used 
	 * 2) Which 'column' the data is being entered to
	 * 3) Value To Enter
	 */
	Editor putString (final Editor edit, final String key, final String value){
		return edit.putString(key, value);
	}
	
	/*
	 * Returns a String from the shared preferences data field. @Params,
	 * IE) sp.getString(settings, "work_location_home", "Work");  @Params,
	 * 1) SharedPreferences Variable (Defined in global variables)
	 * 2) Which 'column' the data is being pulled from
	 * 3) A Default value that will be returned if no value exists there
	 */
	String getString(final SharedPreferences prefs, final String key, final String defaultValue){
		return prefs.getString(key, defaultValue);
	}
}
