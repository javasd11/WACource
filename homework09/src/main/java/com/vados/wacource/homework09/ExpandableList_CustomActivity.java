package com.vados.wacource.homework09;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.vados.wacource.homework09.adapters.ExpandableStudentAdaper;
import com.vados.wacource.homework09.models.Group;
import com.vados.wacource.homework09.models.Student;

import java.util.ArrayList;
import java.util.Random;

public class ExpandableList_CustomActivity extends AppCompatActivity {
    private ExpandableListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list__custom);

        listView = (ExpandableListView) findViewById(R.id.exlist2);

        ArrayList<Group> groups = new ArrayList<>();


        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            Group group = new Group();
            group.GroupName = "Numver" + i;
            Student[] students = new Student[random.nextInt(5)];
            for (int j = 0; j < students.length; j++) {
                students[j] = new Student("Ivan" + i + "" + j, "Petrov" + i + "" + j, 22 + i + j);
            }
            group.students = students;
            groups.add(group);

        }


        ExpandableStudentAdaper adaper = new ExpandableStudentAdaper(
                this,
                groups,
                R.layout.group_item,
                R.layout.child_item);

        listView.setAdapter(adaper);

    }
}
