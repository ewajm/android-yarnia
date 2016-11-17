package com.epicodus.localbusinessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ColorActivity extends AppCompatActivity {
    @Bind(R.id.colorGridView) GridView mColorGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        ButterKnife.bind(this);

        String[] colors = getResources().getStringArray(R.array.colors);
        ColorAdapter colorAdapter = new ColorAdapter(this, colors);
        mColorGridView.setAdapter(colorAdapter);
    }
}
