package com.vados.wacource.homework08;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ArrayAdaptorActivity extends AppCompatActivity {
    private  ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adaptor);

        listView = (ListView) findViewById(R.id.lvArray);

        final String[] catNames = new String[] { "Рыжик", "Барсик", "Мурзик" };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, catNames);

        listView.setAdapter(adapter);
    }
}
