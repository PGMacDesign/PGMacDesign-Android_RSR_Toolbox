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

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAdmin {

	DatabaseHelper dbhelper;
	Context ctx;
	
	//Create an object of the SQLite database which we can use to open and close it
	SQLiteDatabase db;
	
    //SQL Variables
    public static final String TABLE_NAME = "commissions";
    public static final String COLUMN_NAME_EMPLOYEE_ID = "employee_id";
    public static final String COLUMN_NAME_EMPLOYEE_NAME = "employe_name";
    public static final String COLUMN_NAME_AT_RISK = "at_risk";
    public static final String COLUMN_NAME_GG_QUOTA = "gg_quota";
    public static final String COLUMN_NAME_GG_CURRENT = "gg_current";
    public static final String COLUMN_NAME_GG_CHARGE_BACKS = "gg_charge_backs";
    public static final String COLUMN_NAME_NET_GAINS_CURRENT = "net_gains_current";
    public static final String COLUMN_NAME_GG_MULTIPLIER = "gg_multiplier";
    public static final String COLUMN_NAME_GG_RUN_RATE = "gg_run_rate";
    public static final String COLUMN_NAME_SALES_DOLLARS_QUOTA = "sales_dollars_quota";
    public static final String COLUMN_NAME_SALES_DOLLARS_CURRENT = "sales_dollars_current";
    public static final String COLUMN_NAME_SALES_DOLLARS_MULTIPLIER = "sales_dollars_multiplier";
    public static final String COLUMN_NAME_VACATION_RELIEF_PERCENT = "vacation_relief_percent";
    public static final String COLUMN_NAME_STRATEGIC_PULL_THROUGH_QUOTA = "strategic_pull_through_quota";
    public static final String COLUMN_NAME_STRATEGIC_PULL_THROUGH_CURRENT = "strategic_pull_through_current";
    public static final String COLUMN_NAME_STRATEGIC_PULL_THROUGH_RANK = "strategic_pull_through_rank"; //Rank will determine which box and which multiplier
    public static final String COLUMN_NAME_STRATEGIC_ACC_QUOTA = "strategic_acc_quota";
    public static final String COLUMN_NAME_STRATEGIC_ACC_CURRENT = "strategic_acc_current";
    public static final String COLUMN_NAME_STRATEGIC_ACC_RANK = "strategic_acc_rank"; //Rank will determine which box and which multiplier
    public static final String COLUMN_NAME_STRATEGIC_MULTIPLIER = "strategic_multiplier";
    public static final String COLUMN_NAME_SPIFFS = "spiffs";
    public static final String COLUMN_NAME_FINAL_COMMISSIONS = "final_commissions";
    
    public static final String TEXT_TYPE = " TEXT";
    public static final String COMMA = ",";
    
    //String to create the database
    public static final String SQL_CREATE_DATABASE =
    		"CREATE TABLE " + 
    		TABLE_NAME + " (" +
    		COLUMN_NAME_AT_RISK + " REAL 1417" + COMMA +
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

    private static final String SQL_DELETE_ENTRIES =
        "DROP TABLE IF EXISTS " + TABLE_NAME;
    
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "RSRToolbox.db";

	// To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public DatabaseAdmin(Context ctx) {
    	this.ctx = ctx;
    	dbhelper = new DatabaseHelper(ctx);
    }
    
    //DatabaseHelper
    private class DatabaseHelper extends SQLiteOpenHelper {
        // If you change the database schema, you must increment the database version.

    	//Constructor for DatabaseHelper
        public DatabaseHelper(Context ctx) {
            super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
        }
        
        public void onCreate(SQLiteDatabase db) {
            //Creates database
        	try {
        	db.execSQL(SQL_CREATE_DATABASE);
        	} catch (Exception e) {
        		e.printStackTrace();
        	}
        }
        
        //If the table already exists, delete it and create the new one
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        	
        	db.execSQL("DROP TABLE IF EXIST commissions");
        	onCreate(db);
        }
        
        //
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //onUpgrade(db, oldVersion, newVersion);
        }
        

    }
    
    //Method to open the database
    public DatabaseAdmin openDB(){
    	db = dbhelper.getWritableDatabase();
    	return this;
    }
    
    //Method for closing the database
    public void closeDB(){
    	dbhelper.close();
    }
    
    //Method to insert data into the database
    public long InsertData(String column_name, String value){
    	
    	ContentValues content = new ContentValues();
    	content.put(column_name, value);
    	return db.insertOrThrow(TABLE_NAME, null, content);
    }
    
    //May need to adjust parameters to match db query. Check youtube if error persists:
    //http://www.youtube.com/watch?v=fceqoJ61ANY
    public Cursor getData(String[] column_name){
    	
    	//@Params: 1-Table name, 2-Columns, 3-String selection, 4-GroupBy, 5-Having, 6-OrderBy
    	return db.query(TABLE_NAME, column_name, null, null, null, null, null);
    	
    	//May need to use on 2nd param:
    	/*
    	 *  new String [] {NAME, EMAIL}, 
    	 */
    }
    
}
