package com.example.ayuth.a08_input_controls;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;
    MultiAutoCompleteTextView multiAutoCompleteTextView;
    Spinner spinner;

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

        // Spinner
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.countries_name, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}
