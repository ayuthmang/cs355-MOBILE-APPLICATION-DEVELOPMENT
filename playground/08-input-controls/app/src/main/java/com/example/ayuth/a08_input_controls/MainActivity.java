package com.example.ayuth.a08_input_controls;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;
    MultiAutoCompleteTextView multiAutoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInstances();
    }

    public void initInstances() {
        setContentView(R.layout.activity_main);

        String[] countries = getResources().getStringArray(R.array.countries_name);

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> adapterOne = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        autoCompleteTextView.setAdapter(adapterOne);

        multiAutoCompleteTextView = findViewById(R.id.multiAutoCompleteTextView);
        ArrayAdapter<String> adapterTwo = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countries);
        multiAutoCompleteTextView.setAdapter(adapterTwo);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
