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

import java.util.Calendar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;

//This is just test code. Hold here until needed
public class TEST {

	
	
	
	

	
	/*
	This code is to check if a database exists in the app data:
			
		databaseFile = getApplicationContext().getDatabasePath("RSRToolbox.db");	
		boolean dbExists = DoesDatabaseExist();
		
		if (dbExists){
			//Do stuff
		} else if (!dbExists){
			//Do other stuff
		}
	
	
	//////////////////////////////////////////////////////////////
	 * 
	 
	 //This code is for rounding numbers
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	
	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	
	//////////////////////////////////////////////////////////////
	
	//This code is for entering and retrieving shared preferences

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
	
	/*
	sp.putDouble(editor, "test_double", 1.22);
	editor.commit();
	sp.putString(editor, "work_location_home", "123 Fake Street, New York, NY 12345");
	editor.commit();
	
	double dbl = sp.getDouble(settings, "test_double", 0.0);
	String str = sp.getString(settings, "work_location_home", "Work");
	*/
	/////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	//SQL Variables
    public static final String TABLE_NAME = "commissions";
    public static final String COLUMN_NAME_EMPLOYEE_ID = "COLUMN_NAME_EMPLOYEE_ID";
    public static final String COLUMN_NAME_EMPLOYEE_NAME = "COLUMN_NAME_EMPLOYEE_NAME";
    public static final String COLUMN_NAME_AT_RISK = "COLUMN_NAME_AT_RISK";
    public static final String COLUMN_NAME_UPGRADE_QUOTA = "COLUMN_NAME_UPGRADE_QUOTA";
    public static final String COLUMN_NAME_GG_QUOTA = "COLUMN_NAME_GG_QUOTA";
    public static final String COLUMN_NAME_GG_CURRENT = "COLUMN_NAME_GG_CURRENT";
    public static final String COLUMN_NAME_GG_CHARGE_BACKS = "COLUMN_NAME_GG_CHARGE_BACKS";
    public static final String COLUMN_NAME_NET_GAINS_CURRENT = "COLUMN_NAME_NET_GAINS_CURRENT";
    public static final String COLUMN_NAME_GG_MULTIPLIER = "COLUMN_NAME_GG_MULTIPLIER";
    public static final String COLUMN_NAME_GG_RUN_RATE = "COLUMN_NAME_GG_RUN_RATE";
    public static final String COLUMN_NAME_SALES_DOLLARS_QUOTA = "COLUMN_NAME_SALES_DOLLARS_QUOTA";
    public static final String COLUMN_NAME_SALES_DOLLARS_CURRENT = "COLUMN_NAME_SALES_DOLLARS_CURRENT";
    public static final String COLUMN_NAME_SALES_DOLLARS_MULTIPLIER = "COLUMN_NAME_SALES_DOLLARS_MULTIPLIER";
    public static final String COLUMN_NAME_VACATION_RELIEF_PERCENT = "COLUMN_NAME_VACATION_RELIEF_PERCENT";
    public static final String COLUMN_NAME_STRATEGIC_PULL_THROUGH_QUOTA = "COLUMN_NAME_STRATEGIC_PULL_THROUGH_QUOTA";
    public static final String COLUMN_NAME_STRATEGIC_PULL_THROUGH_CURRENT = "COLUMN_NAME_STRATEGIC_PULL_THROUGH_CURRENT";
    public static final String COLUMN_NAME_STRATEGIC_PULL_THROUGH_RANK = "COLUMN_NAME_STRATEGIC_PULL_THROUGH_RANK"; //Rank will determine which box and which multiplier
    public static final String COLUMN_NAME_STRATEGIC_ACC_QUOTA = "COLUMN_NAME_STRATEGIC_ACC_QUOTA";
    public static final String COLUMN_NAME_STRATEGIC_ACC_CURRENT = "COLUMN_NAME_STRATEGIC_ACC_CURRENT";
    public static final String COLUMN_NAME_STRATEGIC_ACC_RANK = "COLUMN_NAME_STRATEGIC_ACC_RANK"; //Rank will determine which box and which multiplier
    public static final String COLUMN_NAME_STRATEGIC_MULTIPLIER = "COLUMN_NAME_STRATEGIC_MULTIPLIER";
    public static final String COLUMN_NAME_SPIFFS = "COLUMN_NAME_SPIFFS";
    public static final String COLUMN_NAME_FINAL_COMMISSIONS = "COLUMN_NAME_FINAL_COMMISSIONS";
    
    public static final String TEXT_TYPE = " TEXT";
    public static final String COMMA = ",";
    
    //String to create the database
    public static final String SQL_CREATE_TABLE =
    		"CREATE TABLE " + 
    		TABLE_NAME + " (" +
    		COLUMN_NAME_AT_RISK + " TEXT NOT NULL" + COMMA +
    		COLUMN_NAME_UPGRADE_QUOTA +" TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_GG_QUOTA + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_GG_CURRENT + " TEXT NOT NULL"+ COMMA +
        	COLUMN_NAME_GG_CHARGE_BACKS + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_NET_GAINS_CURRENT + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_GG_MULTIPLIER + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_GG_RUN_RATE + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_SALES_DOLLARS_QUOTA + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_SALES_DOLLARS_CURRENT + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_SALES_DOLLARS_MULTIPLIER + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_VACATION_RELIEF_PERCENT + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_STRATEGIC_PULL_THROUGH_QUOTA + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_STRATEGIC_PULL_THROUGH_CURRENT + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_STRATEGIC_PULL_THROUGH_RANK + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_STRATEGIC_ACC_QUOTA + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_STRATEGIC_ACC_CURRENT + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_STRATEGIC_ACC_RANK + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_STRATEGIC_MULTIPLIER + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_SPIFFS + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_FINAL_COMMISSIONS + " TEXT NOT NULL" +
        	" )";
    
    //String to create the table if it does not exist
    public static final String set_default_values_to_zero = 
    		"CREATE TABLE IF NOT EXISTS " +
    		TABLE_NAME + " (" +
    		COLUMN_NAME_AT_RISK + " REAL 0" + COMMA +
    		COLUMN_NAME_UPGRADE_QUOTA + " REAL 0" + COMMA +
        	COLUMN_NAME_GG_QUOTA + " REAL 0" + COMMA +
        	COLUMN_NAME_GG_CURRENT + " REAL 0" + COMMA +
        	COLUMN_NAME_GG_CHARGE_BACKS + " REAL 0" + COMMA +
        	COLUMN_NAME_NET_GAINS_CURRENT + " REAL 0" + COMMA +
        	COLUMN_NAME_GG_MULTIPLIER + " REAL 0" + COMMA +
        	COLUMN_NAME_GG_RUN_RATE + " REAL 0" + COMMA +
        	COLUMN_NAME_SALES_DOLLARS_QUOTA + " REAL 0" + COMMA +
        	COLUMN_NAME_SALES_DOLLARS_CURRENT + " REAL 0" + COMMA +
        	COLUMN_NAME_SALES_DOLLARS_MULTIPLIER + " REAL 0" + COMMA +
        	COLUMN_NAME_VACATION_RELIEF_PERCENT + " REAL 0" + COMMA +
        	COLUMN_NAME_STRATEGIC_PULL_THROUGH_QUOTA + " REAL 0" + COMMA +
        	COLUMN_NAME_STRATEGIC_PULL_THROUGH_CURRENT + " REAL 0" + COMMA +
        	COLUMN_NAME_STRATEGIC_PULL_THROUGH_RANK + " REAL 0" + COMMA +
        	COLUMN_NAME_STRATEGIC_ACC_QUOTA + " REAL 0" + COMMA +
        	COLUMN_NAME_STRATEGIC_ACC_CURRENT + " REAL 0" + COMMA +
        	COLUMN_NAME_STRATEGIC_ACC_RANK + " REAL 0" + COMMA +
        	COLUMN_NAME_STRATEGIC_MULTIPLIER + " REAL 0" + COMMA +
        	COLUMN_NAME_SPIFFS + " REAL 0" + COMMA +
        	COLUMN_NAME_FINAL_COMMISSIONS + " REAL 0" +
        	" )"; 
    
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "RSRToolbox.db";
    
    //Columns
	public static final String[] COLUMNS = {
	      "COLUMN_NAME_EMPLOYEE_ID" 
	      , "COLUMN_NAME_EMPLOYEE_NAME"
	      , "COLUMN_NAME_AT_RISK"  
	      , "COLUMN_NAME_UPGRADE_QUOTA"  
	      , "COLUMN_NAME_GG_QUOTA"  
	      , "COLUMN_NAME_GG_CURRENT"  
	      , "COLUMN_NAME_GG_CHARGE_BACKS"  
	      , "COLUMN_NAME_NET_GAINS_CURRENT"  
	      , "COLUMN_NAME_GG_MULTIPLIER"  
	      , "COLUMN_NAME_GG_RUN_RATE"  
	      , "COLUMN_NAME_SALES_DOLLARS_QUOTA"  
	      , "COLUMN_NAME_SALES_DOLLARS_CURRENT"  
	      , "COLUMN_NAME_SALES_DOLLARS_MULTIPLIER"  
	      , "COLUMN_NAME_VACATION_RELIEF_PERCENT"  
	      , "COLUMN_NAME_STRATEGIC_PULL_THROUGH_QUOTA"  
	      , "COLUMN_NAME_STRATEGIC_PULL_THROUGH_CURRENT"  
	      , "COLUMN_NAME_STRATEGIC_PULL_THROUGH_RANK"   
	      , "COLUMN_NAME_STRATEGIC_ACC_QUOTA"      
	      , "COLUMN_NAME_STRATEGIC_ACC_CURRENT"  
	      , "COLUMN_NAME_STRATEGIC_ACC_RANK"   
	      , "COLUMN_NAME_STRATEGIC_MULTIPLIER"  
	      , "COLUMN_NAME_SPIFFS"  
	      , "COLUMN_NAME_FINAL_COMMISSIONS"
	};
	
	
	    //String to create the database
    public static final String SQL_CREATE_TABLE =
    		"CREATE TABLE " + 
    		TABLE_NAME + " (" +
    		COLUMN_NAME_AT_RISK + " TEXT DEFAULT \'50\'" + COMMA +
    		COLUMN_NAME_UPGRADE_QUOTA +" TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_GG_QUOTA + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_GG_CURRENT + " TEXT NOT NULL"+ COMMA +
        	COLUMN_NAME_GG_CHARGE_BACKS + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_NET_GAINS_CURRENT + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_GG_MULTIPLIER + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_GG_RUN_RATE + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_SALES_DOLLARS_QUOTA + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_SALES_DOLLARS_CURRENT + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_SALES_DOLLARS_MULTIPLIER + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_VACATION_RELIEF_PERCENT + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_STRATEGIC_PULL_THROUGH_QUOTA + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_STRATEGIC_PULL_THROUGH_CURRENT + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_STRATEGIC_PULL_THROUGH_RANK + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_STRATEGIC_ACC_QUOTA + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_STRATEGIC_ACC_CURRENT + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_STRATEGIC_ACC_RANK + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_STRATEGIC_MULTIPLIER + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_SPIFFS + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_FINAL_COMMISSIONS + " TEXT NOT NULL" +
        	" )";
        	
        	
        	
        	
        	
        	
        	
        		
    //SQL Variables
    public static final String TABLE_NAME = "commissions";
    public static final String COLUMN_NAME_EMPLOYEE_ID = "emp_id";
    public static final String COLUMN_NAME_EMPLOYEE_NAME = "emp_name";
    public static final String COLUMN_NAME_AT_RISK = "at_risk";
    public static final String COLUMN_NAME_UPGRADE_QUOTA = "up_quota";
    public static final String COLUMN_NAME_GG_QUOTA = "gg_quota";
    public static final String COLUMN_NAME_GG_CURRENT = "gg_current";
    public static final String COLUMN_NAME_GG_CHARGE_BACKS = "charge_backs";
    public static final String COLUMN_NAME_NET_GAINS_CURRENT = "net_gains";
    public static final String COLUMN_NAME_GG_MULTIPLIER = "gg_multiplier";
    public static final String COLUMN_NAME_GG_RUN_RATE = "gg_run_rate";
    public static final String COLUMN_NAME_SALES_DOLLARS_QUOTA = "sales_dollars_quota";
    public static final String COLUMN_NAME_SALES_DOLLARS_CURRENT = "sales_dollars_current";
    public static final String COLUMN_NAME_SALES_DOLLARS_MULTIPLIER = "sales_dollars_multiplier";
    public static final String COLUMN_NAME_VACATION_RELIEF_PERCENT = "vaca_relief";
    public static final String COLUMN_NAME_STRATEGIC_PULL_THROUGH_QUOTA = "pt_quota";
    public static final String COLUMN_NAME_STRATEGIC_PULL_THROUGH_CURRENT = "pt_current";
    public static final String COLUMN_NAME_STRATEGIC_PULL_THROUGH_RANK = "pt_rank"; //Rank will determine which box and which multiplier
    public static final String COLUMN_NAME_STRATEGIC_ACC_QUOTA = "acc_quota";
    public static final String COLUMN_NAME_STRATEGIC_ACC_CURRENT = "acc_current";
    public static final String COLUMN_NAME_STRATEGIC_ACC_RANK = "acc_rank"; //Rank will determine which box and which multiplier
    public static final String COLUMN_NAME_STRATEGIC_MULTIPLIER = "strategic_multiplier";
    public static final String COLUMN_NAME_SPIFFS = "spiffs";
    public static final String COLUMN_NAME_FINAL_COMMISSIONS = "final_commissions";
    
    public static final String TEXT_TYPE = " TEXT";
    public static final String COMMA = ",";
    
    //String to create the database
    public static final String SQL_CREATE_TABLE =
    		"CREATE TABLE " + 
    		TABLE_NAME + " (" +
    		COLUMN_NAME_AT_RISK + " TEXT DEFAULT \'50\'" + COMMA +
    		COLUMN_NAME_UPGRADE_QUOTA +" TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_GG_QUOTA + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_GG_CURRENT + " TEXT NOT NULL"+ COMMA +
        	COLUMN_NAME_GG_CHARGE_BACKS + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_NET_GAINS_CURRENT + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_GG_MULTIPLIER + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_GG_RUN_RATE + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_SALES_DOLLARS_QUOTA + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_SALES_DOLLARS_CURRENT + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_SALES_DOLLARS_MULTIPLIER + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_VACATION_RELIEF_PERCENT + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_STRATEGIC_PULL_THROUGH_QUOTA + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_STRATEGIC_PULL_THROUGH_CURRENT + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_STRATEGIC_PULL_THROUGH_RANK + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_STRATEGIC_ACC_QUOTA + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_STRATEGIC_ACC_CURRENT + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_STRATEGIC_ACC_RANK + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_STRATEGIC_MULTIPLIER + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_SPIFFS + " TEXT NOT NULL" + COMMA +
        	COLUMN_NAME_FINAL_COMMISSIONS + " TEXT NOT NULL" +
        	" )";
    
    //String to create the table if it does not exist
    public static final String set_default_values_to_zero = 
    		"CREATE TABLE IF NOT EXISTS " +
    		TABLE_NAME + " (" +
    		COLUMN_NAME_AT_RISK + " REAL 0" + COMMA +
    		COLUMN_NAME_UPGRADE_QUOTA + " REAL 0" + COMMA +
        	COLUMN_NAME_GG_QUOTA + " REAL 0" + COMMA +
        	COLUMN_NAME_GG_CURRENT + " REAL 0" + COMMA +
        	COLUMN_NAME_GG_CHARGE_BACKS + " REAL 0" + COMMA +
        	COLUMN_NAME_NET_GAINS_CURRENT + " REAL 0" + COMMA +
        	COLUMN_NAME_GG_MULTIPLIER + " REAL 0" + COMMA +
        	COLUMN_NAME_GG_RUN_RATE + " REAL 0" + COMMA +
        	COLUMN_NAME_SALES_DOLLARS_QUOTA + " REAL 0" + COMMA +
        	COLUMN_NAME_SALES_DOLLARS_CURRENT + " REAL 0" + COMMA +
        	COLUMN_NAME_SALES_DOLLARS_MULTIPLIER + " REAL 0" + COMMA +
        	COLUMN_NAME_VACATION_RELIEF_PERCENT + " REAL 0" + COMMA +
        	COLUMN_NAME_STRATEGIC_PULL_THROUGH_QUOTA + " REAL 0" + COMMA +
        	COLUMN_NAME_STRATEGIC_PULL_THROUGH_CURRENT + " REAL 0" + COMMA +
        	COLUMN_NAME_STRATEGIC_PULL_THROUGH_RANK + " REAL 0" + COMMA +
        	COLUMN_NAME_STRATEGIC_ACC_QUOTA + " REAL 0" + COMMA +
        	COLUMN_NAME_STRATEGIC_ACC_CURRENT + " REAL 0" + COMMA +
        	COLUMN_NAME_STRATEGIC_ACC_RANK + " REAL 0" + COMMA +
        	COLUMN_NAME_STRATEGIC_MULTIPLIER + " REAL 0" + COMMA +
        	COLUMN_NAME_SPIFFS + " REAL 0" + COMMA +
        	COLUMN_NAME_FINAL_COMMISSIONS + " REAL 0" +
        	" )"; 
    
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "RSRToolbox.db";
    
    //Columns
	public static final String[] COLUMNS = {
	      "emp_id" 
	      , "emp_name"
	      , "at_risk"  
	      , "up_quota"  
	      , "gg_quota"  
	      , "gg_current"  
	      , "charge_backs"  
	      , "net_gains"  
	      , "gg_multiplier"  
	      , "gg_run_rate"  
	      , "sales_dollars_quota"  
	      , "sales_dollars_current"  
	      , "sales_dollars_multiplier"  
	      , "vaca_relief"  
	      , "pt_quota"  
	      , "pt_current"  
	      , "pt_rank"   
	      , "acc_quota"      
	      , "acc_current"  
	      , "acc_rank"   
	      , "strategic_multiplier"  
	      , "spiffs"  
	      , "final_commissions"
	};

    //String to create the database
    public static final String SQL_CREATE_TABLE =
    		"CREATE TABLE " + 
    		TABLE_NAME + " (" +
    		COLUMN_NAME_AT_RISK + " TEXT DEFAULT \'0\'" + COMMA +
    		COLUMN_NAME_UPGRADE_QUOTA + " TEXT DEFAULT \'0\'" + COMMA +
        	COLUMN_NAME_GG_QUOTA + " TEXT DEFAULT \'0\'" + COMMA +
        	COLUMN_NAME_GG_CURRENT + " TEXT DEFAULT \'0\'" + COMMA +
        	COLUMN_NAME_GG_CHARGE_BACKS + " TEXT DEFAULT \'0\'" + COMMA +
        	COLUMN_NAME_NET_GAINS_CURRENT + " TEXT DEFAULT \'0\'" + COMMA +
        	COLUMN_NAME_GG_MULTIPLIER + " TEXT DEFAULT \'0\'" + COMMA +
        	COLUMN_NAME_GG_RUN_RATE + " TEXT DEFAULT \'0\'" + COMMA +
        	COLUMN_NAME_SALES_DOLLARS_QUOTA + " TEXT DEFAULT \'0\'" + COMMA +
        	COLUMN_NAME_SALES_DOLLARS_CURRENT + " TEXT DEFAULT \'0\'" + COMMA +
        	COLUMN_NAME_SALES_DOLLARS_MULTIPLIER + " TEXT DEFAULT \'0\'" + COMMA +
        	COLUMN_NAME_VACATION_RELIEF_PERCENT + " TEXT DEFAULT \'0\'" + COMMA +
        	COLUMN_NAME_STRATEGIC_PULL_THROUGH_QUOTA + " TEXT DEFAULT \'0\'" + COMMA +
        	COLUMN_NAME_STRATEGIC_PULL_THROUGH_CURRENT + " TEXT DEFAULT \'0\'" + COMMA +
        	COLUMN_NAME_STRATEGIC_PULL_THROUGH_RANK + " TEXT DEFAULT \'0\'" + COMMA +
        	COLUMN_NAME_STRATEGIC_ACC_QUOTA + " TEXT DEFAULT \'0\'" + COMMA +
        	COLUMN_NAME_STRATEGIC_ACC_CURRENT + " TEXT DEFAULT \'0\'" + COMMA +
        	COLUMN_NAME_STRATEGIC_ACC_RANK + " TEXT DEFAULT \'0\'" + COMMA +
        	COLUMN_NAME_STRATEGIC_MULTIPLIER + " TEXT DEFAULT \'0\'" + COMMA +
        	COLUMN_NAME_SPIFFS + " TEXT DEFAULT \'0\'" + COMMA +
        	COLUMN_NAME_FINAL_COMMISSIONS + " TEXT DEFAULT \'0\'" +
        	" )";
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	*/
}
