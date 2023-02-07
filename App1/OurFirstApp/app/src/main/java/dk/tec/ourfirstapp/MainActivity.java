package dk.tec.ourfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnOK;
    Button btnCancel;
    TextView txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMessage = findViewById(R.id.txtMessage);

        btnOK = findViewById(R.id.btnOK);
        btnOK.setOnClickListener(this);

        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtMessage.setText("Der blev trykket på Cancel");
            }
        });
    }

    @Override
    public void onClick(View v) {
        //txtMessage.setText("Der blev trykket");
        txtMessage.setText(getResources().getString(R.string.btnCancelStr));
    }
}