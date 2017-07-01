package com.vados.wacource.homework08;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.vados.wacource.homework08.domain.Student;

public class ArrayAdaptorMyActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mu_array_adaptor);
        listView = (ListView) findViewById(R.id.lvArray);



        Student[] students = new Student[]{
                new Student("Ivan1", "Ivanov1", 20),
                new Student("Ivan2", "Ivanov2", 20),
                new Student("Ivan3", "Ivanov3", 20),
                new Student("Ivan4", "Ivanov4", 20),
        };

        ArrayAdapter<Student> adapter = new ArrayAdapter<Student>(this, android.R.layout.simple_list_item_1, students);

        listView.setAdapter(adapter);
    }
}
