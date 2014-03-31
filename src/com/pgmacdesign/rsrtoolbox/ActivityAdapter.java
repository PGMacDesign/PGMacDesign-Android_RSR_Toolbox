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

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;

//This class serves as the main image adapter for the images on the gridview of the main class
public class ActivityAdapter extends BaseAdapter {

	//Array of Icons that will be used as menu choices
	public static int[] imageOptions = {
			R.drawable.vacation_quota, //Position 0
			R.drawable.revenue_deficit, //Position 1
			R.drawable.enter_commissions_information, //Position 2
			R.drawable.input_schedule, //Position 3
			R.drawable.useful_skus, //Position 4
			R.drawable.commissions, //Position 5
			R.drawable.lunch_timer, //Position 6
			R.drawable.follow_up, //Position 7
			R.drawable.calculator, //Position 8
			R.drawable.share_this_app, //Position 9
			R.drawable.edge, //Position 10
			R.drawable.important_contact_numbers, //Position 11
			R.drawable.stress_relief, //Position 12
			R.drawable.magic_ball, //Position 13
			R.drawable.reset_commissions //Position 14
	};
	
	private Context context;
	
	//Constructor to pass context back to Main class
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
			
			float width1 = context.getResources().getDimension(R.dimen.activity_horizontal_margin); 
			float height1 = context.getResources().getDimension(R.dimen.activity_vertical_margin); 
			//LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
			//convertView.setLayoutParams(new GridView.LayoutParams(params));
			//DisplayMetrics metrics = new DisplayMetrics();
			//getWindowManager().getDefaultDisplay().getMetrics(metrics);
			
			//This code will auto-crop and resize images to fit the dimensions
			//iv.setLayoutParams(new GridView.LayoutParams((int)mContext.getResources().getDimension(R.dimen.width), (int)mContext.getResources().getDimension(R.dimen.height)));
			

			
			iv.setLayoutParams(new GridView.LayoutParams(500, 500));
			
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
