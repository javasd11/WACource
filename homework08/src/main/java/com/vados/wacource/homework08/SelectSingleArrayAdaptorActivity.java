package com.vados.wacource.homework08;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class SelectSingleArrayAdaptorActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_list);
        listView = (ListView) findViewById(R.id.lvArraySelect);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

        final String[] catNames = new String[] { "Рыжик", "Барсик", "Мурзик" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, catNames);

        listView.setAdapter(adapter);

    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.button:
                int position =  listView.getCheckedItemPosition();
                Toast.makeText(this, "position="+position, Toast.LENGTH_SHORT).show();
                break;
        }


    }
}
