package com.indooratlas.android.sdk.indoornavigation.imageview;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;

public class SensorListener implements SensorEventListener{
    private float pressure;

    @Override
    public void onAccuracyChanged (Sensor sensor, int accuracy){
        //TODO
    }

    @Override
    public void onSensorChanged(SensorEvent event){
        //TODO
        long timestamp = event.timestamp;
        float value = event.values[0];
        for(int x = 0; x < event.values.length; x++){
            Log.d("barometer", "timestamp is : " + timestamp + ", value : " + event.values[x]);

        }
        this.pressure = value;
    }

    public float getPressure(){
        return this.pressure;
    }


}
