package com.vados.wacource.homework08;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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

        final StudentAdapter studentAdapter = new StudentAdapter(this, R.layout.student_item, mStudents);
        listView.setAdapter(studentAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = mStudents.get(position);
                Toast.makeText(getApplicationContext(), student.toString(), Toast.LENGTH_LONG).show();
                student.age = 0;
                mStudents.set(position, student);
                studentAdapter.notifyDataSetChanged();

            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return false;
            }
        });
    }



}
