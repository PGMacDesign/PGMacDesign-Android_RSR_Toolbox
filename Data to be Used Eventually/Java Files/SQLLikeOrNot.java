package com.pgmacdesign.rsrtoolbox;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

//Handles the database/ information
public class SQLLikeOrNot {

	//Want these variables to be unchanging because they are the row headers
	public static final String KEY_ROWID = "_id";
	public static final String KEY_NAME = "persons_name";
	public static final String KEY_RANK = "rank";
	
	//Setup the actual database
	private static final String DATABASE_NAME = "LikeOrNotDB";
	private static final String DATABASE_TABLE = "people_table";
	private static final int DATABASE_VERSION = 1;
	
	//Creating an instance of the DBHelper class
	private DBHelper ourHelper;
	private final Context ourContext;
	
	//Reference the SQLite database class
	private SQLiteDatabase ourDatabase;
	
	//Constructor, which passes in a context, which was defined above
	public SQLLikeOrNot(Context c){
		ourContext = c;
	}
	
	
	//Create a thread that will create the database
	private static class DBHelper extends SQLiteOpenHelper{

		//Constructor
		public DBHelper(Context context) {
			
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			
		}
		
		//When the database is FIRST created, this method will be called, after that it will go to onUpgrade
		public void onCreate(SQLiteDatabase db){
			
			/*
			 * Create the database! Writing in SQL. Parameter is in String format
			 * INTEGER Primary Key Autoincrement makes rows auto-increase like excel drop down
			 */
			db.execSQL("CREATE TABLE " + DATABASE_TABLE + 
					" (" +
					KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
					KEY_NAME + " TEXT NOT NULL, " +
					KEY_RANK + " TEXT NOT NULL" +
					");"
					);
		}
		
		/*
		 * After the DB has been created, this method will be called. How this works is
		 * it checks if the database has been created, if it has, it drops it and creates
		 * a new one via the parameters
		 */
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
			
			//Drop the table first
			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			//Then rewrite it by calling the above method
			onCreate(db);
		}
	}
	
	//This class allows writing to the database
	public SQLLikeOrNot open() throws SQLException {
		
		ourHelper = new DBHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		
		return this;
	}
	
	//To close the database
	public void close(){
		ourHelper.close();
	}

	//Works similar to bundles, but called content values instead
	public long CreateEntry(String name, String rank) {

		ContentValues cv = new ContentValues();
		
		//First parameter is the key name (row) and the second is the value being input
		cv.put(KEY_NAME, name);
		cv.put(KEY_RANK, rank);
		
		/*
		 * @Parameters, 1) table inserted into 2) null 3) content values created above
		 * Return this so it can be processed into SQL
		 * Need to have this all on one line as opposed to setting it up separately 
		 * because it will create duplicate entries as a result
		 */
		return ourDatabase.insert(DATABASE_TABLE, null, cv);
	}

	//Method that will get data from the database via queries 
	public String getData() {

		//Create a string array for the columns data
		String[] columns = new String[]{ KEY_ROWID, KEY_NAME, KEY_RANK};
		
		/*
		 * Now we want to read info from the columns via a cursor. @Parameters:
		 * 1) Table name to be searched
		 * 2) Columns (the string array above)
		 * 3) We are setting to null
		 * 4) Arguments (IE, select X where Y)
		 * 5) GroupBy...
		 * 6) Having...
		 * 7) Order By...
		 */
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
		
		//Setup a string variable for return. Default to nothing at all
		String result = "";
		
		//Want to read through the database entries. Make 3 int vars which are for the columns
		int iRow = c.getColumnIndex(KEY_ROWID);
		int iName = c.getColumnIndex(KEY_NAME);
		int iRank = c.getColumnIndex(KEY_RANK);
		
		/*
		 * Create a for loop which starts the cursor at the beginning, loops through entries,
		 * and continues until done. Uses parameters just like standard for loop. 
		 * c.moveToFirst() places it at the beginning of the table
		 * c.isAfterLast() is a marker which signifies the end of the table read through
		 * c.moveToNext() moves the cursor one space forward
		 */
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
		
			//Result string is set to the info within the rows/ columns
			result = result + c.getString(iRow) + 
					" " + c.getString(iName) + 
					" " + c.getString(iRank) +
					"\n";
		}
		
		return result;
	}

	//Returns a string of the row at position long (parameter passed in)
	public String getName(long long1) {
		
		//Setup a string array for parsing through
		String[] columns = new String[] { KEY_ROWID, KEY_NAME, KEY_RANK};
		
		//Setup the cursor again
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, KEY_ROWID + "=" + long1, null, null, null, null);
		
		//Check to see if cursor is null
		if(c !=null){
			c.moveToFirst();
			//The 1 at Parameters if from the second column, Name {0, 1, 2}
			String name = c.getString(1);
			return name;
		}
		
		//If the cursor was not properly placed or an error occurred, return null;
		return null;
	}

	//Returns the rank of the row at position long (parameter passed in)
	public String getRank(long long1) {
		
		
		//Setup a string array for parsing through
		String[] columns = new String[] { KEY_ROWID, KEY_NAME, KEY_RANK};
		
		//Setup the cursor again
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, KEY_ROWID + "=" + long1, null, null, null, null);
		
		//Check to see if cursor is null
		if(c !=null){
			c.moveToFirst();
			//The 1 at Parameters if from the third column, Rank. {0, 1, 2}
			String rank = c.getString(2);
			return rank;
		}
		return null;
	}

	//This method updates an entry at the location specified by the user
	public void UpdateEntry(long long2, String name2, String rank2) {
		
		ContentValues cvUpdate = new ContentValues();
		cvUpdate.put(KEY_NAME, name2);
		cvUpdate.put(KEY_RANK, rank2);
		
		ourDatabase.update(DATABASE_TABLE, cvUpdate, KEY_ROWID + "=" + long2, null);
		
	}

	//This method deletes a row at the location specified by the user
	public void DeleteEntry(long long3) {
		
		ourDatabase.delete(DATABASE_TABLE, KEY_ROWID + "=" + long3, null);
		
	}
	
}
