package com.example.homework10;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.homework10.data.DatabaseHelper;
import com.example.homework10.model.Student;

public class ListActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = (ListView) findViewById(R.id.listView);

        DatabaseHelper helper = new DatabaseHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor= db.query(Student.TABLE_NAME,null,null,null,null,null,null);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_2,
                cursor,
                new String[]{Student.COLUMN_FIRSTNAME,Student.COLUMN_LASTNAME},
                new int[]{android.R.id.text1,android.R.id.text2});
        listView.setAdapter(adapter);
    }
}
