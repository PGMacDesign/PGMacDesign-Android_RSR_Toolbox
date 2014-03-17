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

//This class is designed to calculate the strategic multiplier via input from the database
public class StrategicMultiplier extends Activity  {

	DatabaseAdmin db = new DatabaseAdmin(getApplicationContext());
	int strategicPullThroughRank = 0;
	int strategicRevenueRank = 0;
	double strategicMultiplier = getStrategicMultiplier(strategicPullThroughRank, strategicRevenueRank);
	
	//Queries the database for the strategic revenue rank
	public int getStrategicRevenueRank(){
		
		//Query
		return 0;
	}
	
	//Queries the database for the strategic pull-through rank
	public int getStrategicPullThroughRank(){
		
		//Query
		return 0;
	}
	
	public double getStrategicMultiplier(int pullThroughRank, int revenueRank){
		int pt = pullThroughRank;
		int rev = revenueRank;
		
		//This matches the boxes for strategic multiplier numbers
		if (pt == 0 && rev == 0){
			return 0.8;
		} else if (pt == 1 && rev == 0){
			return 0.0;
		} else {
			return 0.8;
		}
	}
	
	public double returnStrategicMultiplier(){
		return strategicMultiplier;
	}
}
