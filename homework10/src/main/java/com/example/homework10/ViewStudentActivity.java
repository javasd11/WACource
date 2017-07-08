package com.example.homework10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.homework10.data.DatabaseHelper;
import com.example.homework10.model.Student;

public class ViewStudentActivity extends AppCompatActivity {
    private EditText editTextFirstName;
    private EditText editTextLastName;
    private EditText editAge;
    private Button buttonSave;
    private Button buttonClear;
    private DatabaseHelper databaseHelper;
    private boolean isEditStudent = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);

        databaseHelper = new DatabaseHelper(this);
        editTextFirstName = (EditText) findViewById(R.id.editFirstName);
        editTextLastName = (EditText) findViewById(R.id.editLastName);
        editAge = (EditText) findViewById(R.id.editAge);

        buttonSave = (Button) findViewById(R.id.btnSave);
        buttonClear = (Button) findViewById(R.id.btnClear);
        initViews();
    }

    private void initViews() {
        Intent intent = getIntent();
        boolean isAddNewStudent = intent.getBooleanExtra(MainActivity.EXTRA_EDIT, false);
        Student student = intent.getParcelableExtra(ListActivity.EXTRA_STUDENT);

        if (student!= null) {
            isEditStudent = true;
        }

        if (!isAddNewStudent) {
            editTextFirstName.setFocusable(false);
            editTextFirstName.setEnabled(false);
            editTextLastName.setFocusable(false);
            editTextLastName.setEnabled(false);
            editAge.setFocusable(false);
            editAge.setEnabled(false);

            buttonSave.setVisibility(View.INVISIBLE);
            buttonClear.setVisibility(View.INVISIBLE);

            setStudent(student);
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSave:
               Student student = getStudent();

                if (validateEmptyStudent(student)) {
                    if (!isEditStudent) {
                        if (databaseHelper.insert(student) != 0) {
                            clearFields();
                        } else {
                            if (databaseHelper.updateStudent(student) != 0) {
                                clearFields();
                            }
                        }
                    }
                }
                break;
            case R.id.btnClear:
                clearFields();
                break;
        }
    }

    private void setStudent(Student student) {
        editTextFirstName.setText(student.FirstName);
        editTextLastName.setText(student.LastName);
        editAge.setText(String.valueOf(student.Age));
    }

    private Student getStudent(){
        Student student = new Student();
        student.FirstName = editTextFirstName.getText().toString();
        student.LastName = editTextLastName.getText().toString();
        try {
            student.Age = Integer.parseInt(editAge.getText().toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        return student;
    }

    private void clearFields() {
        editTextFirstName.setText("");
        editTextLastName.setText("");
        editAge.setText("");
    }

    private boolean validateEmptyStudent(Student student) {
        if (student.FirstName.isEmpty() || student.LastName.isEmpty() || student.Age == 0) {
            Toast.makeText(this,"Fill all filelds", Toast.LENGTH_SHORT).show();
            return false;
        } else return true;
    }
}
