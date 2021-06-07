package com.example.uibasicsv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBoxHarry, checkBoxMatrix, checkBoxJoker;
    private RadioGroup rgMaritalStatus;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxHarry = findViewById(R.id.checkboxHarry);
        checkBoxMatrix = findViewById(R.id.checkboxMatrix);
        checkBoxJoker = findViewById(R.id.checkboxJoker);

        //Instantiate progress bar
        //Add progress to ChangedListener switch
        progressBar = findViewById(R.id.progressBar);

        //Create a thread for the horizontal progress bar
        Thread thread = new Thread(new Runnable() {
          //Thread will increment the progress bar by 10
            @Override
            public void run() {
                for(int i=0; i < 10; i++){
                    progressBar.incrementProgressBy(10);
                    SystemClock.sleep(500);
                }
            }
        });
        //Start thread
        thread.start();

        //progressBar.getProgress();

        //Instantiate RadioButtons
        rgMaritalStatus = findViewById(R.id.rgMaritalStatus);

        //This type of method is used to preload the bubble button messages
        int checkedButton = rgMaritalStatus.getCheckedRadioButtonId();
            switch(checkedButton) {
                case R.id.rbMarried: Toast.makeText(MainActivity.this, "Married", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.rbSingle: Toast.makeText(MainActivity.this, "Single", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.rbInRel: Toast.makeText(MainActivity.this, "Relationship", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }


        //Call this button when its pressed
        rgMaritalStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbMarried: Toast.makeText(MainActivity.this, "Married", Toast.LENGTH_SHORT).show();
                    break;
                    case R.id.rbSingle: Toast.makeText(MainActivity.this, "Single", Toast.LENGTH_SHORT).show();
//                        progressBar.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rbInRel: Toast.makeText(MainActivity.this, "Relationship", Toast.LENGTH_SHORT).show();
  //                      progressBar.setVisibility(View.GONE);
                        break;
                    default:
                        break;

                }

            }
        });


        //Instantiate CheckBoxes
        if (checkBoxHarry.isChecked()) {
            Toast.makeText(MainActivity.this, "You have to watch Harry Potter", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "You Need to watch Harry Potter", Toast.LENGTH_SHORT).show();

        }

        //Add listeners to  the button
        checkBoxHarry.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked) {
                    //Toaste.make test shows te,porary bubble messages
                    Toast.makeText(MainActivity.this, "You have to watch Harry Potter", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "You Need to watch Harry Potter", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
}