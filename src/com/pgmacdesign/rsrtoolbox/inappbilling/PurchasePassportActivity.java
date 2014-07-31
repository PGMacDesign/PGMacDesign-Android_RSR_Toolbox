package com.pgmacdesign.rsrtoolbox.inappbilling;

import android.os.Bundle;

import com.pgmacdesign.rsrtoolbox.Donate;
import com.pgmacdesign.vending.billing.util.IabResult;
import com.pgmacdesign.vending.billing.util.Purchase;

/**
 * This activity will purchase a Passport from Google Play.
 * 
 * If you wanted to change to purchase something else all you have to change is the SKU (item id) that is used
 * you could even pass this in as an Intent EXTRA to avoid duplication for multiple items to purchase
 * 
 * N.B that we extend PurchaseActivity if you don't understand something look up to this class
 * 
 *
 * 
 */
public class PurchasePassportActivity extends PurchaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the result as cancelled in case anything fails before we purchase the item
        setResult(RESULT_CANCELED);
        // Then wait for the callback if we have successfully setup in app billing or not (because we extend PurchaseActivity)
    }

    @Override
    protected void dealWithIabSetupFailure() {
        popBurntToast("Donation failed. /Bad Programmer!");
        finish();
    }

    @Override
    protected void dealWithIabSetupSuccess() {
        
    	//pulls from the Donate class to check on the String result of the spinner to determine the donation amount
    	String decision = com.pgmacdesign.rsrtoolbox.Donate.user_donate_choice;
    	
    	if (decision == "donate_1_dollar"){
    		purchaseItem(PurchaseSKUs.SKU_1_DOLLAR);
    		
    	} else if (decision == "donate_5_dollars"){
    		purchaseItem(PurchaseSKUs.SKU_5_DOLLARS);
    		
    	} else if (decision == "donate_10_dollars"){
    		purchaseItem(PurchaseSKUs.SKU_10_DOLLARS);
    		
    	} else if (decision == "donate_20_dollars"){
    		purchaseItem(PurchaseSKUs.SKU_20_DOLLARS);
    		
    	}else {
    		purchaseItem(PurchaseSKUs.SKU_1_DOLLAR);
    	}
    	        
    }

    @Override
    protected void dealWithPurchaseSuccess(IabResult result, Purchase info) {
        super.dealWithPurchaseSuccess(result, info);
        setResult(RESULT_OK);
        finish();
    }

    @Override
    protected void dealWithPurchaseFailed(IabResult result) {
        super.dealWithPurchaseFailed(result);
        setResult(RESULT_CANCELED);
        finish();
    }

}
