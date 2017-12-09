package com.example.ankitsingh.ankit_androidproject.activities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ankitsingh.ankit_androidproject.R;

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
                list_Activity();
            }
        });

    }

    protected void showAlertDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setTitle("Saio Nara");
        builder.setIcon(R.drawable.ic_delete_black_24dp);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                startActivity(new Intent(MainActivity.this, Image.class));
                texter.setText(editor.getText().toString());
            }
        });

           /* builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            })*/

        builder.show();
    }

    private void showCustomAlertDialog(){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.alertbox);

        Button yes = (Button)dialog.findViewById(R.id.btn_yes);
        Button no = (Button)dialog.findViewById(R.id.btn_no);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Image.class));
                dialog.dismiss();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    private  void list_Activity()
    {
        startActivity(new Intent(MainActivity.this,ListActivity.class));
    }
}
