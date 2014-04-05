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

import java.util.HashMap;
import java.util.Random;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

//This section will reply to a yes or no answer with a pre-recorded short sound clip recorded from friends of mine/ coworkers
public class MagicBall extends Activity implements View.OnClickListener {

	//Global Variables
	ImageButton magic_ball_button;

	//Sound pool
	SoundPool sp;
	private HashMap<Integer, Integer> soundMap;
	
	//Choices
	int yes_01 = 1;
	int no_01 = 2; 
	int maybe_01 = 3;
	int yes_02 = 4;
	int no_02 = 5; 
	int maybe_02 = 6;
	int yes_03 = 7;
	int no_03 = 8; 
	int maybe_03 = 9;
	int yes_04 = 10;
	int no_04 = 11;
	int maybe_04 = 12;
	int yes_05 = 13;
	int no_05 = 14; 
	int maybe_05 = 15;
	int yes_06 = 16;
	int no_06 = 17; 
	int maybe_06 = 18;
	int yes_07 = 19;
	int no_07 = 20; 
	int maybe_07 = 21;
	int yes_08 = 22;
	int no_08 = 23;
	int maybe_08 = 24;
	int yes_09 = 25;
	int no_09 = 26; 
	int maybe_09 = 27;
	int yes_10 = 28;
	int no_10 = 29; 
	int maybe_10 = 30;
	int yes_11 = 31;
	int no_11 = 32; 
	int maybe_11 = 33;
	int yes_12 = 34;
	int no_12 = 35;
	int maybe_12 = 36;
	int yes_13 = 37;
	int no_13 = 38; 
	int maybe_13 = 39;
	int yes_14 = 40;
	int no_14 = 41; 
	int maybe_14 = 42;
	int yes_15 = 43;
	int no_15 = 44; 
	int maybe_15 = 45;
	
	//
	int fSpeed = 1;
	
	//Object for Media player
	MediaPlayer pew;
	
	Random myRandom = new Random();
	int hit = myRandom.nextInt(45)+1;
	
	//Main, on Create
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.magic_ball);
		
		sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 100);
		soundMap = new HashMap<Integer, Integer>();
		
		Initialize();
		

	}

	//Initialize Variables
	private void Initialize(){
		magic_ball_button = (ImageButton) findViewById(R.id.magic_ball_button);
		magic_ball_button.setOnClickListener(this);
		
		soundMap.put(maybe_01, sp.load(this, R.raw.adrian_maybe, 1));   
		soundMap.put(yes_01, sp.load(this, R.raw.adrian_yes, 1));
		soundMap.put(no_01, sp.load(this, R.raw.adrian_no, 1));
		soundMap.put(maybe_02, sp.load(this, R.raw.eric_maybe, 1));  
		soundMap.put(yes_02, sp.load(this, R.raw.eric_yes, 1));
		soundMap.put(no_02, sp.load(this, R.raw.eric_no, 1));
		soundMap.put(maybe_03, sp.load(this, R.raw.serena_maybe, 1));   
		soundMap.put(yes_03, sp.load(this, R.raw.serena_yes, 1));
		soundMap.put(no_03, sp.load(this, R.raw.serena_no, 1));
		soundMap.put(yes_04, sp.load(this, R.raw.casey_yes, 1));
		soundMap.put(no_04, sp.load(this, R.raw.casey_no, 1));
		soundMap.put(maybe_04, sp.load(this, R.raw.casey_maybe, 1));   
		soundMap.put(yes_05, sp.load(this, R.raw.jamanee_yes, 1));
		soundMap.put(no_05, sp.load(this, R.raw.jamanee_no, 1));
		soundMap.put(maybe_05, sp.load(this, R.raw.jamanee_maybe, 1));  
		soundMap.put(yes_06, sp.load(this, R.raw.tubig_yes, 1));
		soundMap.put(no_06, sp.load(this, R.raw.tubig_no, 1));
		soundMap.put(maybe_06, sp.load(this, R.raw.tubig_maybe, 1));
		soundMap.put(yes_07, sp.load(this, R.raw.damon_yes, 1));
		soundMap.put(no_07, sp.load(this, R.raw.damon_no, 1));
		soundMap.put(maybe_07, sp.load(this, R.raw.damon_maybe, 1));  
		soundMap.put(yes_08, sp.load(this, R.raw.jigna_yes, 1));
		soundMap.put(no_08, sp.load(this, R.raw.jigna_no, 1));
		soundMap.put(maybe_08, sp.load(this, R.raw.jigna_maybe, 1));   
		soundMap.put(yes_09, sp.load(this, R.raw.felipe_yes, 1));
		soundMap.put(no_09, sp.load(this, R.raw.felipe_no, 1));
		soundMap.put(maybe_09, sp.load(this, R.raw.felipe_maybe, 1));
		soundMap.put(yes_10, sp.load(this, R.raw.derrick_yes, 1));
		soundMap.put(no_10, sp.load(this, R.raw.derrick_no, 1));
		soundMap.put(maybe_10, sp.load(this, R.raw.derrick_maybe, 1));   
		soundMap.put(yes_11, sp.load(this, R.raw.jason_yes, 1));
		soundMap.put(no_11, sp.load(this, R.raw.jason_no, 1));
		soundMap.put(maybe_11, sp.load(this, R.raw.jason_maybe, 1));   
		soundMap.put(yes_12, sp.load(this, R.raw.pat_yes, 1));
		soundMap.put(no_12, sp.load(this, R.raw.pat_no, 1));
		soundMap.put(maybe_12, sp.load(this, R.raw.pat_maybe, 1));
		soundMap.put(yes_13, sp.load(this, R.raw.pat_2_yes, 1));
		soundMap.put(no_13, sp.load(this, R.raw.pat_2_no, 1));
		soundMap.put(maybe_13, sp.load(this, R.raw.pat_2_maybe, 1));   
		soundMap.put(yes_15, sp.load(this, R.raw.pat_4_yes, 1));
		soundMap.put(no_15, sp.load(this, R.raw.pat_4_no, 1));
		soundMap.put(maybe_15, sp.load(this, R.raw.pat_4_maybe, 1));
		soundMap.put(yes_14, sp.load(this, R.raw.pat_3_yes, 1));
		soundMap.put(no_14, sp.load(this, R.raw.pat_3_no, 1));
		soundMap.put(maybe_14, sp.load(this, R.raw.pat_3_maybe, 1));  

		
	}
	
	//On Click Method
	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()){
		
		case R.id.magic_ball_button:
			hit = myRandom.nextInt(45)+1;
			sp.play(hit, 1, 1, 0, 0, 1);
			break;
		}
	}
	
	protected void onPause() {

		super.onPause();
		finish();
	}

}