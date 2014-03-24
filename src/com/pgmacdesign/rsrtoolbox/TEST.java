package com.pgmacdesign.rsrtoolbox;

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
