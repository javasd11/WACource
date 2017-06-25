package com.vados.student.homework7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.toastsButton:
                intent = new Intent(getApplicationContext(), ToastActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonNotifications:
                intent = new Intent(getApplicationContext(), NotifActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonMenu:
                intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
                break;

        }
    }
}
