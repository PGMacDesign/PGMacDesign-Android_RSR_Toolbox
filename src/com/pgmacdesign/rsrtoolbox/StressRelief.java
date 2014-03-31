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
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;

//This class uses a onclick and onlongclick to create different sounds.
//Credit for many of the sounds in this section go to http://www.freesfx.co.uk. 
//Credit for other sections here also goes to http://soundbible.com/
public class StressRelief extends Activity implements OnClickListener, OnLongClickListener{

	//Sound pool
	SoundPool sp;
	private HashMap<Integer, Integer> soundMap;
	
	//
	int laser1 = 1;
	int laser2 = 2; 
	int laser3 = 3;
	int grenade = 4;
	int fSpeed = 1;
	
	//Object for Media player
	MediaPlayer pew;
	
	Random myRandom = new Random();
	int hit = myRandom.nextInt(4)+1;
	
	
	//Main - When the activity starts
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test); /////////////
		Initialize();
		
		//Creating a new view
		View v = new View(this);
		
		v.setOnClickListener(this);
		
		//OnLongClickListener for when you long press on the screen
		v.setOnLongClickListener(this);
		setContentView(v);
		
		//Setting up a sound pool. @ params:
		//1st is max stream (Number of sounds allowed at same time)
		//2nd is way to stream audio, (STREAM_MUSIC) is standard 
		//3rd is sample rate. 0 is default, fairly useless atm
		
		sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 100);
		soundMap = new HashMap<Integer, Integer>();
		soundMap.put(laser1, sp.load(this, R.raw.laser_001, 1));
		soundMap.put(laser2, sp.load(this, R.raw.laser_002, 1));
		soundMap.put(laser3, sp.load(this, R.raw.laser_003, 1));
		soundMap.put(grenade, sp.load(this, R.raw.grenade, 1));

		
		pew = MediaPlayer.create(this, R.raw.pew_pew);
		
		
	}

	//Initialize Variables
	private void Initialize(){
		
	}
	
	//On Click Method
	@Override
	public void onClick(View arg0) {

		hit = myRandom.nextInt(4)+1;
		
		/* Plays the sounds. @ Parameters:
		 * 1st is sound ID to play
		 * 2nd is left volume (range 0.0 - 1.0)
		 * 3rd is right volume (range 0.0 - 1.0)
		 * 4th is priority (0 is lowest priority)
		 * 5th is loop (0 = no loop | -1 = loop forever)
		 * 6th is rate playback rate (1.0 = normal)(Range is 0.5-2.0)
		 */
		sp.play(hit, 1, 1, 0, 0, 1);    
		       	
	}
	
	//IE Long press it will call this method and in the onCreate, a diff thing will play
	@Override
	public boolean onLongClick(View arg0) {
		
		pew.start();
		return false;
	}
	
	protected void onPause() {

		super.onPause();
		finish();
	}

}