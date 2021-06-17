package com.example.buttoncounter;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText userInput;
    private TextView textView;
    //create logt
    private static final String TAG = "MainActivity";
    //Create a constant to store data using TEXT_CONTENTS
    private final String TEXT_CONTENTS = "TextContents";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "oncreate: in");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Implement the id from activity main
        userInput = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);

        //Setting a blank text resets any current text left by the onclick listener
        textView.setText("");
        //Movement method needs the veritcal scrolling added in the layout
        textView.setMovementMethod(new ScrollingMovementMethod());

        //Create a counter  Onclick Listener
        View.OnClickListener ourOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create a result of the user input to string
                String result =  userInput.getText().toString();
                result = result +"\n";
                //Add append textview to result to get output
                textView.append(result);
                userInput.setText("");


            }
        }; // End of onclick

        //Set counter onclick to the button
        button.setOnClickListener(ourOnClickListener);

        //Create an exit log
        Log.d(TAG, "oncreate: out");


    }


    //Generate on start override
    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: in");
        super.onStart();
        Log.d(TAG, "onStart: out");
    }

    //Generate on restore instance state
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState: in");
       //Retrieve the value saved in the bundle from saved instance
        textView.setText(savedInstanceState.getString(TEXT_CONTENTS));
        //Alternative version
       // String savedString = savedInstanceState.getString(TEXT_CONTENTS);
        //super.onRestoreInstanceState(savedInstanceState);


        Log.d(TAG, "onRestoreInstanceState: out");
    }

    //Generate on restart
    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart: in");
        super.onRestart();
        Log.d(TAG, "onRestart: out");
    }

    //Generate on pause
    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: in");
        super.onPause();
        Log.d(TAG, "onPause: out");
    }


    //Generate on saved instance


    @Override
    protected void onSaveInstanceState(@NonNull @org.jetbrains.annotations.NotNull Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: in");
        //set outstate to TEXT_CONTENTS and set to string
        outState.putString(TEXT_CONTENTS, textView.getText().toString());
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: out");
    }

    //Generate on resume, stop
    @Override
    protected void onPostResume() {
        Log.d(TAG, "onPostResume: in");
        super.onPostResume();
        Log.d(TAG, "onPostResume: out");
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: in");
        super.onStop();
        Log.d(TAG, "onStop: out");
    }
}
