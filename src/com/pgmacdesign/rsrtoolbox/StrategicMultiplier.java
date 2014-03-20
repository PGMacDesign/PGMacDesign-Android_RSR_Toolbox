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



/*
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * This class has been made obsolete by StrategicMultiplier2
 * Use that instead of this for all calls relating to the 
 * strategic multiplier
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class StrategicMultiplier extends Activity  {

	DatabaseAdmin db = new DatabaseAdmin(this);

	int rev_rank;
	int pt_rank;
	double strat_multiplier;
	
	public StrategicMultiplier(){
		rev_rank = getStrategicRevenueRank();
		pt_rank = getStrategicPullThroughRank();
		strat_multiplier = getStrategicMultiplier(pt_rank, rev_rank);
	}
	
	//Queries the database for the strategic revenue rank
	public int getStrategicRevenueRank(){
		
		//Determine the strategic row (in the grid provided by commissions) and give a representation via rank
		double strategic = 0;

		double acc_quota = Double.parseDouble(db.getData(db.COLUMNS[16]));
		double acc_current = Double.parseDouble(db.getData(db.COLUMNS[17]));
		
		strategic = acc_current/ acc_quota;
		
		
		if (strategic >= 0.20 && strategic < 0.3099) {
			return 1;
		} else if (strategic >= 0.31 && strategic < 0.4699){
			return 2;
		} else if (strategic >= 0.47){
			return 3;
		} else {
			return 0;
		}
	}
	
	//Queries the database for the strategic pull-through rank
	public int getStrategicPullThroughRank(){
		
		//Determine the strategic column (in the grid provided by commissions) and give a representation via rank
		double strategic = 0;
		
		//Strategic quota
		double strategic_quota = Double.parseDouble(db.getData(db.COLUMNS[2])) + Double.parseDouble(db.getData(db.COLUMNS[3]));

		//get pull-through total
		double strategic_current = Double.parseDouble(db.getData(db.COLUMNS[14]));

		
		strategic = strategic_current / strategic_quota;
		
		if(strategic >= 0.14 && strategic < 0.33) {
			return 1;
		} else if (strategic >= 0.33 && strategic < 0.59){
			return 2;
		} else if (strategic >= 0.59) {
			return 3;
		} else {
			return 0;
		}
		
	}
	
	//Takes the values of the strategic pull-through and the strategic revenue and calculates the strategic multiplier
	public double getStrategicMultiplier(int pullThroughRank, int revenueRank){
		int pt = pullThroughRank;
		int rev = revenueRank;
		
		//This matches the boxes for strategic multiplier numbers
		if (pt == 0 && rev == 0){
			return 0.8;
		} else if (pt == 1 && rev == 0){
			return 0.85;
		} else if (pt == 2 && rev == 0){
			return 0.95;
		} else if (pt == 3 && rev == 0){
			return 1.0;
		} else if (pt == 0 && rev == 1){
			return 0.85;
		} else if (pt == 1 && rev == 1){
			return 0.95;
		} else if (pt == 2 && rev == 1){
			return 1.0;
		} else if (pt == 3 && rev == 1){
			return 1.05;
		} else if (pt == 0 && rev == 2){
			return 0.95;
		} else if (pt == 1 && rev == 2){
			return 1.0;
		} else if (pt == 2 && rev == 2){
			return 1.05;
		} else if (pt == 3 && rev == 2){
			return 1.15;
		} else if (pt == 0 && rev == 3){
			return 1.0;
		} else if (pt == 1 && rev == 3){
			return 1.05;
		} else if (pt == 2 && rev == 3){
			return 1.15;
		} else if (pt == 3 && rev == 3){
			return 1.20;
		} else {
			return 0.8;
		}
	}
	
	//returns the strategic multiplier out of the class to another class
	public String returnStrategicMultiplier(){
		//Converting to a string for the simplicity of the database
		String str1 = Double.toString(strat_multiplier);
		return str1;
	}
	
	public double returnStrategicMultiplierDouble(){
		return strat_multiplier;
	}
	
	//Simple class that makes a popup (toast) with the activity name the user chose
	public void makeToast(String activityChosen){
		Toast.makeText(getApplicationContext(), activityChosen, Toast.LENGTH_SHORT).show();
	}
}
