package com.vados.wacource.homework08;

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

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSimpleAdaptor:
                startActivity(new Intent(getApplicationContext(), SimpleAdaptorActivity.class));
                break;
            case R.id.btnMySimpleAdaptor:
                startActivity(new Intent(getApplicationContext(), MySimpleAdaptorActivity.class));
                break;
            case R.id.btnSimpleSpiner:
                startActivity(new Intent(getApplicationContext(), SimpleSpinerActivity.class));
                break;
            case R.id.btnArrayAdaptor:
                startActivity(new Intent(getApplicationContext(), ArrayAdaptorActivity.class));
                break;
            case R.id.btnMyArrayAdaptor:
                startActivity(new Intent(getApplicationContext(), MyArrayAdaptorActivity.class));
                break;

        }
    }
}
