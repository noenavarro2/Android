package com.example.noenavarro.acelerometro;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    Vista vista ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SensorManager miSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor miSensor = miSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        miSensorManager.registerListener(this, miSensor, SensorManager.SENSOR_DELAY_FASTEST);
        vista = new Vista(this);
        setContentView(vista );
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        int x = (int) sensorEvent.values[0];//nos devuelve un objeto de la super clase por loque lo casteamos a int
        int y = (int) sensorEvent.values[1];
        //en la x y en la y no te da la posicion de x sino lo de la inclinacion
        int z = (int) sensorEvent.values[2];// es el de la z y no lo usamos
        Log.i("Sensor: ","x= "+ x +"y = " +y ); //mostrar en pantalla los valores
        vista.mover(x,y);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
