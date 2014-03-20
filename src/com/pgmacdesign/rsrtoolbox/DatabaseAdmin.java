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
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

//This class manages the database for the entire application
public class DatabaseAdmin extends SQLiteOpenHelper  {
	
	

	
    //SQL Variables
    public static final String TABLE_NAME = "commissions";
    public static final String COLUMN_NAME_EMPLOYEE_ID = "_emp_id";
    public static final String COLUMN_NAME_EMPLOYEE_NAME = "emp_name";
    public static final String COLUMN_NAME_WORKING_DAYS_LEFT = "work_days_left";
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
    		COLUMN_NAME_EMPLOYEE_ID + " INTEGER PRIMARY KEY" + COMMA + 
    		COLUMN_NAME_WORKING_DAYS_LEFT + " TEXT DEFAULT \'0\'" + COMMA +
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
    
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "RSRToolbox.db";
    
    //Columns
	public static final String[] COLUMNS = {
	     "work_days_left" //0
	      , "at_risk"  //1
	      , "up_quota"  //2
	      , "gg_quota"  //3
	      , "gg_current"  //4
	      , "charge_backs"  //5
	      , "net_gains"  //6
	      , "gg_multiplier" //7 
	      , "gg_run_rate"  //8
	      , "sales_dollars_quota" //9  
	      , "sales_dollars_current"  //10
	      , "sales_dollars_multiplier"  //11
	      , "vaca_relief"  //12
	      , "pt_quota"  //13
	      , "pt_current"  //14
	      , "pt_rank"   //15
	      , "acc_quota"     //16 
	      , "acc_current"  //17
	      , "acc_rank"   //18
	      , "strategic_multiplier" //19  
	      , "spiffs"  //20
	      , "final_commissions" //21
	      //ONLY ADD NEW ITEMS AFTER THIS COLUMN AT POSITION 22 OR LATER
	};

    //Constructor
    public DatabaseAdmin(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    //
    public void onCreate(SQLiteDatabase db) {
        //Creates database
    	db.execSQL(SQL_CREATE_TABLE);
    	//db.close(); //not closed on 2014-03-20
    }
    
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    	
    	db.execSQL("DROP TABLE IF EXISTS commissions");
    	this.onCreate(db);
    }
    
    //Method to insert data into the database
    public void InsertData(String column_name, String value){
    	Log.d("AddItem", value);
    	
    	//String UpdateData = "UPDATE " + TABLE_NAME + " SET " + column_name + " = '" + value + "'";  //Locking database, using method instead
    	
    	//Reference to writeable database
    	SQLiteDatabase db = this.getWritableDatabase();

    	//Create content values to store the data
    	ContentValues values = new ContentValues();
    	values.put(column_name, value);
    	
    	//Database update
    	db.update(TABLE_NAME, values, null, null);
    	
    	//db.execSQL(UpdateData);
    	
    	//Finally, close the db 
    	//db.close();
    }
    
    public void CreateData(String column_name, String value){
    	Log.d("AddItem", value);
    	
    	//Reference to writeable database
    	SQLiteDatabase db = this.getWritableDatabase();
    	
    	//Create content values to store the data
    	ContentValues values = new ContentValues();
    	values.put(column_name, value);

    	db.insert(TABLE_NAME, null, values);
    	
    	//Finally, close the db 
    	//db.close();
    }
    

    //Get data
    public String getData(String column_choice){
    	SQLiteDatabase db = this.getWritableDatabase();
    	String str1 = "Error";
    			
    	try{
	    	//Read data from db
	    	db = this.getReadableDatabase();
	    	
	    	//Create a cursor with the specific query
	    	Cursor cursor = db.query(TABLE_NAME, COLUMNS, column_choice, null, null, null, null);

	    	//Move to the first position of the results (0)
	    	cursor.moveToFirst();
	    	
	    	//Should only be 1 column returned, at position 0, set it to the string
	    	str1 = cursor.getString(0);
	    	//db.close(); //Added 2014-03-20
	    	cursor.close(); //Added 2014-03-20
	    	
	    	//Return the string
    	return str1;
    	} catch (Exception e){
    		e.printStackTrace();
    	} 
    		
    	return str1;	
    }
    
    //Sets all of the values in the database to Default. Basically a month-end wipe
    public void SetDatabaseNumbersToZero(){
    	
    	//Fill columns
    	for (int i = 0; i < COLUMNS.length; i++){
    		InsertData(COLUMNS[i], "0");
    	}
    	
    	//Add at risk
    	try {
			InsertData("at_risk", "1417");
			close();	
		} catch (Exception e){
			e.printStackTrace();
		}
    	
    }

    
}
