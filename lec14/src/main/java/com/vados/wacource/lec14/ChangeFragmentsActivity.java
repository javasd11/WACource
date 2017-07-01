package com.vados.wacource.lec14;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.vados.wacource.lec14.fragment.Fragment1;
import com.vados.wacource.lec14.fragment.Fragment2;
import com.vados.wacource.lec14.fragment.Fragment3;

public class ChangeFragmentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_fragments);
    }

    public void onClick(View view) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()) {
            case R.id.button:
                Fragment1 fragment1 = new Fragment1();
                fragmentTransaction.replace(R.id.fragment,fragment1);
                break;
            case R.id.button1:
                Fragment2 fragment2 = new Fragment2();
                fragmentTransaction.replace(R.id.fragment,fragment2);
                break;
            case R.id.button2:
                Fragment3 fragment3 =  Fragment3.newInstance("new text");
                fragmentTransaction.replace(R.id.fragment,fragment3);
                break;
        }
        fragmentTransaction.commit();
    }
}
