package com.pgmacdesign.rsrtoolbox;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

//This class makes a status bar notification for the app. Useful for a 'return-to' reminder
public class StatusBar extends Activity implements OnClickListener{

	Button bStatus;
	
	//Notification manager
	NotificationManager nm;
	
	//Without this, the status bar icon will NOT go away after clicked. Number is completely random
	static final int uniqueID = 8675309; 
	
	
	protected void onCreate (Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.statusbar);
		
		bStatus = (Button) findViewById(R.id.button_status_bar);
		bStatus.setOnClickListener(this);
		
		//Define the notification manager
		nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		
		//Cancel the specific ID once the app has been re-opened/ resumed
		nm.cancel(uniqueID);
		
		//IMPORTANT: Must call this to remove the notification bar. If calling different class, have to put this method call in there so it can close the notification
		removeNotification();
	}	
	
	@Override
	public void onClick(View v) {

		addNotification();
		finish();
		
		/*
		 * All of this code has been deprecated since API 11. New code added below in separate methods
		
				//Change the second param to change what app opens with this intent
				Intent intent = new Intent(this, StatusBar.class);
				PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
				
				*/				
				/*
				//Adjust this with: http://stackoverflow.com/questions/15493633/issue-with-notification-manager-on-android
				Notification n = new Notification(R.drawable.lightning_bolt_27x27, body, System.currentTimeMillis());
				
				//Same as above
				n.setLatestEventInfo(this, title, body, pi);
				
				//Default sound, vibration, etc
				n.defaults = Notification.DEFAULT_ALL;
				
				//Pass in a key or ID and the notification to setup
				nm.notify(uniqueID, n);
				
				//This is to prevent multiple intents being created
				finish();
		*/
		
	}
	
	//Originally was Private, may have to change back
	//This adds an item to the notification bar
    public void addNotification() {

    	String body = "Go back and finish putting in schedule!";
		String title = "Reminder";
		
	    NotificationCompat.Builder builder =  
	            new NotificationCompat.Builder(this)  
	            .setSmallIcon(R.drawable.lightning_bolt_27x27)  
	            .setContentTitle(title)  
	            .setContentText(body);  

	    //Change what you want opened here in the second Parameter VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV
	    Intent notificationIntent = new Intent(this, StatusBar.class);  
	    PendingIntent intent = PendingIntent.getActivity(this, 0, notificationIntent,   
	            PendingIntent.FLAG_UPDATE_CURRENT);  
	    builder.setContentIntent(intent);  
	
	    // Add as notification  
	    NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);  
	    manager.notify(uniqueID, builder.build());  
    }  

    //Originally was Private, may have to change back
	//This removes an item from the notification bar
	private void removeNotification() {  
	    NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);  
	    manager.cancel(uniqueID);  
	}

}
