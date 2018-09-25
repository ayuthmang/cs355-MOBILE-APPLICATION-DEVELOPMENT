package com.example.ayuth.handlingruntimechanges;

import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class LayoutActivity extends AppCompatActivity {

    TextView tvLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        tvLayout = findViewById(R.id.tvLayout);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        String oldText = tvLayout.getText().toString();
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            tvLayout.setText(oldText + " Landscape");
            Toast.makeText(this, "ORIENTATION_LANDSCAPE", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            tvLayout.setText(oldText + " Portrait");
            Toast.makeText(this, "ORIENTATION_PORTRAIT", Toast.LENGTH_SHORT).show();
        }
    }
}
