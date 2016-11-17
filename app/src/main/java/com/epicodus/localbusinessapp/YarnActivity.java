package com.epicodus.localbusinessapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class YarnActivity extends Activity {
    @Bind(R.id.strandListView) ListView mStrandListView;
    @Bind(R.id.newStrandButton) Button mNewStrandButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yarn);
        ButterKnife.bind(this);

        Intent parentIntent = getIntent();
        String color = parentIntent.getStringExtra("color");
        String fiber = parentIntent.getStringExtra("fiber");
        Map<String, String> strands = YarnHolder.getData();
        strands.put(fiber, color);
        ArrayList<String> strandsStringArray = new ArrayList<String>();
        for(String key: strands.keySet()){
            strandsStringArray.add(key + " - " + strands.get(key));
        }
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.listview_color_item, strandsStringArray);
        mStrandListView.setAdapter(adapter);
        mNewStrandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YarnActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
