package com.androidacademia.toastdialogsnackdemo;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = findViewById(R.id.linearLayout);
    }

    public void alert(View view) {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        mBuilder.setTitle("Alert");
        mBuilder.setMessage("Low Battery!!!");
        mBuilder.setIcon(R.drawable.ic_action_alert);
        mBuilder.setPositiveButton("OK",null);

        AlertDialog alertDialog = mBuilder.create();
        alertDialog.show();

    }

    public void login(View view) {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View alertView = layoutInflater.inflate(R.layout.login_dialog,null);
        final EditText editTextusername = alertView.findViewById(R.id.editTextUN);
        final EditText editTextPassword = alertView.findViewById(R.id.editTextPassword);
        mBuilder.setView(alertView);
        mBuilder.setTitle("Login Dialog");
        mBuilder.setIcon(R.drawable.ic_action_alert);
        mBuilder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String username = editTextusername.getText().toString();
                String passwrod = editTextPassword.getText().toString();
                if (username.equals("girish") && passwrod.equals("123456")){

                    Snackbar.make(linearLayout,"Success",Snackbar.LENGTH_LONG).
                            setAction("Action", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //your logic
                                }
                            }).show();

                }else {
                    Toast.makeText(MainActivity.this, "Failed..", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBuilder.setNegativeButton("Cancel",null);
        AlertDialog alertDialog = mBuilder.create();
        alertDialog.show();
    }
}
