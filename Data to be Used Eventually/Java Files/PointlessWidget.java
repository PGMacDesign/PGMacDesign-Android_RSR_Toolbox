package com.pgmacdesign.rsrtoolbox;

import java.util.Random;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;
import android.widget.Toast;

public class PointlessWidget extends AppWidgetProvider{

	
	
	//When the app is deleted, this will run, pop up window indicating it has been tossed
	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {

		super.onDeleted(context, appWidgetIds);
		//This is a mini dialog window that disappears after a short bit of time
		Toast.makeText(context, "Widget removed", Toast.LENGTH_SHORT).show();
		
	}

	/*
	 * When the widget updates (Every 1/2 ish hour) @Params:
	 *1) Context - Package name to refer to intents/ layouts
	 *2) Appwidgetmanager - Refer to for update
	 *3) AppwidgetIDs - Reference multiple IDs (IE in xml) 
	 */
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {

		super.onUpdate(context, appWidgetManager, appWidgetIds);
		
		//Create an object that accesses the random class
		Random myRandom = new Random();
		//Create an int that uses the random object to access a number from 0 to 1 billion
		int randomInt = myRandom.nextInt(1000000000);
		//Convert the int received into a string
		String rand = String.valueOf(randomInt);
		
		//Amount of IDs entered
		final int N = appWidgetIds.length;
		
		for (int i = 0; i < N; i++){
			
			int app_widget_ID = appWidgetIds[i];
			//
			RemoteViews v = new RemoteViews(context.getPackageName(), R.layout.widget);
			
			//This updates the text view with the random string every 30 minutes
			v.setTextViewText(R.id.text_view_widget_update, rand);
			
			//Calls the method to update the widget. Affects this specific view
			appWidgetManager.updateAppWidget(app_widget_ID, v);
		}
		
		
		
	}

	
	
}
