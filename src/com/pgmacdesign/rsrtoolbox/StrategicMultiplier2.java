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
public class StrategicMultiplier2 extends Activity  {

	DatabaseAdmin db = new DatabaseAdmin(this);
	
	
	
	public double GetStrategicMultiplier(){
	
		//Accessory Strategic Calculations
			double acc_mult_rank;
			int acc_rank;
			double acc_quota = Double.parseDouble(db.getData(db.COLUMNS[16]));
			double acc_current = Double.parseDouble(db.getData(db.COLUMNS[17]));
		
			acc_mult_rank = acc_current / acc_quota;
			
			if (acc_mult_rank >= 0.20 && acc_mult_rank < 0.3099) {
				acc_rank = 1;
			} else if (acc_mult_rank >= 0.31 && acc_mult_rank < 0.4699){
				acc_rank = 2;
			} else if (acc_mult_rank >= 0.47){
				acc_rank = 3;
			} else {
				acc_rank = 0;
			}
		
		//Pull-Through Strategic Calculations
			double pt_mult_rank;
			int pt_rank;
			double pt_quota = Double.parseDouble(db.getData(db.COLUMNS[2])) + Double.parseDouble(db.getData(db.COLUMNS[3]));
			double pt_current = Double.parseDouble(db.getData(db.COLUMNS[14]));
			
			pt_mult_rank = pt_current / pt_quota;
			
			if(pt_mult_rank >= 0.14 && pt_mult_rank < 0.33) {
				pt_rank = 1;
			} else if (pt_mult_rank >= 0.33 && pt_mult_rank < 0.59){
				pt_rank = 2;
			} else if (pt_mult_rank >= 0.59) {
				pt_rank = 3;
			} else {
				pt_rank = 0;
			}
		
		//Strategic Multiplier Calculations
			double strategic_multiplier;
			//This matches the boxes for strategic multiplier numbers
			if (pt_rank == 0 && acc_rank == 0){
				strategic_multiplier = 0.8;
			} else if (pt_rank == 1 && acc_rank == 0){
				strategic_multiplier = 0.85;
			} else if (pt_rank == 2 && acc_rank == 0){
				strategic_multiplier = 0.95;
			} else if (pt_rank == 3 && acc_rank == 0){
				strategic_multiplier = 1.0;
			} else if (pt_rank == 0 && acc_rank == 1){
				strategic_multiplier = 0.85;
			} else if (pt_rank == 1 && acc_rank == 1){
				strategic_multiplier = 0.95;
			} else if (pt_rank == 2 && acc_rank == 1){
				strategic_multiplier = 1.0;
			} else if (pt_rank == 3 && acc_rank == 1){
				strategic_multiplier = 1.05;
			} else if (pt_rank == 0 && acc_rank == 2){
				strategic_multiplier = 0.95;
			} else if (pt_rank == 1 && acc_rank == 2){
				strategic_multiplier = 1.0;
			} else if (pt_rank == 2 && acc_rank == 2){
				strategic_multiplier = 1.05;
			} else if (pt_rank == 3 && acc_rank == 2){
				strategic_multiplier = 1.15;
			} else if (pt_rank == 0 && acc_rank == 3){
				strategic_multiplier = 1.0;
			} else if (pt_rank == 1 && acc_rank == 3){
				strategic_multiplier = 1.05;
			} else if (pt_rank == 2 && acc_rank == 3){
				strategic_multiplier = 1.15;
			} else if (pt_rank == 3 && acc_rank == 3){
				strategic_multiplier = 1.20;
			} else {
				strategic_multiplier = 0.8;
			}
		
		//Finally, return the calculated multiplier
		return strategic_multiplier;
	}
}
