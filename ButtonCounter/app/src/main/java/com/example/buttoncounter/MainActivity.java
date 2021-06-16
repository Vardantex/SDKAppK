package com.example.buttoncounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText userInput;
    private TextView textView;
    private Button button;
    private int numTimesClicked = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Implement the id from activity main
        userInput = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        //Setting a blank text resets any current text left by the onclick listener
        textView.setText("");
        //Movement method needs the veritcal scrolling added in the layout
        textView.setMovementMethod(new ScrollingMovementMethod());

        //Create a counter  Onclick Listener
        View.OnClickListener ourOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numTimesClicked = numTimesClicked + 1;
                String result = "\n Button pressed " + numTimesClicked + " times!";
                //Append textview to result for output
                //Append Adds to the current test
                textView.append(result);
            }
        }; // End of onclick

        //Set counter onclick to the button
        button.setOnClickListener(ourOnClickListener);

    }
}