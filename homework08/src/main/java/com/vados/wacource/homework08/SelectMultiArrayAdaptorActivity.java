package com.vados.wacource.homework08;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SelectMultiArrayAdaptorActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_select);
        listView = (ListView) findViewById(R.id.lvArraySelect);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);

        final String[] catNames = new String[]{"Рыжик", "Барсик", "Мурзик"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, android.R.id.text1, catNames);

        listView.setAdapter(adapter);
    }

    public void onClick(View view) {

        String str = "";
        SparseBooleanArray items = listView.getCheckedItemPositions();

        for (int i = 0; i <= items.size(); i++) {
            if (items.get(i)) {
                str += i + ",";
            }
        }
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
