package com.pgmacdesign.rsrtoolbox.inappbilling;

import android.app.Activity;
import android.os.Bundle;

/**
 * Here we keep common functionality that will be used across multiple activities
 * making our life easier
 * 
 *
 * 
 */
public abstract class PGMacActivity extends Activity {

    private Navigator navigator;
    private Toaster toaster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        navigator = new Navigator(this);
        toaster = new Toaster(this);
    }

    protected Navigator navigate() {
        return navigator;
    }

    protected void popBurntToast(String msg) {
        toaster.popBurntToast(msg);
    }

    protected void popToast(String msg) {
        toaster.popToast(msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        navigator = null;
        toaster = null;
    }
}
