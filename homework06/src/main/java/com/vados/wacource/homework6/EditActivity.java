package com.vados.wacource.homework6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.vados.wacource.homework6.domain.Student;

public class EditActivity extends AppCompatActivity {
    private EditText eName;
    private EditText eLastName;
    private TextView ageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        eName = (EditText) findViewById(R.id.eda_editName);
        eLastName = (EditText) findViewById(R.id.eda_editLastName);
        ageView = (TextView) findViewById(R.id.eda_textAge);

        Student student = getIntent().getParcelableExtra(MainActivity.EXTRA_STUDENT);

        eName.setText(student.name);
        eLastName.setText(student.lastName);
        ageView.setText(String.valueOf(student.age));
    }

    public void saveAction(View view){

        Student st = new Student(
                eName.getText().toString(),
                eLastName.getText().toString(),
                Integer.parseInt((String) ageView.getText())  );

        Intent intent = new Intent();
        intent.putExtra(MainActivity.EXTRA_STUDENT,st);
        setResult(RESULT_OK,intent);
        finish();
    }
}
