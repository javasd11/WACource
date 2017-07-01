package com.vados.wacource.lec14;

import android.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vados.wacource.lec14.fragment.Fragment4;

import java.util.ArrayList;

public class EditStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);
    }


    public Loader<ArrayList<Student>> onCreateLoader(int id, Bundle args){
        return new StudentsLoader(this);

    }

    private void showStudentts(ArrayList<Student> students ){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment4 fragment4 = Fragment4.newInstance(students);
        fragmentTransaction.replace( R.id.fragment,)
    }
}
