package com.epicodus.localbusinessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.fiberSpinner) Spinner mFiberSpinner;
    @Bind((R.id.selectFiberButton)) Button mSelectFiberButton;
    String mSelectedFiber="Acrylic";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(MainActivity.this);

        ArrayAdapter<CharSequence> fiberArray = ArrayAdapter.createFromResource(this, R.array.fibers, android.R.layout.simple_spinner_item);
        fiberArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mFiberSpinner.setAdapter(fiberArray);
        mSelectFiberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSelectedFiber = mFiberSpinner.getSelectedItem().toString();
                Intent intent = new Intent(MainActivity.this, ColorActivity.class);
                intent.putExtra("fiber", mSelectedFiber);
                startActivity(intent);
            }
        });
    }
}
