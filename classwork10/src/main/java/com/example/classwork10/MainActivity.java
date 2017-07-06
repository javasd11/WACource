package com.example.classwork10;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.classwork10.model.Student;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        DatabaseHelper helper = new DatabaseHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        switch (view.getId()) {
            case R.id.btn1:
//                ContentValues values = new ContentValues();
//                values.put("FirstName","Ivan");
//                values.put("LastName","Ivanov");
//                values.put("Age",22);
//                long id = db.insert("Students", null,values);
//                Toast.makeText(this,String.valueOf(id),Toast.LENGTH_SHORT).show();
                long id = helper.insert(new Student("Teodor","Drizer",25));
                Toast.makeText(this,String.valueOf(id),Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn2:
                ContentValues values2 = new ContentValues();
                values2.put("FirstName","Petr");


                int count = db.update("Students",values2, "_id=1",null);
                Toast.makeText(this,String.valueOf(count),Toast.LENGTH_SHORT).show();

//                startActivity(new Intent(this, ));
                break;
            case R.id.btn3:
//                startActivity(new Intent(this, ));
                break;
            case R.id.btn4:
//                startActivity(new Intent(this, ));
                break;


        }
    }
}
