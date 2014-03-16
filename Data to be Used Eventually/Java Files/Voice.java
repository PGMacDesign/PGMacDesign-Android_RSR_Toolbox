package com.pgmacdesign.rsrtoolbox;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Voice extends Activity implements OnClickListener {

	ListView lv;
	Button bVoice;
	
	static final int check = 1111;
	
	
	@Override
	//Main
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.voice);
		Initialize();
		
		
	}
	
	//Initialize variables
	private void Initialize(){
		
		lv = (ListView)findViewById(R.id.lvVoiceReturn);
		bVoice = (Button)findViewById(R.id.button_voice);
		bVoice.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		//Must use both of these lines below in Speech recogniztion!
		
		//Create an intent first to recognize speech
		Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		
		//Determine which language is being spoken
		i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		
		//Optional
		//Prompt to come up when the speaking voice icon pops up. 
		i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Wait for the beep before you start speaking");
		
		//Passing in the request code (check)
		startActivityForResult(i, check);
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (requestCode == check && resultCode == RESULT_OK){
			
			//Fill the list view. Collect data from activity result
			ArrayList<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
			//No adapter has been made, make it here
			lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, results));
		}
		
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	
	
	
	

}
