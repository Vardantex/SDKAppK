package com.example.freepersonaworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText edtTxtName, edtTxtEmail, edtTxtPass, edtTxtPassRepeat;
    private Button btnPickImage, btnRegister;
    private TextView txtWarnName, txtWarnEmail, txtWarnPass, txtWarnPassRepeat;
    private Spinner countriesSpinner;
    private RadioGroup rgGender;
    private CheckBox agreementCheckBox;
    private ConstraintLayout parent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        //Onclick listener for pick image button
        btnPickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Coming soon...", Toast.LENGTH_SHORT).show();
            }
        });

        //Create a On click listener for register
        btnRegister.setOnClickListener(v -> initRegister());

    } //End on create

        private void initRegister() {

            if(validateData()) {

                if (agreementCheckBox.isChecked()) {

                    showSnackBar();
                } else {
                    Toast.makeText(this, "Confirm agreement", Toast.LENGTH_SHORT).show();
                }

            }
        }

        //Create SnackBar
    private void showSnackBar() {

        txtWarnName.setVisibility(View.GONE);
        txtWarnEmail.setVisibility(View.GONE);
        txtWarnPass.setVisibility(View.GONE);
        txtWarnPassRepeat.setVisibility(View.GONE);


        String name = edtTxtName.getText().toString();
        String email = edtTxtEmail.getText().toString();
        String country = countriesSpinner.getSelectedItem().toString();
        //Set the switch to empty by defaut and use a switch for gender
        String gender = "";
        switch(rgGender.getCheckedRadioButtonId()) {

            case R.id.rbMale:
                gender = "Male";
                break;
            case R.id.rbFemale:
                gender = "Female";
                break;
            case R.id.rbOther:
                gender = "Other";
                break;

            default:
                gender = "Unknown";
                break;
        }

        String snackText = "Name: " + name + "\n" +
                "Email: " + email + "\n" +
                "Gender: " + gender + "\n" +
                "Country: " + country;




        Snackbar.make(parent, "User Registered", Snackbar.LENGTH_INDEFINITE)
                .setAction("Dismiss", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        edtTxtName.setText("");
                        edtTxtEmail.setText("");
                        edtTxtPass.setText("");
                        edtTxtPassRepeat.setText("");

                    }

                }).show();
    }


    private boolean validateData() {
        //Check if the text given is empty
        if (edtTxtName.getText().toString().equals("")) {
            txtWarnName.setVisibility(View.VISIBLE);
            txtWarnName.setText("Enter a name");
            return false;
        }

        if(edtTxtEmail.getText().toString().equals("")) {
            txtWarnEmail.setVisibility(View.VISIBLE);
            txtWarnEmail.setText("Enter an email");
            return false;
        }

        if(edtTxtPass.getText().toString().equals("")) {
            txtWarnPass.setVisibility(View.VISIBLE);
            txtWarnPass.setText("Enter a password");
            return false;
        }

        if(edtTxtPassRepeat.getText().toString().equals("")) {
            txtWarnPassRepeat.setVisibility(View.VISIBLE);
            txtWarnPassRepeat.setText("Error confirming password");
            return false;
        }

        if (edtTxtPass.getText().toString().equals(edtTxtPassRepeat.getText().toString())) {
            
            txtWarnPassRepeat.setVisibility(View.VISIBLE);
            txtWarnPassRepeat.setText("Password doesn't match");
            return false;

        }

    return true;
    }

    private void initViews() {

        edtTxtName = findViewById(R.id.edtTxtName);
        edtTxtEmail = findViewById(R.id.edtTxtEmail);
        edtTxtPass = findViewById(R.id.edtTxtPass);
       // edtTxtPassRepeat = findViewById(R.id.edtTxtPassRepeat);

        btnPickImage = findViewById(R.id.btnPickImage);
        btnRegister = findViewById(R.id.btnRegister);

        txtWarnName = findViewById(R.id.txtWarnName);
        txtWarnEmail = findViewById(R.id.txtWarnEmail);
        txtWarnPass = findViewById(R.id.txtWarnPass);
      //  txtWarnPassRepeat = findViewById(R.id.txtWarnPassRepeat);

        countriesSpinner = findViewById(R.id.spinnerCountry);
        rgGender = findViewById(R.id.rgGender);
        agreementCheckBox = findViewById(R.id.agreementCheckBox);
        parent = findViewById(R.id.parent);





    }
}