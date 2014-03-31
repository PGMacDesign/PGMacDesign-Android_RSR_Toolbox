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
	
	//
	int fSpeed = 1;
	
	//Object for Media player
	MediaPlayer pew;
	
	Random myRandom = new Random();
	int hit = myRandom.nextInt(4)+1;
	
		
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.magic_ball);
		Initialize();
		
		sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 100);
		soundMap = new HashMap<Integer, Integer>();
		soundMap.put(maybe_01, sp.load(this, R.raw.adrian_maybe, 1));   //Change raw ID here
		soundMap.put(yes_01, sp.load(this, R.raw.adrian_yes, 1));
		soundMap.put(no_01, sp.load(this, R.raw.adrian_no, 1));
	}

	//Initialize Variables
	private void Initialize(){
		magic_ball_button = (ImageButton) findViewById(R.id.magic_ball_button);
		magic_ball_button.setOnClickListener(this);
		
	}
	
	//On Click Method
	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()){
		
		case R.id.magic_ball_button:
			hit = myRandom.nextInt(3)+1;
			sp.play(hit, 1, 1, 0, 0, 1);
			break;
		}
	}
	
	protected void onPause() {

		super.onPause();
		finish();
	}

}