package dk.tec.movingeinstein;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout fm = findViewById(R.id.frmLayout);
        GraphicsEinstein ge = new GraphicsEinstein(this);
        Thread t1 = new Thread(ge);
        t1.start();
        fm.addView(ge);
    }
}