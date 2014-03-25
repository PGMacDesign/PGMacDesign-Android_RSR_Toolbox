package com.pgmacdesign.rsrtoolbox;

import java.util.GregorianCalendar;

import android.content.Intent;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Calendars;
import android.provider.CalendarContract.Events;
import android.provider.CalendarContract.Reminders;
import android.util.Log;

public class CalendarStuff {

	public void doCalendarStuff(){
		
		
		
		
		
		
		//All stuff in this class is to be used in calendar info. Various examples:
		
		
		/*
		
		
		//Create Calendar Intent
		Intent calIntent = new Intent(Intent.ACTION_INSERT); 
		calIntent.setData(CalendarContract.Events.CONTENT_URI);
		startActivity(calIntent);
		
		//Seed Calendar Details
		Intent calIntent = new Intent(Intent.ACTION_INSERT); 
		calIntent.setType("vnd.android.cursor.item/event");    
		calIntent.putExtra(Events.TITLE, "My House Party"); 
		calIntent.putExtra(Events.EVENT_LOCATION, "My Beach House"); 
		calIntent.putExtra(Events.DESCRIPTION, "A Pig Roast on the Beach"); 
		startActivity(calIntent);
		
		//Seeding Calendar Dates and Times
		Intent calIntent = new Intent(Intent.ACTION_INSERT); 
		calIntent.setType("vnd.android.cursor.item/event");    
		calIntent.putExtra(Events.TITLE, "My House Party"); 
		calIntent.putExtra(Events.EVENT_LOCATION, "My Beach House"); 
		calIntent.putExtra(Events.DESCRIPTION, "A Pig Roast on the Beach"); 
		 
		GregorianCalendar calDate = new GregorianCalendar(2012, 7, 15);
		calIntent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true); 
		calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, 
		     calDate.getTimeInMillis()); 
		calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, 
		     calDate.getTimeInMillis()); 
		 
		startActivity(calIntent);
		
		//Recurring Events
		calIntent.putExtra(Events.RRULE, “FREQ=WEEKLY;COUNT=10;WKST=SU;BYDAY=TU,TH”);
		
		
		
		*/
		
		
		
		
		
		//New section
		/*
	//Remember to initialize this activityObj first, by calling initActivityObj(this) from 
	//your activity  
	private static final String DEBUG_TAG = "CalendarActivity";
	private static Activity activityObj;

	public static void initActivityObj(Activity obj) {
        activityObj = obj;
	}

	public static void IcsMakeNewCalendarEntry(String title,String description,String location,long startTime,long endTime, int allDay,int hasAlarm, int calendarId,int selectedReminderValue) {

        ContentResolver cr = activityObj.getContentResolver();
        ContentValues values = new ContentValues();
        values.put(Events.DTSTART, startTime);
        values.put(Events.DTEND, endTime);
        values.put(Events.TITLE, title);
        values.put(Events.DESCRIPTION, description);
        values.put(Events.CALENDAR_ID, calendarId);

        if (allDay == 1)
        {
            values.put(Events.ALL_DAY, true);
        }

        if (hasAlarm==1)
        {
            values.put(Events.HAS_ALARM, true);
        }

        //Get current timezone
        values.put(Events.EVENT_TIMEZONE,TimeZone.getDefault().getID());
        Log.i(DEBUG_TAG, "Timezone retrieved=>"+TimeZone.getDefault().getID());
        Uri uri = cr.insert(Events.CONTENT_URI, values);
        Log.i(DEBUG_TAG, "Uri returned=>"+uri.toString());
        // get the event ID that is the last element in the Uri
        long eventID = Long.parseLong(uri.getLastPathSegment());

        if (hasAlarm==1)
        {
            ContentValues reminders = new ContentValues();
            reminders.put(Reminders.EVENT_ID, eventID);
            reminders.put(Reminders.METHOD, Reminders.METHOD_ALERT);
            reminders.put(Reminders.MINUTES, selectedReminderValue);

            Uri uri2 = cr.insert(Reminders.CONTENT_URI, reminders);
        }


}

}
		 */
		
		
	}
}
