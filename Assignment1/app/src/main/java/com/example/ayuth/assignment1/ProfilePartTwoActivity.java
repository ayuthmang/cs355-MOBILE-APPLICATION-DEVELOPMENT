package com.example.ayuth.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import java.time.LocalDate;
import java.util.Calendar;

public class ProfilePartTwoActivity extends AppCompatActivity {

    EditText etName;
    EditText etLastName;
    EditText etAge;
    EditText etEmail;
    EditText etPhone;
    ImageView imgProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_part_two);
        initInstances();
    }

    public void initInstances() {
        etName = findViewById(R.id.etFirstName_part_2);
        etLastName = findViewById(R.id.etLastName_part_2);
        etAge = findViewById(R.id.etAge);
        etEmail = findViewById(R.id.etEmail_part_2);
        etPhone = findViewById(R.id.etPhone_part_2);
        imgProfile = findViewById(R.id.imgProfile);

        etName.setText(getIntent().getStringExtra("name"));
        etLastName.setText(getIntent().getStringExtra("lastname"));
        etAge.setText(getAgeByBirthdate(getIntent().getStringExtra("birthdate")));
        etEmail.setText(getIntent().getStringExtra("email"));
        etPhone.setText(getIntent().getStringExtra("phone"));
    }


    private int setImageByAge(int age) {
        return 0;
    }

    private String getAgeByBirthdate(String DOB) {
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        String[] birthdate = DOB.split("/");
        dob.set(Integer.parseInt(birthdate[2]), Integer.parseInt(birthdate[1]), Integer.parseInt(birthdate[0]));

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        Integer ageInt = new Integer(age);
        String ageS = ageInt.toString();

        return ageS;
    }
}
