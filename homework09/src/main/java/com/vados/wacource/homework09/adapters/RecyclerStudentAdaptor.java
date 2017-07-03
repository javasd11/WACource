package com.vados.wacource.homework09.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vados.wacource.homework09.models.Student;
import com.vados.wacource.homework09.viewholder.StudentViewHolder;

import java.util.ArrayList;

/**
 * Created by ReznichenkoV on 03.07.2017.
 */

public class RecyclerStudentAdaptor extends RecyclerView.Adapter<StudentViewHolder> {

    private ArrayList<Student> mStudents;
    private int mResource;
    private LayoutInflater mInflater;

    public RecyclerStudentAdaptor(Context  context, ArrayList<Student> students, int resource) {
        mResource = resource;
        mStudents = students;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(mResource,parent,false);
        return  new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {
        final Student student = mStudents.get(position);
        holder.set(student);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener!=null){
                    mListener.onClick(student);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return mStudents.size();
    }



    public interface  OnClickListener{
        void onClick(Student student);
    }

    private OnClickListener mListener;

    public void setOnClickListener(OnClickListener listener){
        mListener =listener;
    }
}
