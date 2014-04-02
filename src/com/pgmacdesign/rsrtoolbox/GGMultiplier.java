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

import android.app.Activity;
import android.widget.Toast;

//This class is designed to calculate the strategic multiplier via input from the database
public class GGMultiplier extends Activity{
	
	
	double GGmultiplierActual = 0.0;
	
	public double GetGGMultiplier(double input){
		
		double GGPercent = input;
		
		
		if(GGPercent < 0.5){
			GGmultiplierActual = 0.70;
		} else if (GGPercent >= 0.5 && GGPercent <.89999){
			GGmultiplierActual = 0.90;
		} else if (GGPercent >= 0.9 && GGPercent < 1.09999){
			GGmultiplierActual = 1.0;
		} else if (GGPercent >= 1.1 && GGPercent < 1.19999){
			GGmultiplierActual = 1.1;
		} else if (GGPercent >= 1.2 && GGPercent < 1.29999){
			GGmultiplierActual = 1.2;
		} else if (GGPercent >= 1.3 && GGPercent < 1.39999){
			GGmultiplierActual = 1.4;
		} else if (GGPercent >= 1.4 && GGPercent < 1.49999){
			GGmultiplierActual = 1.5;
		} else if (GGPercent >= 1.5 && GGPercent < 1.69999){
			GGmultiplierActual = 1.6;
		} else if (GGPercent >= 1.7 && GGPercent < 2.09999){
			GGmultiplierActual = 1.7;
		} else if (GGPercent >= 2.1 && GGPercent < 2.49999){
			GGmultiplierActual = 1.8;
		} else if (GGPercent >= 2.5 && GGPercent < 2.99999){
			GGmultiplierActual = 1.9;
		} else if (GGPercent >= 3.0){
			GGmultiplierActual = 2.0;
		} else {
			GGmultiplierActual = 0.1;  //Only if something errors out
		}
		
		return GGmultiplierActual;
	}
	
	//Simple class that makes a popup (toast) with the activity name the user chose
	public void makeToast(String activityChosen){
		Toast.makeText(getApplicationContext(), activityChosen, Toast.LENGTH_SHORT).show();
	}

	
}
