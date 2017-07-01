package com.vados.wacource.lec14.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.vados.wacource.lec14.R;
import com.vados.wacource.lec14.Student;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment4 extends Fragment {
    public static final String EXTRA_STUDENT="com.vados.wacource.lec14.fragment.STUDENT";
    private ArrayList<Student> mStudents;
    private EditText mEditTextFirstName;
    private EditText mEditTextLastName;
    private EditText mEditTextAge;



    public Fragment4() {
    }

    public static Fragment4 newInstance(ArrayList<Student> students) {
        Fragment4 fragment4 = new Fragment4();
        Bundle args = new Bundle();
        args.putParcelableArrayList(EXTRA_STUDENT,students);
        fragment4.setArguments(args);
        return fragment4;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStudents = getArguments().getParcelableArrayList(EXTRA_STUDENT);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment4,container,false);
        ListView listView = (ListView) view.findViewById(R.id.lisView);

        mEditTextFirstName = view.findViewById(R.id.)

        ArrayAdapter<Student> studentArrayAdapter = new ArrayAdapter<Student>(getActivity(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1, mStudents);

        listView.setAdapter(studentArrayAdapter);
        return listView;


    }

}
