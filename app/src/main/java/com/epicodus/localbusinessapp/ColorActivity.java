package com.epicodus.localbusinessapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ColorActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.colorGridView) GridView mColorGridView;
    @Bind(R.id.selectColorButton) Button mSelectColorButton;
    String mColor;
    String mFiber;
    TextView mPrevSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        ButterKnife.bind(this);

        Intent parentIntent = getIntent();
        mFiber = parentIntent.getStringExtra("fiber");
        String[] colors = getResources().getStringArray(R.array.colors);
        ColorAdapter colorAdapter = new ColorAdapter(this, colors);
        mColorGridView.setAdapter(colorAdapter);
        mColorGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(mPrevSelection != null) {
                    GradientDrawable drawable = (GradientDrawable) mPrevSelection.getBackground();
                    drawable.setStroke(1, 0xFF000000);
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
                        mPrevSelection.setBackground(drawable);
                    } else {
                        mPrevSelection.setBackgroundDrawable(drawable);
                    }
                }
                mPrevSelection = (TextView) view;
                GradientDrawable drawable = (GradientDrawable) view.getBackground();
                drawable.setStroke(15, 0xFF8BC34A);
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
                    view.setBackground(drawable);
                } else {
                    view.setBackgroundDrawable(drawable);
                }
                mColor = ((TextView) view).getText().toString();
            }
        });
        mSelectColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mColor==null){
                    Toast.makeText(ColorActivity.this, "Please Select a Color First!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(ColorActivity.this, YarnActivity.class);
                    intent.putExtra("color", mColor);
                    intent.putExtra("fiber", mFiber);
                    startActivity(intent);
                }
            }
        });
    }
}
