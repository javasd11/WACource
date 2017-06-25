package com.vados.wacource.homework6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.vados.wacource.homework6.domain.Student;

public class ViewActivity extends AppCompatActivity {

private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_);

        textView = (TextView) findViewById(R.id.multiAutoCompleteTextView);
        setContent();
    }



    public void onClickView(View view){
        finish();
    }

    private void setContent(){
        Student st = getIntent().getParcelableExtra(MainActivity.EXTRA_STUDENT);
        textView.setText(st.toString());

    }
}
