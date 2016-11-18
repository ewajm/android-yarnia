package com.epicodus.localbusinessapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class YarnActivity extends AppCompatActivity {
    @Bind(R.id.strandListView) ListView mStrandListView;
    @Bind(R.id.newStrandButton) Button mNewStrandButton;
    @Bind(R.id.summaryTextView) TextView mSummaryTextView;
    @Bind(R.id.priceTextView) TextView mPriceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yarn);
        ButterKnife.bind(this);

        Intent parentIntent = getIntent();
        Map<String, String> strands = YarnHolder.getData();
        if(parentIntent.hasExtra("color")){
            String color = parentIntent.getStringExtra("color");
            String fiber = parentIntent.getStringExtra("fiber");
            if(strands.size() < 6){
                strands.put(fiber, color);
            } else {
                Toast.makeText(YarnActivity.this, "You already have the maximum number of strands!", Toast.LENGTH_SHORT).show();
            }
            if(strands.size() == 6){
                mNewStrandButton.setEnabled(false);
            }
        }
        ArrayList<String> strandsStringArray = new ArrayList<String>();
        for(String key: strands.keySet()){
            strandsStringArray.add(key + " - " + strands.get(key));
        }
        String[] yarnWeight = {"lace", "sock/fingering", "sport", "dk", "worsted", "bulky"};
        if(strandsStringArray.size() > 0){
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.listview_color_item, strandsStringArray);
            mStrandListView.setAdapter(adapter);
            mSummaryTextView.setText(String.format(getResources().getString(R.string.yarnWeight), yarnWeight[strandsStringArray.size()-1]));
            String price = "$" + (strandsStringArray.size() * 3);
            mPriceTextView.setText(String.format(getResources().getString(R.string.yarnPrice), price));
        } else {
            mSummaryTextView.setText("No strands yet!");
            mPriceTextView.setText("");
        }
        mNewStrandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YarnActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
