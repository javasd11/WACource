package com.example.homework10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.homework10.data.DatabaseHelper;
import com.example.homework10.model.Student;

public class ViewStudentActivity extends AppCompatActivity {
    private EditText editTextFirstName;
    private EditText editTextLastName;
    private EditText editAge;
    private Button buttonSave;
    private Button buttonEdit;
    private Button buttonClear;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);
        initViews();
        databaseHelper = new DatabaseHelper(this);
    }

    private void initViews() {
        Intent intent = getIntent();
        boolean isEditable = intent.getBooleanExtra(MainActivity.EXTRA_EDIT, false);

        editTextFirstName = (EditText) findViewById(R.id.editFirstName);
        editTextLastName = (EditText) findViewById(R.id.editLastName);
        editAge = (EditText) findViewById(R.id.editAge);
        buttonSave = (Button) findViewById(R.id.btnSave);


        if (!isEditable) {
            buttonSave.setVisibility(View.INVISIBLE);
            editTextFirstName.setFocusable(false);
            editTextFirstName.setEnabled(false);
            editTextLastName.setFocusable(false);
            editTextLastName.setEnabled(false);
            editAge.setFocusable(false);
            editAge.setEnabled(false);

        } else {
            buttonSave.setOnClickListener(onClickListener);
        }


    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Student student = new Student();
            student.FirstName = editTextFirstName.getText().toString();
            student.LastName = editTextLastName.getText().toString();
            student.Age = Integer.parseInt(editAge.getText().toString());
            if (validateEmptyStudent(student)) {
                databaseHelper.insert(student);
            }
        }
    };

    View.OnClickListener onClickListenerClear = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            editTextFirstName.setText("");
            editTextLastName.setText("");
            editAge.setText("");
        }
    }

    private boolean validateEmptyStudent(Student student) {
        if (student.FirstName.isEmpty() && student.LastName.isEmpty() && student.Age == 0) {
            return false;
        } else return true;
    }


}
