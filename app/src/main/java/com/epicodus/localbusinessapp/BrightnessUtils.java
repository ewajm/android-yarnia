package com.epicodus.localbusinessapp;

import android.graphics.Color;

/**
 * Created by Guest on 11/17/16.
 */
public class BrightnessUtils {
    public static int getTextColor(int backgroundColor){
        int brightness = Brightness(backgroundColor);
        int myTextColor;
        if (brightness < 130)
            myTextColor = Color.parseColor("#cccccc");
        else
            myTextColor = Color.parseColor("#212121");
        return myTextColor;
    }

    private static int Brightness(int color){
        return (int)Math.sqrt(
                Color.red(color)*Color.red(color)*.241+
                        Color.green(color)*Color.green(color)*.691+
                        Color.blue(color)*Color.blue(color)*.068
        );
    }

}
