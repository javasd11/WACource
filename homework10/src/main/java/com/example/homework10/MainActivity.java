package com.example.homework10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_EDIT = "com.example.homework10.EDIT";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                Intent intent = new Intent(this, ViewStudentActivity.class);
                intent.putExtra(EXTRA_EDIT,true);
                startActivity(intent);
                break;
            case R.id.btn2:
                startActivity(new Intent(this, ListActivity.class));
                break;

        }
    }
}
