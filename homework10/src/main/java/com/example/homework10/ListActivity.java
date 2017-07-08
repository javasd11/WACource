package com.example.homework10;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.homework10.data.DatabaseHelper;
import com.example.homework10.model.Student;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    public static final String EXTRA_STUDENT = "com.example.homework10.ListActivity.STUDENT";
    public static final String KEY_NAME ="name";
    public static final String KEY_LAST_NAME ="lastname";
    public static final String KEY_AGE ="age";
    private ListView listView;
    private DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = (ListView) findViewById(R.id.listView);
        helper = new DatabaseHelper(this);
        fillListView();
        registerForContextMenu(listView);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = new Student();

//                cursor.move(position);
//
//                student.id = cursor.getLong(cursor.getColumnIndex(Student.COLUMN_ID));
//                student.FirstName = cursor.getString(cursor.getColumnIndex(Student.COLUMN_FIRSTNAME));
//                student.LastName = cursor.getString(cursor.getColumnIndex(Student.COLUMN_LASTNAME));
//                student.Age = cursor.getLong(cursor.getColumnIndex(Student.COLUMN_AGE));

                student = helper.getStudent(id);
                Intent intent = new Intent(getApplicationContext(),ViewStudentActivity.class);
                intent.putExtra(EXTRA_STUDENT,student);
                intent.putExtra(MainActivity.EXTRA_EDIT,false);
                startActivity(intent);
            }
        });

    }

    private void fillListView(){
        SQLiteDatabase db = helper.getWritableDatabase();

        final Cursor cursor = db.query(Student.TABLE_NAME, null, null, null, null, null, null);

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                R.layout.student_item,
                cursor,
                new String[]{Student.COLUMN_FIRSTNAME, Student.COLUMN_LASTNAME, Student.COLUMN_AGE},
                new int[]{R.id.textFirstName, R.id.textLAstName, R.id.textAge});
        listView.setAdapter(adapter);

    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if(v.getId()==R.id.listView){
            menu.add(0,1,0,"Edit");
            menu.add(0,2,0,"Delete item");
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = listView.getSelectedItemPosition();

        Toast.makeText(this,String.valueOf(id),Toast.LENGTH_SHORT ).show();


        return super.onContextItemSelected(item);
    }
}
