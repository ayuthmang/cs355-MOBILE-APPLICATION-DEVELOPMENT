package com.example.ayuth.handlingruntimechanges;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnShowLayoutChanged;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowLayoutChanged = findViewById(R.id.btnShowLayoutChanged);
        btnShowLayoutChanged.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnShowLayoutChanged) {
            Intent layoutIntent = new Intent(this, LayoutActivity.class);
            startActivity(layoutIntent);
        }
    }
}
