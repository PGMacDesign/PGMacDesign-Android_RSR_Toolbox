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

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.Display;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

//This class serves as the main image adapter for the images on the gridview of the main class
@SuppressLint("Instantiatable")
public class ActivityAdapter extends BaseAdapter  {

	private RelativeLayout[] items = new RelativeLayout[9];
    private int width, height, itemWidth, itemHeight;
    
	//Array of Icons that will be used as menu choices
	public static int[] imageOptions = {
			R.drawable.vacation_quota, //Position 0
			R.drawable.revenue_deficit, //Position 1
			R.drawable.enter_commissions_information, //Position 2
			R.drawable.commissions, //Position 3
			R.drawable.input_schedule, //Position 4
			//R.drawable.useful_skus, //Cancelled out, pending approval for proprietary info under SKUs
			//R.drawable.lunch_timer, //Cancelled out at the moment
			R.drawable.follow_up, //Position 5
			R.drawable.calculator, //Position 6
			R.drawable.share_this_app, //Position 7
			R.drawable.edge, //Position 8
			R.drawable.important_contact_numbers, //Position 9
			R.drawable.stress_relief, //Position 10
			R.drawable.magic_ball, //Position 11
			R.drawable.reset_commissions, //Position 12
			R.drawable.piggy_bank_edited //Position 13
			//R.drawable.blank //position 14 //For testing purposes
	};
	
	private Context context;
	
	//Constructor to pass context back to Main class
	@SuppressLint("Instantiatable")
	public ActivityAdapter(Context applicationContext) {
		
		context = applicationContext;
	}

	//Number of elements to be displayed on the grid
	@Override
	public int getCount() {
		
		return imageOptions.length;
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		ImageView iv;
		if(convertView != null){
			iv = (ImageView) convertView;
		} else {
			iv = new ImageView(context);
			
			WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
			Display display = wm.getDefaultDisplay();
			
			float width2 = display.getWidth();
			
			int length = (int) (width2/2);
			
			iv.setLayoutParams(new GridView.LayoutParams(length, length));  

			
			//If the cropping size looks off, this will set gravity to center
			iv.setScaleType(ScaleType.CENTER_CROP);
			
			//Allow for padding on sides to help make things look smoother
			iv.setPadding(0, 0, 0, 0);
		}
		
		//Sets the image to correspond to its position within the array. Left at 0 for now
		iv.setImageResource(imageOptions[position]);

		return iv;
	}

	//Opens up the respective Activity depending on which image is clicked
	public static int getActivityPosition(int position) {
		return imageOptions[position];
	}
	
	

}
