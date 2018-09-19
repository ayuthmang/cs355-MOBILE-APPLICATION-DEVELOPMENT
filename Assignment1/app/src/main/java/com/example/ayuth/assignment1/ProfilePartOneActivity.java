package com.example.ayuth.assignment1;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class ProfilePartOneActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etName;
    EditText etLastName;
    EditText etBirthDate;
    EditText etEmail;
    EditText etPhoneNo;
    Button btnSubmit;

    DatePickerDialog birthdatePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_part_one);
        initInstances();
    }

    public void initInstances() {
        etName = findViewById(R.id.etFirstName_part_1);
        etLastName = findViewById(R.id.etLastName_part_1);
        etBirthDate = findViewById(R.id.etBirthDate);
        etEmail = findViewById(R.id.etEmail_part_1);
        etPhoneNo = findViewById(R.id.etPhone_part_1);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(this);
        etBirthDate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnSubmit) {
            Intent profilePartTwo = new Intent(getBaseContext(), ProfilePartTwoActivity.class);
            profilePartTwo.putExtra("name", etName.getText().toString());
            profilePartTwo.putExtra("lastname", etLastName.getText().toString());
            profilePartTwo.putExtra("birthdate", etBirthDate.getText().toString());
            profilePartTwo.putExtra("email", etEmail.getText().toString());
            profilePartTwo.putExtra("phone", etPhoneNo.getText().toString());
            Toast.makeText(this, "kleJLKJLRKG", Toast.LENGTH_SHORT).show();
            startActivity(profilePartTwo);
        } else if (v == etBirthDate) {
            final Calendar cldr = Calendar.getInstance();
            int day = cldr.get(Calendar.DAY_OF_MONTH);
            int month = cldr.get(Calendar.MONTH);
            int year = cldr.get(Calendar.YEAR);
            // date picker dialog
            birthdatePicker = new DatePickerDialog(ProfilePartOneActivity.this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            etBirthDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                        }
                    }, year, month, day);
            birthdatePicker.show();
        }
    }
}

