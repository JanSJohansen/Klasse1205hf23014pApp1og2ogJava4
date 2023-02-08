package com.example.navigatemoreactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtFromCaller;
    Button btnGoBack;
    EditText txtToCaller;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtFromCaller = findViewById(R.id.txtFromCaller);
        btnGoBack = findViewById(R.id.btnGoBack);
        btnGoBack.setOnClickListener(this);
        txtToCaller = findViewById(R.id.txtToCaller);


        intent = getIntent(); // Hent det intent, som brugt til at starte denne
        String text = intent.getStringExtra("textFromCaller");
        txtFromCaller.setText(text);
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {

        intent.putExtra("textFromSecond", txtToCaller.getText().toString() );
        setResult(Activity.RESULT_OK, intent);

        finish();
    }

    @Override
    public void onBackPressed() {  // Eventhandler for standard Back-knap
        super.onBackPressed();
    }
}







