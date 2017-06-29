package com.vados.wacource.homework08;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.vados.wacource.homework08.domain.Student;

import java.util.List;

/**
 * Created by vadim on 29.06.2017.
 */

public class StudentAdapter extends ArrayAdapter<Student> {

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

        TextView fistNameText =(TextView) convertView.findViewById(R.id.textFirstName);
        fistNameText.setText(student.firstName);

        TextView lastName = (TextView) convertView.findViewById(R.id.textLAstName);
        lastName.setText(student.lastName);

        TextView age = (TextView) convertView.findViewById(R.id.textAge);
        age.setText(String.valueOf(student.age));

        return convertView;

    }
}
