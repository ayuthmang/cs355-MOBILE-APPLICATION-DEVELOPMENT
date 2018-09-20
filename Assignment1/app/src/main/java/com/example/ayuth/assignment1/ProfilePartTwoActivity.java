package com.example.ayuth.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ProfilePartTwoActivity extends AppCompatActivity {

    EditText etName;
    EditText etLastName;
    EditText etAge;
    EditText etEmail;
    EditText etPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_part_two);
    }

    public void initInstances() {
        etName = findViewById(R.id.etFirstName_part_2);
        etLastName = findViewById(R.id.etLastName_part_2);
        etAge = findViewById(R.id.etAge);
        etEmail = findViewById(R.id.etEmail_part_2);
        etPhone = findViewById(R.id.etPhone_part_2);
    }
}
