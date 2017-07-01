package com.vados.wacource.lec14;

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
        switch (view.getId()){
            case R.id.bt1:
                startActivity(new Intent(this, FragmentStaticActivity.class));
                break;
            case R.id.bt2:
                startActivity(new Intent(this, ChangeFragmentsActivity.class));
                break;
            case R.id.bt3:
                break;
            case R.id.bt4:
                break;
            case R.id.bt5:
                break;
            case R.id.bt6:
                break;
            case R.id.bt7:
                break;
        }
    }
}
