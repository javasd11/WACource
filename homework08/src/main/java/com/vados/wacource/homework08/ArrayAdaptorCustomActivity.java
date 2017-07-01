package com.vados.wacource.homework08;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.vados.wacource.homework08.domain.Student;

import java.util.ArrayList;
import java.util.List;

public class ArrayAdaptorCustomActivity extends AppCompatActivity {
    private ListView listView;
    private List<Student> mStudents;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_array_adaptor);
        listView = (ListView) findViewById(R.id.lvArrayCustom);

        mStudents = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            mStudents.add(new Student("ivan_" + i, "Ivanov_" + i, 20 + i));
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


    class StudentAdapter extends ArrayAdapter<Student> {

        private int mresource;
        private List<Student> mStudents;
        private LayoutInflater mInflater;


        public StudentAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Student> objects) {
            super(context, resource, objects);
            mresource = resource;
            mStudents = objects;
            mInflater = LayoutInflater.from(context);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            convertView = mInflater.inflate(mresource, null);
            Student student = mStudents.get(position);

            TextView fistNameText = (TextView) convertView.findViewById(R.id.textFirstName);
            fistNameText.setText(student.firstName);

            TextView lastName = (TextView) convertView.findViewById(R.id.textLAstName);
            lastName.setText(student.lastName);

            TextView age = (TextView) convertView.findViewById(R.id.textAge);

            if (position > 10) {
                age.setText(String.valueOf(student.age));
            }
            if (position % 2 == 0) {
                age.setText(String.valueOf(student.age));
                age.setTextColor(Color.RED);
            }


            return convertView;

        }
    }

}
