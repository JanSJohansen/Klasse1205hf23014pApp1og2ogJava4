package com.example.spinnerprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] names = {"Christian", "Joachim", "Silas", "Frederik", "Nikolaj", "Rasmus", "Mike", "Jan"};
    TextView txtChosenName;
    TextView txtSaveName;
    Button btnSaveName;
    Spinner spnNames;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtChosenName = findViewById(R.id.txtChoosenName);
        txtSaveName = findViewById(R.id.txtSaveName);
        btnSaveName = findViewById(R.id.btnSaveName);
        btnSaveName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSaveName.setText(spnNames.getSelectedItem().toString());
            }
        });

        spnNames  =findViewById(R.id.spnNames);
        spnNames.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                names);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnNames.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        txtChosenName.setText(parent.getSelectedItem().toString() + "  Pos: " + position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}
}








