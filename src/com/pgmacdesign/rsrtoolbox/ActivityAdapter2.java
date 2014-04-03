package com.pgmacdesign.rsrtoolbox;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;

//Not using this class currently. It originally was designed to be a replacement for the activityAdapter class, but the display was not looking clear
public class ActivityAdapter2 extends Activity {

    @Override
    protected void onCreate(Bundle state) {
        setContentView(new ViewGroup(this) {
        	
            private RelativeLayout[] items = new RelativeLayout[14];
            
            private int width, height, itemWidth, itemHeight;
            {
            	
                Random r = new Random();
                for (int i = 0; i < 14; i++) {
                	
                    items[i] = new RelativeLayout(getContext());
                    
                    float[] hsv = new float[] {360 * r.nextFloat(), .50f, .75f};
                    
                    items[i].setBackgroundColor(Color.HSVToColor(hsv));
                    
                    addView(items[i]);

                    // UPDATE ////////////////////////////////////
                    ImageView image = new ImageView(getContext());
                    switch (i) {
                    case 0: 
                    	
                    	break;
                    case 1: 
                    	
                    	break;
                    case 2: 
                    	
                    	break;
                    case 3: 
                    	
                    	break;
                    case 4: 
                    	
                    	break;
                    case 5: 
                    	
                    	break;
                    case 6:   
                    	
                    	break;
                    case 7: 
                    	
                    	break;
                    case 8: 
                        image.setImageResource(R.drawable.ic_launcher);
                        break;
                    case 9:
                    	
                    	break;
                   
                    case 10:
                    	
                    	break;
                	
                    case 11:
                    	
                    	break;
                    	
                    case 12:
                    	
                    	break;
                    }
                    image.setScaleType(ScaleType.FIT_XY);
                    image.setLayoutParams(new RelativeLayout.LayoutParams(
                            RelativeLayout.LayoutParams.MATCH_PARENT,
                            RelativeLayout.LayoutParams.MATCH_PARENT
                    ));
                    items[i].addView(image);
                    //////////////////////////////////////////////
                }
            }
            @Override
            protected void onMeasure(int wMS, int hMS) {
                width = MeasureSpec.getSize(wMS);
                height = MeasureSpec.getSize(hMS);
                itemWidth = width / 3;
                itemHeight = height / 3;
                wMS = MeasureSpec.makeMeasureSpec(itemWidth, MeasureSpec.EXACTLY);
                hMS = MeasureSpec.makeMeasureSpec(itemHeight, MeasureSpec.EXACTLY);
                measureChildren(wMS, hMS);
                setMeasuredDimension(width, height);
            }
            @Override
            protected void onLayout(boolean changed, int l, int t, int r, int b) {
                for (int i = 0; i < 9; i++) {
                    l = itemWidth * (i % 3);
                    t = itemHeight * (i / 3);
                    r = l + itemWidth;
                    b = t + itemHeight;
                    items[i].layout(l, t, r, b);
                }
            }
        });
        super.onCreate(state);
    }

}