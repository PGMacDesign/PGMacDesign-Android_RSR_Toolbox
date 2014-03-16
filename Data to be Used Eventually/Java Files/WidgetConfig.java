package com.pgmacdesign.rsrtoolbox;

import android.app.Activity;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViews;

public class WidgetConfig extends Activity implements OnClickListener {

	Button b1;
	EditText info;
	AppWidgetManager awm;
	Context c;
	int awID;
	


	//
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.widgetconfig);
		b1 = (Button) findViewById(R.id.button_widget_config);
		b1.setOnClickListener(this);
		
		c = WidgetConfig.this;
		
		info = (EditText) findViewById(R.id.edit_text_widget_config);
		
		//An intent is opening this class, therefore, must make one
		Intent i = getIntent();
		
		//Create a bundle since info is being passed around (Which app launched this activity)
		Bundle extras = i.getExtras();
		
		//As long as the extras had something, setup the app widget id
		if (extras != null){
			//Get an ID and pass it in. IE, a way to checking which widget activated this class
			awID = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
			//This returns 1 App widget ID
		} else {
			//In case something gets a-broken!
			finish();
		}
		
		//
		awm = AppWidgetManager.getInstance(c); 
		
	}



	@Override
	public void onClick(View v) {
		//Set the string = to the info getText
		String e = info.getText().toString();
		
		//Setup a remoteview referring to the context (Param1) and relating to the widget (Param2)
		RemoteViews v1 = new RemoteViews(c.getPackageName(), R.layout.widget);
		
		//Setting the remote view (remote meaning on the homescreen widget) to the text_view
		v1.setTextViewText(R.id.text_view_config_input, e);
		
		//IMPORTANT! This intent opens the class when clicked
		Intent intento = new Intent(c, Splash.class);
		
		//A pending intent. Apparently needed for widgets
		PendingIntent pendingintento = PendingIntent.getActivity(c, 0, intento, 0);
		
		//Set the onClickListener for the button
		v1.setOnClickPendingIntent(R.id.button_widget_open, pendingintento);
		
		
		//Update the widget with the remote view
		awm.updateAppWidget(awID, v1);
		
		//Lastly, need to set a result
		Intent result = new Intent();
		
		//Updating the ID that is being called
		result.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, awID);
		
		//Confirm the result works then set it
		setResult(RESULT_OK, result);
		
		//We want this to finish when the button is clicked
		finish();
		
	}

	
	
	
}
