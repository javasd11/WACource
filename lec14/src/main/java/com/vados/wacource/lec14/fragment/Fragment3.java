package com.vados.wacource.lec14.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vados.wacource.lec14.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment3 extends Fragment {
    public static final String EXTRA_TEXT="com.vados.wacource.lec14.fragment.TEXT";



    public Fragment3() {
        // Required empty public constructor
    }

    public static Fragment3 newInstance(String text) {
        Fragment3 fragment3 = new Fragment3();
        Bundle args = new Bundle();
        args.putString(EXTRA_TEXT, text);
        fragment3.setArguments(args);
        return fragment3;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_fragment3,container,false);

        String text = getArguments().getString(EXTRA_TEXT);

        TextView textView = (TextView) view.findViewById(R.id.TextView);
        textView.setText(text);
        return view;
    }

}
