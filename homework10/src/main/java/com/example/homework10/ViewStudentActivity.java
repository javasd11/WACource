package com.example.homework10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ViewStudentActivity extends AppCompatActivity {
    private EditText editTextFirstName;
    private EditText editTextLastName;
    private EditText editAge;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);
        initViews();
    }

    private void initViews(){
        Intent intent = getIntent();
        boolean isEditable = intent.getBooleanExtra(MainActivity.EXTRA_EDIT,false);

        editTextFirstName = (EditText) findViewById(R.id.editFirstName);
        editTextLastName = (EditText) findViewById(R.id.editLastName);
        editAge = (EditText) findViewById(R.id.editAge);


        if(isEditable){


        }

    }
}
