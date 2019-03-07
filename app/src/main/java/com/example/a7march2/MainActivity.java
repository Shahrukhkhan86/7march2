package com.example.a7march2;

import android.app.backup.SharedPreferencesBackupHelper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText,edittxt1;
    Button button;
    String s1;
    String s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText =findViewById(R.id.editText);
        edittxt1 = findViewById(R.id.editText1);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = editText.getText().toString().trim();
                String pass = edittxt1.getText().toString().trim();
                if(user.equals(s1)&& pass.equals(s2))
                {

                    Toast.makeText(MainActivity.this, "user name successful", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, " not successfull", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    protected void onPause() {

        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.a7march2",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username",editText.getText().toString().trim());
        editor.putString("password",edittxt1.getText().toString().trim());
        editor.putBoolean("bool",true);
        editor.apply();

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.a7march2",MODE_PRIVATE);
        s1= sharedPreferences . getString("name","user");
        s2 = sharedPreferences .getString("password","12345");
        Boolean remember = sharedPreferences.getBoolean("bool",false);
        Toast.makeText(this, "bool"+remember, Toast.LENGTH_SHORT).show();
        editText.setText(s1);
        edittxt1.setText(s2);
    }
}
