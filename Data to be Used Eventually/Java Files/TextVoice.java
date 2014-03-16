package com.pgmacdesign.rsrtoolbox;

import java.util.Locale;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

/*
 * This app speaks out phrases within an array (or input in via EditText once added)
 * This would be useful for making a magic 8-ball type app (as far as the random aspect)
 * Could also do a for loop and cycle through the array via a counter.
 * Regarding an EditText input, convert the text from it to a string, and then use it as var.
 * Advertisements are also included here for reference and structure
 */
public class TextVoice extends Activity implements OnClickListener {

	Button btVoice;
	
	private static final String AD_UNIT_ID = "ca-app-pub-1536329423564811/9798006082";
	
	//Setup phrases to be spoken
	static final String[] texts = {
		"Casey, you suck. Just wanted to tell you that",
		"Jeff, I am not much of a fan of you",
		"Donde esta la biblioteca"
	};
	
	//Text to speech variable 
	TextToSpeech tts;
	
	private AdView adView;
	
	@Override
	//Main
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.textvoice);
		Initialize();
		
		//Text to speech. Here vs Initialize as it is creating a new item in Parameters
		tts = new TextToSpeech(TextVoice.this, new TextToSpeech.OnInitListener() {
			
			@Override
			//Status here is referring to if it is not working
			public void onInit(int status) {

				if (status != TextToSpeech.ERROR){
					//Can change the language here as far as wording goes
					tts.setLanguage(Locale.US);
				}
			}
		});
		
		/*
		 
		 Apparently Google's own examples do not follow standard human logic
		 when it comes to setting up adds so none of this works. I will be coming 
		 back to it once I can find an intelligent resource to replicate. 
		
		
		// Create an ad.
	    adView = new AdView(this);
	    adView.setAdSize(AdSize.BANNER);
	    adView.setAdUnitId(AD_UNIT_ID);
	    
	    // Add the AdView to the view hierarchy. The view will have no size
	    // until the ad is loaded.
	    LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout);
	    layout.addView(adView);

	    // Create an ad request. Check logcat output for the hashed device ID to
	    // get test ads on a physical device.
	    AdRequest adRequest = new AdRequest.Builder()
	        .addTestDevice(AdRequest.TEST_EMULATOR)
	        .addTestDevice("INSERT_YOUR_HASHED_DEVICE_ID_HERE")
	        .build();

	    // Start loading the ad in the background.
	    adView.loadAd(adRequest);	    
	    
		
		AdView adView = (AdView) this.findViewById(R.id.ad);
	    AdRequest adRequest = new AdRequest.Builder()
	        .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
	        .addTestDevice(TEST_DEVICE_ID)
	        .build();
	    adView.loadAd(adRequest);
		*/
		
	}

	//
	private void Initialize(){
		btVoice = (Button) findViewById(R.id.button_text_to_voice);
		btVoice.setOnClickListener(this);
	}
	
	//
	@Override
	public void onClick(View arg0) {
	
		Random myRandom = new Random();
		//3 Options passing in, 3 text items in array
		String random = texts[myRandom.nextInt(3)];
		
		/*
		 * Command to speak. @Params: 
		 * 1) Speak the string (random)
		 * 2) Stop ALL other sounds (IE music, nav, etc)
		 * 3) null
		 */
		tts.speak(random, TextToSpeech.QUEUE_FLUSH, null);
	}

	@Override
	protected void onPause() {
		
		super.onPause();
		
		if(tts != null){
			tts.stop();
			tts.shutdown();
		}
	}
	
	
	
	
}
