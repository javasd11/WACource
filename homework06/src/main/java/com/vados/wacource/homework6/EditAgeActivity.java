package com.vados.wacource.homework6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.vados.wacource.homework6.domain.Student;

public class EditAgeActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private Student student;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_age);

        textView = (TextView) findViewById(R.id.edg_textView);
        editText = (EditText) findViewById(R.id.edg_editText);

        Intent intent = getIntent();
        student = intent.getParcelableExtra(MainActivity.EXTRA_STUDENT);


        textView.setText(String.format("Имя: %s, Фамилия: %s", student.name, student.lastName));
        editText.setText(String.valueOf(student.age));
    }

    public void onClick(View view) {
        student.age = Integer.parseInt(editText.getText().toString());

        Intent intent = new Intent();
        intent.putExtra(MainActivity.EXTRA_STUDENT, student);
        setResult(RESULT_OK, intent);
        finish();
    }
}
