package com.pgmacdesign.rsrtoolbox;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

//This will allow us to view the database
public class SQLView extends Activity {

	TextView SQLtv;
	
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlview);
		Initialize();
		
		//Create the object to access the database
		SQLLikeOrNot info = new SQLLikeOrNot(this);
		
		//Open the database
		info.open();
		
		//Retrieve data from the table via the getData() method. Return as String
		String data = info.getData();
		
		//Close the database
		info.close();
		
		//Set the returned data from the SQL query (that was set to the data string) into the textview
		SQLtv.setText(data);
		
	}
	
	private void Initialize(){
		
		SQLtv = (TextView) findViewById(R.id.tvSQLInfo);
	}
}
