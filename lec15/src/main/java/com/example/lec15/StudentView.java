package com.example.lec15;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.lec15.models.Student;
import com.vados.wacource.lec15.R;

/**
 * Created by vadim on 04.07.2017.
 */

public class StudentView extends RelativeLayout{
    private RequiredEditText editTextFirstName;
    private RequiredEditText editTextLastName;
    private RequiredEditText editTextAge;

    private Student mStudent;


    public StudentView(Context context) {
        super(context);
        init(context);

    }

    public StudentView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.student,this);

        editTextFirstName = (RequiredEditText) view.findViewById(R.id.editTextFirstName);
        editTextFirstName = (RequiredEditText) view.findViewById(R.id.editTextFirstName);
        editTextFirstName = (RequiredEditText) view.findViewById(R.id.editTextAge);


    }

    public void setStudent(Student student){
        mStudent = student;

        if(student!=null){
            editTextFirstName.setText(student.firstName);
            editTextFirstName.setText(student.lastName);
            editTextFirstName.setText(String.valueOf(student.age));
        }
    }


    public  Student get(){
        if(mStudent!=null){
            return null;
        }

        mStudent.firstName = editTextFirstName.getText().toString();
        mStudent.lastName = editTextLastName.getText().toString();
        mStudent.age = (int) Long.parseLong(editTextAge.getText().toString());

        return mStudent;
    }

    public void clear(){
        mStudent=null;

        editTextFirstName.setText(null);
        editTextFirstName.setText(null);
        editTextFirstName.setText(null);

        editTextFirstName.setError(null);
        editTextLastName.setError(null);
        editTextAge.setError(null);

    }


    public boolean validate(){
        return editTextFirstName.validate() & editTextLastName.validate() & editTextAge.validate();
    }
}
