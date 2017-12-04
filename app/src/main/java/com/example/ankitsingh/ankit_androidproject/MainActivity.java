package com.example.ankitsingh.ankit_androidproject;

import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editor;
    TextView texter;
    Button viewbuttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editor = (EditText) findViewById(R.id.Ankit123);
        texter = (TextView) findViewById(R.id.Ankit124);
        viewbuttons = (Button) findViewById(R.id.Ankit125);
        viewbuttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texter.setText(editor.getText().toString());


            }
        });

    }
}
