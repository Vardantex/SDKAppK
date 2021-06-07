package com.example.notedapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private RadioGroup rgButtons;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instantiate RadioButtons
        rgButtons = findViewById(R.id.rgButtons);


        //Call this button when its pressed
        rgButtons.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbBold: Toast.makeText(MainActivity.this, "Set to Bold", Toast.LENGTH_SHORT).show();

                        Button btnBold = (Button) findViewById(R.id.rbBold);
                        btnBold.setTypeface(null, Typeface.BOLD);

                        TextView txtBold = (TextView) findViewById(R.id.txtFirstOutput);
                        btnBold.setTypeface(null, Typeface.BOLD);

                        break;

                    case R.id.rbItalic: Toast.makeText(MainActivity.this, "Set to Italic", Toast.LENGTH_SHORT).show();
//                        progressBar.setVisibility(View.VISIBLE);

                        //Set the button
                        Button btnItalic = (Button) findViewById(R.id.rbItalic);
                        btnItalic.setTypeface(null, Typeface.ITALIC);

                        //Set text view
                        TextView txtItalic = (TextView) findViewById(R.id.txtFirstOutput);
                        txtItalic.setTypeface(txtItalic.getTypeface(), Typeface.ITALIC);

                        break;

                    case R.id.rbUnderline: Toast.makeText(MainActivity.this, "Set to Underline", Toast.LENGTH_SHORT).show();
                        //                      progressBar.setVisibility(View.GONE);

                        //Set the button
                        Button btnUnderline = (Button) findViewById(R.id.rbUnderline);
                        btnUnderline.setPaintFlags(btnUnderline.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

                        //Set text view
                        TextView txtView = (TextView) findViewById(R.id.txtFirstOutput);
                        txtView.setPaintFlags(txtView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

                        break;
                    default:
                        break;

                }

            }
        });



    }

    //Create the onBtnClick Method needed for the button object
    public void onBtnClick(View view) {
        //Used to output altered First name text
        TextView txtFirstOutput = findViewById(R.id.txtFirstOutput);
        //Create access to edit First name text
        EditText edtTxtFirstName = findViewById(R.id.edtTxtFirstName);


        //Get First name output
        txtFirstOutput.setText(edtTxtFirstName.getText().toString());


    }
}




