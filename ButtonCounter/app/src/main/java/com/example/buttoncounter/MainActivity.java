package com.example.buttoncounter;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText userInput;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

    }
}