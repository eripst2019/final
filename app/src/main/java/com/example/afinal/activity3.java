package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class activity3 extends AppCompatActivity implements SensorEventListener {


    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        Log.d(TAG, "onSensorChanged: X: " + sensorEvent.values[0] + " Y="+ sensorEvent.values[1]+ "Z:"+ sensorEvent.values [2 ]);
     xValue.setText("xValue: "+ sensorEvent.values[0]);
        yValue.setText("xValue: "+ sensorEvent.values[1]);
        zValue.setText("xValue: "+ sensorEvent.values[2]);
    }


private static final String TAG = "MainActivity";
    private SensorManager sensorManager;
    Sensor accelerometer;
    TextView xValue, yValue, zValue;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3);


        xValue = (TextView) findViewById(R.id.xValue);
        yValue = (TextView) findViewById(R.id.yValue);
        zValue = (TextView) findViewById(R.id.zValue);
        Log.d(TAG, "onCreate: Initializing Sensor Services");
        sensorManager =(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorManager.registerListener(activity3.this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);

        Log.d(TAG, "onCreate: Registered accelerometer listener");



}

}