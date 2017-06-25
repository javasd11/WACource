package com.vados.wacource.homework6;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.vados.wacource.homework6.domain.Student;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_STUDENT = "com.vados.student.devcolibriapp.STUDENT";
    public static final int ACTIVITY_EDIT_STUDENT = 1;
    public static final int ACTIVITY_EDIT_STUDENT_AGE = 2;

    private Student student;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.ma_textView_student_name);

        student = createStartContent();
        textView.setText(student.toString());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode != RESULT_OK) {
            return;
        }
        student = data.getParcelableExtra(EXTRA_STUDENT);

        if (requestCode == this.ACTIVITY_EDIT_STUDENT) {
            textView.setText(student.toString());
            Toast.makeText(this, "student was changed", Toast.LENGTH_LONG).show();
        }
        if (requestCode == ACTIVITY_EDIT_STUDENT_AGE) {
            textView.setText(student.toString());
            Toast.makeText(this, "age changed", Toast.LENGTH_LONG).show();
        }
    }

    private Student createStartContent() {
        return new Student("Иван", "Петров", 50);
    }

    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.ma_button_view:
            case R.id.ma_textView_student_name:
                viewStudent();
                break;
            case R.id.ma_button_edit:
                editSudent();
                break;
            case R.id.ma_button_edit_age:
                editAge();
                break;
            case R.id.btnWeb:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://developer.android.com"));
                startActivity(intent);
                break;
            case R.id.btnMap:
                intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:55.754283,37.62002"));
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
                break;
            case R.id.btnCall:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:12345"));
                startActivity(intent);
                break;

        }
    }

    private void viewStudent() {
        Intent intent = new Intent(this, ViewActivity.class);
        intent.putExtra(EXTRA_STUDENT, student);
        startActivity(intent);
    }

    private void editSudent() {
        Intent intent = new Intent(this, EditActivity.class);
        intent.putExtra(EXTRA_STUDENT, student);
        startActivityForResult(intent, ACTIVITY_EDIT_STUDENT);
    }

    private void editAge() {
        Intent intent = new Intent(this, EditAgeActivity.class);
        intent.putExtra(EXTRA_STUDENT, student);
        startActivityForResult(intent, ACTIVITY_EDIT_STUDENT_AGE);
    }


}
