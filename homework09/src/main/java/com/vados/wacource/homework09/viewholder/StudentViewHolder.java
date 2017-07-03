package com.vados.wacource.homework09.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.vados.wacource.homework09.R;
import com.vados.wacource.homework09.models.Student;

/**
 * Created by ReznichenkoV on 03.07.2017.
 */

public class StudentViewHolder extends RecyclerView.ViewHolder{
    private TextView mTextViewFirstName;
    private TextView mTextViewLastName;
    private TextView mTextViewAge;


    public StudentViewHolder(View itemView) {
        super(itemView);
        mTextViewFirstName = (TextView) itemView.findViewById(R.id.txtViewFirstName);
        mTextViewLastName = (TextView) itemView.findViewById(R.id.txtViewLastName);
        mTextViewAge = (TextView) itemView.findViewById(R.id.txtViewAge);
    }

    private void clear(){
        mTextViewFirstName.setText(null);
        mTextViewLastName.setText(null);
        mTextViewAge.setText(null);
    }


    public void set(Student student){
        clear();
        mTextViewFirstName.setText(student.firstName);
        mTextViewLastName.setText(student.lastName);
        mTextViewAge.setText(String.valueOf(student.age));
    }
}
