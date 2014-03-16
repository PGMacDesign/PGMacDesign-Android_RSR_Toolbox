package com.pgmacdesign.rsrtoolbox;

import android.os.Bundle;
import android.preference.PreferenceActivity;

//Preference activity to coincide with prefs options menu
public class Prefs extends PreferenceActivity {

	@SuppressWarnings("deprecation")
	@Override
	//
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		//notice the reference to R.xml.prefs, not ID
		//Note, need to find fix for deprecated method here
		addPreferencesFromResource(R.xml.prefs);

	}

	//
	
}
