package com.pgmacdesign.rsrtoolbox.inappbilling;

import com.pgmacdesign.rsrtoolbox.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * This activity holds the button to donate
 * 
 * 
 * 
 * 
 */
public class MainActivity extends PGMacActivity implements MainMenu {

    private ImageView passportImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  //THIS NEEDS TO BE EDITED!!!!!!!!!!!!!!!!
        passportImage = (ImageView) findViewById(R.drawable.ic_launcher); //THIS NEEDS TO BE EDITED!!!!!!!!!!!!!!!!
    }

    @Override
    //Need to change this from the xml defined to the seOnClickListener instead
    public void onPurchaseItemClick(View v) {
        navigate().toPurchasePassportActivityForResult();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (Navigator.REQUEST_PASSPORT_PURCHASE == requestCode) {
            if (RESULT_OK == resultCode) {
                dealWithSuccessfulPurchase();
            } else {
                dealWithFailedPurchase();
            }
        }
    }

    private void dealWithSuccessfulPurchase() {
        Log.d("Donation Complete. Thank you!");
        popToast("Donation Complete. Thank you!");
        passportImage.setVisibility(View.VISIBLE);
    }

    private void dealWithFailedPurchase() {
        Log.d("Donation Failed /Fail Programmer!");
        popToast("Donation Failed /Fail Programmer!");
    }
}
