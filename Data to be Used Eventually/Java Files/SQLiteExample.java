package com.pgmacdesign.rsrtoolbox;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SQLiteExample extends Activity implements OnClickListener{

	Button button_sql_update, button_sql_view, sql_button_get_information, sql_button_edit_entry, sql_button_delete_entry;
	EditText edit_text_sql_rank, edit_text_sql_name, sql_edit_text_row_id;
		
	
	//Main 
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sql_lite_example);
		Initialize();
		
		//Set the onclicklistener for these buttons
		button_sql_view.setOnClickListener(this);
		button_sql_update.setOnClickListener(this);
		sql_button_get_information.setOnClickListener(this);
		sql_button_edit_entry.setOnClickListener(this);
		sql_button_delete_entry.setOnClickListener(this);
		
		
	}	
	
	//Initialize variables
	private void Initialize() {
		//Buttons
		button_sql_update = (Button) findViewById(R.id.button_sql_update);
		button_sql_view = (Button) findViewById(R.id.button_sql_view);
		sql_button_get_information = (Button) findViewById(R.id.sql_button_get_information);
		sql_button_edit_entry = (Button) findViewById(R.id.sql_button_edit_entry);
		sql_button_delete_entry = (Button) findViewById(R.id.sql_button_delete_entry);
		
		//Edit Text Fields
		edit_text_sql_rank = (EditText) findViewById(R.id.edit_text_sql_rank);
		edit_text_sql_name = (EditText) findViewById(R.id.edit_text_sql_name);
		sql_edit_text_row_id = (EditText) findViewById(R.id.sql_edit_text_row_id);
		
	}


	//OnClick for the various buttons
	@Override
	public void onClick(View arg0) {
		
		switch (arg0.getId()){
		
		case R.id.button_sql_update:
			
			boolean didItWork = true;
			
			//Surround with Try/ catch in case SQL database does not work
			try{
				//Strings defined from data in the edit_text field typed
				String name = edit_text_sql_name.getText().toString();
				String rank = edit_text_sql_rank.getText().toString();
				
				//Creating entry object from the SQLLikeOrNot class
				SQLLikeOrNot entry = new SQLLikeOrNot(SQLiteExample.this);
				
				//Use the entry object created to open the database
				entry.open();
				
				//Use method in SQLLikeOrNot class to pass in strings and create entry to database
				entry.CreateEntry(name, rank);			
				
				//Use the entry object created to close the database
				entry.close();
			} catch (Exception e) {
				didItWork = false;
				
				//Sets a new string = to the error in string format
				String error = e.toString();
				//Use above error string for debugging
				DialogBoxPopup("Error Yo...", "Please make sure to type a row that exists!");
				
			} finally {
				
				if (didItWork) {
					//If it worked, create a dialog box that confirms it worked
					DialogBoxPopup("Update Database", "Update confirmation");
				}
			}
			
			break;
			
		case R.id.button_sql_view:
			
			//Creating this new intent to open up the SQL View 
			Intent i = new Intent("com.macdowell.thenewbostoneclipsetest01.SQLVIEW");
			startActivity(i);
			
			break;
			
		case R.id.sql_button_get_information:
			
			//Refer to the sql_edit_text_row_id so we can parse the input
			String str1 = sql_edit_text_row_id.getText().toString();
			
//Make something here to check if it is only numbers ----------------------------------------------------------------
			
			//Convert that string into a long variable, which will be the row ID
			long long1 = Long.parseLong(str1);
			
			//Make a new object
			SQLLikeOrNot object1 = new SQLLikeOrNot(SQLiteExample.this);
			
			object1.open();
			
			//Need to setup an if statement here that will only run if the row exists
			
			try {
			//Gets name via passing in the long from above
			String returnedName = object1.getName(long1);
			
			//Gets rank via passing in the long from above
			String returnedRank = object1.getRank(long1);

			//Set the edit text fields = to the returned data
			edit_text_sql_name.setText(returnedName);
			edit_text_sql_rank.setText(returnedRank);
			
			} catch (Exception e) {
				//This is for debugging, should show out of bounds exception if they typed a number outside of the row
				String error = e.toString();
				//Use above error string for debugging				
				DialogBoxPopup("Error Yo...", "Please make sure to type a row that exists!");
			}		
			
			object1.close();
			break;
			
		case R.id.sql_button_edit_entry:
			
			//Refer to the sql_edit_text_row_id so we can parse the input
			String str2 = sql_edit_text_row_id.getText().toString();
			
			//Convert that string into a long variable, which will be the row ID
			long long2 = Long.parseLong(str2);
			
			//Strings defined from data in the edit_text field typed
			String name2 = edit_text_sql_name.getText().toString();
			String rank2 = edit_text_sql_rank.getText().toString();
			
			SQLLikeOrNot object2 = new SQLLikeOrNot(this);
			object2.open();
			
			//In try and catch in case they enter a row that does not exist
			try {
			object2.UpdateEntry(long2, name2, rank2);
			
			//If it worked, create a dialog box that confirms it worked
			DialogBoxPopup("Edit Database", "Edit confirmation");
			
			} catch (Exception e) {
				//This is for debugging, should show out of bounds exception if they typed a number outside of the row
				String error = e.toString();
				//Use above error string for debugging
				DialogBoxPopup("Error Yo...", "Please make sure to type a row that exists!");
			}
			
			object2.close();			
			break;
			
		case R.id.sql_button_delete_entry:
			
			//Refer to the sql_edit_text_row_id so we can parse the input
			String str3 = sql_edit_text_row_id.getText().toString();
			
			//Convert that string into a long variable, which will be the row ID
			long long3 = Long.parseLong(str3);
			
			SQLLikeOrNot object3 = new SQLLikeOrNot(this);
			object3.open();
			
			try{
				object3.DeleteEntry(long3);
				
				//If it worked, create a dialog box that confirms it worked
				DialogBoxPopup("Delete Row From Database", "Delete confirmation");
				
			} catch (Exception e){
				//This is for debugging, should show out of bounds exception if they typed a number outside of the row
				String error = e.toString();
				//Use above error string for debugging
				DialogBoxPopup("Error Yo...", "Please make sure to type a row that exists!");
			}
			
			object3.close();			
			break;
			
		}
		
	}

	//Method that returns a dialog box. @Parameters, 1) String for the Main text in box and 2) String for sub-text below the main box
	public void DialogBoxPopup(String title, String text){
		
		Dialog d = new Dialog(SQLiteExample.this);
		d.setTitle(title);
		TextView tv1 = new TextView(this);
		tv1.setText(text);
		d.setContentView(tv1);
		d.show();
	}
		
}
