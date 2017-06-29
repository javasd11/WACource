package com.vados.wacource.homework08;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.vados.wacource.homework08.domain.Student;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayAdaptorActivity extends AppCompatActivity {
    private ListView listView;
    private List<Student> mStudents;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_array_adaptor);
        listView = (ListView) findViewById(R.id.lvArrayCustom);

        mStudents = new ArrayList<>();
        for(int i=0; i<50; i++){
            mStudents.add(new Student("ivan_"+i,"Ivanov_"+i, 20+i));
        }

        StudentAdapter studentAdapter = new StudentAdapter(this,R.layout.student_item,mStudents);
        listView.setAdapter(studentAdapter);
    }
}
