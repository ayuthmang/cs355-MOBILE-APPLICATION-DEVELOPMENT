package com.example.ayuth.assignment_2;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorMgr;
    private Sensor accSensor, magnetSensor;
    private static final int SHAKE_THRESHOLD = 800;
    private static final int SIAMSEE_LENGTH = 10;
    private long lastUpdate;
    private float last_x, last_y, last_z;
    private int predictedNum;
    private TextView tvSiamseeResultTitle, tvSiamseeResult;
    private ImageView imgSiamsee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();
    }

    private void initInstances() {
        tvSiamseeResult = findViewById(R.id.tvSiamseeResult);
        tvSiamseeResultTitle = findViewById(R.id.tvSiamseeResultTitle);

        sensorMgr = (SensorManager) getSystemService(SENSOR_SERVICE);
        accSensor = sensorMgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        magnetSensor = sensorMgr.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        sensorMgr.registerListener(this, accSensor, SensorManager.SENSOR_DELAY_NORMAL);
        sensorMgr.registerListener(this, magnetSensor, SensorManager.SENSOR_DELAY_NORMAL);

        imgSiamsee = findViewById(R.id.imgSiamsee);
        imgSiamsee.setImageResource(R.drawable.siamsee);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorMgr.unregisterListener(this, accSensor);
        sensorMgr.unregisterListener(this, magnetSensor);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorMgr.registerListener(this, accSensor, SensorManager.SENSOR_DELAY_NORMAL);
        sensorMgr.registerListener(this, magnetSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        try {

            if (event.sensor.getType() == SensorManager.SENSOR_ACCELEROMETER) {
                float x, y, z;
                long curTime = System.currentTimeMillis();
                // only allow one update every 100ms.
                if ((curTime - lastUpdate) > 100) {
                    long diffTime = (curTime - lastUpdate);
                    lastUpdate = curTime;

                    x = event.values[0];
                    y = event.values[1];
                    z = event.values[2];

                    float speed = Math.abs(x + y + z - last_x - last_y - last_z) / diffTime * 10000;

                    if (speed > SHAKE_THRESHOLD) {
//                    Log.d("sensor", "shake detected w/ speed: " + speed);
//                    Toast.makeText(this, "shake detected w/ speed: " + speed, Toast.LENGTH_SHORT).show();
                        // predict code here
                        predictedNum = randInt(0, SIAMSEE_LENGTH - 1);
//                    Toast.makeText(this, "num is " + predictedNum, Toast.LENGTH_SHORT).show();
                        showSiamsee(predictedNum);
                    }
                    last_x = x;
                    last_y = y;
                    last_z = z;
                }
            }
        } catch (Exception ex) {
            Log.e("onSensorChanged", ex.getMessage());
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    private void showSiamsee(int predictedNum) {
        String[] predictedArr = getResources().getStringArray(R.array.predictedCard);
        tvSiamseeResult.setText(predictedArr[predictedNum]);
    }
}

