package com.pgmacdesign.rsrtoolbox;

import android.app.Activity;

//This class is designed to calculate the strategic multiplier via input from the database
public class GGMultiplier extends Activity{

	DatabaseAdmin db = new DatabaseAdmin(this);
	String actual_gg_multiplier = null;
	
	
	
	
	
	
	
	
	
	
	
	
	public String ReturnGGMultiplier(){
		
		return actual_gg_multiplier;
	}
	
}
