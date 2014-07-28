package com.pgmacdesign.rsrtoolbox.inappbilling;

/**
 * A Wrapper around the Android log for ease of use
 * 
 *
 * 
 */
public class Log {

    private static final String TAG = "Hey, Listen!";

    public static void d(String msg) {
        android.util.Log.d(TAG, msg);
    }

}
