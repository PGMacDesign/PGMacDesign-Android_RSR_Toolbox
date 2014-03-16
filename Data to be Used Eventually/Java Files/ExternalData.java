package com.pgmacdesign.rsrtoolbox;

import java.io.*;

import android.R;
import android.app.Activity;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


/*
 * When apps are updated, internal data gets erased, therefore, use an external
 * one to store data elsewhere (SD Card, different folder, etc) so it will not
 * be lost when updating 
 */
public class ExternalData extends Activity implements OnClickListener, OnItemSelectedListener{
	
	private TextView canWrite, canRead;
	
	//What is the "State" of it, IE condition
	private String state;
	
	boolean canW, canR;
	
	//Spinner, which is ...................
	Spinner spinner;
	
	//Array for browsing
	String[] paths = {"Music", "Pictures", "Download"};
	
	File path = null;
	
	//New File from the Edit Text
	File file1 = null;
	
	//From the XML File
	EditText etSaveAs;
	Button button_confirm_save_as, button_save_file;
	
	
	//Main
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		//Reference external_data.xml
		setContentView(R.layout.external_data);
		//Initialize variables
		Initialize();
		//Check to see if the data can be read or written externally
		ReadWriteAllowed();
		
		//Create an array adaptor
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(ExternalData.this, android.R.layout.simple_spinner_item, paths);
		
		//Set the spinner equal to that adapter
		spinner.setAdapter(adapter);
		
		//spinner selects which position in the array we are viewing, IE, which item is selected
		spinner.setOnItemSelectedListener(this);
	}

	
	private void Initialize(){
		
		canWrite = (TextView) findViewById(R.id.text_view_can_write);
		canRead = (TextView) findViewById(R.id.text_view_can_read);
		
		//Checks the state of an environment
		state = Environment.getExternalStorageState();
		
		spinner = (Spinner) findViewById(R.id.spinner1);
		
		//From the XML file, these will be used to confirm directory of save, then allow save once confirmed
		button_confirm_save_as = (Button) findViewById(R.id.button_confirm_save_as); 
		button_save_file = (Button) findViewById(R.id.button_save_file);	
		etSaveAs = (EditText) findViewById(R.id.etSaveAs);
		
		//Add onclicklisteners
		button_confirm_save_as.setOnClickListener(this);
		button_save_file.setOnClickListener(this);
		
	}
	
	/*
	 * This method checks to see if reading and writing is allowed to external
	 * data. Whether it is or is not allowed, it will update the textview with
	 * the proper result to show if it can
	 */
	public void ReadWriteAllowed(){
		if (state.equals(Environment.MEDIA_MOUNTED)){
			//Read and write
			canWrite.setText("External Writing is Allowed");
			canRead.setText("External Reading is Allowed");
			canW = canR = true;
			
		} else if (state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
			//Read, but cannot Write
			canWrite.setText("External Writing is NOT Allowed");
			canRead.setText("External Reading is Allowed");
			canW = false;
			canR = true;
			
		} else {
			canWrite.setText("External Writing is NOT Allowed");
			canRead.setText("External Reading is NOT Allowed");
			canW = canR = false;
		}
	}

	//For the dropdown menu (spinner) to select save pathway
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		//This gives us the position within the array of the adapter
		int position = spinner.getSelectedItemPosition();
		
		switch (position){
		
		case 0:
			//Public directory as method so it can be accessed outside of the application
			path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
			break;
		
		case 1:
			path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
			break;
			
		case 2:
			path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
			break;
			
		}
	}

	//OnClick for the save and confirm buttons
	@Override
	public void onClick(View arg0) {
		
		switch (arg0.getId()){
		
		case R.id.button_save_file:
			
			//File from the edit text field
			String str1 = etSaveAs.getText().toString();
			
			//Add a file extension so the file will be readable 
			//Path is the location and str1 is the name of it
			file1 = new File(path, str1 + ".png");
			
			ReadWriteAllowed();
			
			if (canW == canR == true){
				
				//If path does not exist, create a directory. If it exists, no action taken
				path.mkdir();
				
				//Easy example of I/O to a file here using byte[] array as input buffer reader
				try {
					//Using InputStream and Output stream as file has been created
					InputStream is = getResources().openRawResource(R.drawable.starred_large);
					OutputStream os = new FileOutputStream(file1);
					
					//Just like before, need a byte array to take in data
					byte[] data = new byte[is.available()];
					
					//Read and write the data
					is.read(data);
					os.write(data);
					
					//Close the streams to prevent memory leaks
					is.close();
					os.close();
					
					//Toast (IE a small popup that confirms an action has completed, IE, "press back one more time to exit")
					Toast t = Toast.makeText(ExternalData.this, "File has been Saved", Toast.LENGTH_LONG);
					t.show();
					
					/*
					 * Creating a MediaScanner which essentially refreshes the system, 
					 * allowing it to realize the file has been added. Updates the files
					 * for the user to confirm they have input new files. @Parameters, 
					 * 1) Context = Class name
					 * 2) Pathway
					 * 3) Null
					 * 4) OnScan completed listener, what it does after scan is complete
					 */
					MediaScannerConnection.scanFile(ExternalData.this, 
							new String[] { file1.toString()}, 
							null, 
							new MediaScannerConnection.OnScanCompletedListener() {
								
								//Toast to confirm update changes
								@Override
								public void onScanCompleted(String path, Uri uri) {
									Toast t1 = Toast.makeText(ExternalData.this, "Scan Complete,  File has been added", Toast.LENGTH_SHORT);
									t1.show();
								}
							});
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			break;
			
		case R.id.button_confirm_save_as:
			
			//Once the confirm_save_as button has been clicked, the save button will appear 
			button_save_file.setVisibility(View.VISIBLE);
			break;
		}
	}


	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		
	}

	
	
}
