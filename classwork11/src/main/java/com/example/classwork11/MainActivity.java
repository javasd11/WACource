package com.example.classwork11;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        SharedPreferences preferences;
        SharedPreferences.Editor editor;
        switch (view.getId()) {
            case R.id.btn1:
                preferences = getPreferences(MODE_PRIVATE);
                editor = preferences.edit();
                editor.putString("Text", "I am text");
                editor.commit();
                break;
            case R.id.btn2:
                preferences = getSharedPreferences("MyPref", MODE_PRIVATE);
                editor = preferences.edit();
                editor.putString("Text", "I am text");
                editor.commit();
                break;
            case R.id.btn3:
                preferences = getPreferences( MODE_PRIVATE);
                Toast.makeText(this,preferences.getString("Text","DEFAULT"),Toast.LENGTH_SHORT ).show();
                break;
            case R.id.btn4:
                preferences = getSharedPreferences("MyPref", MODE_PRIVATE);
                Toast.makeText(this,preferences.getString("Text","DEFAULT"),Toast.LENGTH_SHORT ).show();

                break;
            case R.id.btn5:
                startActivity(new Intent(this, PrefActivity.class));
                break;
            case R.id.btn6:
                preferences = PreferenceManager.getDefaultSharedPreferences(this);
                Toast.makeText(this,preferences.getString("edit_text_preference_2","---"),Toast.LENGTH_SHORT).show();
                //preferences.getString("edit_text_preference_2","---");

                break;

        }
    }
}
