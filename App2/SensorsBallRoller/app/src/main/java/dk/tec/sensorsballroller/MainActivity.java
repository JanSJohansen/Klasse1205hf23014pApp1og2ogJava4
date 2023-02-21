package dk.tec.sensorsballroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener, View.OnClickListener
{
    TextView txtXY, txtXZ, txtZY;
    Button btnShowGraphics;
    SensorManager sensormanager;
    LinearLayout theLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtXY = findViewById(R.id.txtXY);
        txtXZ = findViewById(R.id.txtXZ);
        txtZY = findViewById(R.id.txtZY);
        theLayout = findViewById(R.id.theLayout);
        btnShowGraphics = findViewById(R.id.btnShowGraphics);
        btnShowGraphics.setOnClickListener(this);

        sensormanager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        sensormanager.registerListener(this,
                sensormanager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        sensormanager.unregisterListener(this);
    }
    @Override
    public void onSensorChanged(SensorEvent event)
    {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            updateValues(event.values);
        }
    }
    public void updateValues(float[] values)
    {
        txtXY.setText(String.format("%8.1f", values[0]));
        txtXZ.setText(String.format("%8.1f", values[1]));
        txtZY.setText(String.format("%8.1f", values[2]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) { }

    @Override
    public void onClick(View v)
    {
        BallRoller br = new BallRoller(this);
        theLayout.addView(br);
        sensormanager.unregisterListener(this);
        sensormanager.registerListener(br,
                sensormanager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                300000);
    }
}