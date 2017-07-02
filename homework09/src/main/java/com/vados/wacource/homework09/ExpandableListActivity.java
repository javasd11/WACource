package com.vados.wacource.homework09;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExpandableListActivity extends AppCompatActivity {
    public static final String KEY_GROUP = "group";
    public static final String KEY_CHILD = "child name";

    private ExpandableListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list);
        listView  = (ExpandableListView) findViewById(R.id.expListView);
        ArrayList<Map<String, String>> groups = new ArrayList<>();

        HashMap<String, String> group = new HashMap<>();
        group.put(KEY_GROUP, "1");
        groups.add(group);

        group = new HashMap<>();
        group.put(KEY_GROUP, "2");
        groups.add(group);

        ArrayList<ArrayList<Map<String, String>>> childs = new ArrayList<>();

        ArrayList<Map<String, String>> child = new ArrayList<>();

        HashMap<String, String> childItem = new HashMap<>();
        childItem.put(KEY_CHILD, "Ivan");
        child.add(childItem);

        childItem = new HashMap<>();
        childItem.put(KEY_CHILD, "Petro");
        child.add(childItem);

        childs.add(child);

        child = new ArrayList<>();

        childItem = new HashMap<>();
        childItem.put(KEY_CHILD, "Alex");
        child.add(childItem);

        childItem = new HashMap<>();
        childItem.put(KEY_CHILD, "Ann");
        child.add(childItem);

        childs.add(child);

        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this,
                groups,
                android.R.layout.simple_expandable_list_item_1,
                new String[]{KEY_GROUP},
                new int[]{android.R.id.text1},
                childs,
                android.R.layout.simple_list_item_1,
                new String[]{KEY_CHILD},
                new int[]{android.R.id.text1});

        listView.setAdapter(adapter);
    }
}
