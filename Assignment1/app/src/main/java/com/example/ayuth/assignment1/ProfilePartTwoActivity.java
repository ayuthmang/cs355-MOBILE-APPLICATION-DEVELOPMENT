package com.example.ayuth.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

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

        String age = getAgeByBirthdate(getIntent().getStringExtra("birthdate"));

        etName.setText(getIntent().getStringExtra("name"));
        etLastName.setText(getIntent().getStringExtra("lastname"));
        etAge.setText(String.format("%s %s", age, "years"));
        etEmail.setText(getIntent().getStringExtra("email"));
        etPhone.setText(getIntent().getStringExtra("phone"));

        setProfileImageByAge(Integer.parseInt(age.toString()));
    }


    private void setProfileImageByAge(int age) {
        if (age >= 0 && age <= 15) {
            imgProfile.setImageResource(R.drawable.baby);
        } else if (age >= 16 && age <= 25) {
            imgProfile.setImageResource(R.drawable.teen);
        } else if (age >= 26 && age <= 60) {
            imgProfile.setImageResource(R.drawable.adult);
        } else {
            imgProfile.setImageResource(R.drawable.old);
        }
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
