package dk.tec.jaj;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import dk.tec.jaj.views.MyGraphics;

public class MainActivity extends AppCompatActivity
{
    FrameLayout frmLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frmLayout = findViewById(R.id.frmLayout);
        MyGraphics mg = new MyGraphics(this);
        frmLayout.addView(mg, 0);

    }
}









