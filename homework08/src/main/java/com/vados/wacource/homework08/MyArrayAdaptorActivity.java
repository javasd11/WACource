package com.vados.wacource.homework08;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MyArrayAdaptorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mu_array_adaptor);

        String[] values = new String[]{
                "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2"};
    }
}
