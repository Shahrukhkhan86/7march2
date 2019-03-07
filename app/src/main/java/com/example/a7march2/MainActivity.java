package com.example.a7march2;

import android.app.backup.SharedPreferencesBackupHelper;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1=findViewById(R.id.edit1);
        edit2=findViewById(R.id.edit2) ;
        button=findViewById(R.id.button);

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences=getSharedPreferences("com.example.a7march2",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();


    }
}
