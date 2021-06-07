package com.example.activitytx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MyActivity extends AppCompatActivity {

    static final String CHESS_LEVEL = "playerLevel";
    private int mPlayerLevel;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        TextView myTextView = (TextView) findViewById(R.id.textView);

        if(savedInstanceState != null) {
            mPlayerLevel = savedInstanceState.getInt(CHESS_LEVEL);

        }
    }
}