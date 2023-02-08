package com.example.navigatemoreactivities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityResultLauncher<Intent> secondActivityLauncher;
    TextView txtFromSecond;
    Button btnGoToSecond;
    EditText txtToSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFromSecond = findViewById(R.id.txtFromSecond);
        btnGoToSecond = findViewById(R.id.btnGoToSecond);
        txtToSecond = findViewById(R.id.txtToSecond);

        btnGoToSecond.setOnClickListener(this);

        secondActivityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if(result.getResultCode() == Activity.RESULT_OK)
                    {
                        Intent intent = result.getData();
                        String text = intent.getStringExtra("textFromSecond");
                        txtFromSecond.setText(text);
                    }
                }
        );
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,SecondActivity.class);
        String text = txtToSecond.getText().toString();
        intent.putExtra("textFromCaller", text);
        //startActivity(intent);
        //startActivityForResult(intent, 1)
        secondActivityLauncher.launch(intent);
    }
}







