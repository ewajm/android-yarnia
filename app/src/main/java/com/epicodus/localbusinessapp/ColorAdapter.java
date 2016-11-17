package com.epicodus.localbusinessapp;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.v4.content.res.ResourcesCompat;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import static android.graphics.Color.parseColor;
import static com.epicodus.localbusinessapp.BrightnessUtils.getTextColor;

/**
 * Created by Guest on 11/17/16.
 */
public class ColorAdapter extends BaseAdapter{

    private final Context mContext;
    private final String[] mColors;

    public ColorAdapter(Context context, String[] colors){
        this.mContext = context;
        this.mColors = colors;
    }

    @Override
    public int getCount() {
        return mColors.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView gridTextView = new TextView(mContext);
        gridTextView.setText(mColors[position]);
        gridTextView.setPadding(10, 60, 10, 60);
        gridTextView.setTypeface(Typeface.SERIF, Typeface.BOLD_ITALIC);
        gridTextView.setTextSize(20);
        gridTextView.setGravity(Gravity.CENTER_HORIZONTAL);
        gridTextView.setTextColor(getTextColor(Color.parseColor(mColors[position])));
        GradientDrawable gd = new GradientDrawable();
        gd.setColor(parseColor(mColors[position])); // Changes this drawable to use a single color instead of a gradient
        gd.setCornerRadius(10);
        gd.setStroke(1, 0xFF000000);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
            gridTextView.setBackground(gd);
        } else {
            gridTextView.setBackgroundDrawable(gd);
        }
        return gridTextView;
    }
}
