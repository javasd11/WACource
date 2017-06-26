package com.vados.student.homework7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toastsButton:
                startActivity(new Intent(getApplicationContext(), ToastActivity.class));
                break;
            case R.id.buttonNotifications:
                startActivity(new Intent(getApplicationContext(), NotifActivity.class));
                break;
            case R.id.buttonMenu:
                startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                break;
            case R.id.buttonMenuContext:
                startActivity(new Intent(getApplicationContext(), ContextMenuActivity.class));
                break;

        }
    }
}
