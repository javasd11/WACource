package com.vados.wacource.lec12;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<Student>> {
    private SaveTask saveTask;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (ListView) findViewById(R.id.listview);

        getSupportLoaderManager().initLoader(0, null, this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (saveTask != null) {
            saveTask.cancel(true);
        }
    }

//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.button1:
//                saveTask = new SaveTask();
//                saveTask.execute(new Student("Ivan", "Ivanov", 35));
//                break;
//            case R.id.button2:
//                LoadTask loadTask = new LoadTask();
//                loadTask.execute(new Student("Ivan", "Ivanov", 35),new Student("Ivan", "Ivanov", 35),new Student("Ivan", "Ivanov", 35),new Student("Ivan", "Ivanov", 35));
//                break;
//            case R.id.button3:
//                break;
////            case R.id.button4:
////                break;
////            case R.id.button5:
////                break;
//            case R.id.button6:
//                break;
//            case R.id.button7:
//                break;
//            case R.id.button8:
//                break;
////            case R.id.button9:
////                break;
////            case R.id.button10:
////                break;
//
//        }
//
//
//    }

    @Override
    public Loader<ArrayList<Student>> onCreateLoader(int id, Bundle args) {
        return new StudentLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<Student>> loader, ArrayList<Student> data) {
        ArrayAdapter<Student> adapter = new ArrayAdapter<Student>(this, android.R.layout.simple_list_item_1, android.R.id.text1);
        listview.setAdapter(adapter);
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<Student>> loader) {

    }


    public class SaveTask extends AsyncTask<Student, Void, Long> {
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Wait...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected Long doInBackground(Student... params) {
            DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);
            Student student = params[0];

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            if(!isCancelled()){

//            }

            return dataBaseHelper.insertStudent(student);
        }

        @Override
        protected void onPostExecute(Long aLong) {
            super.onPostExecute(aLong);
//            Button btn = (Button) findViewById(R.id.button1);
//            btn.setText(String.valueOf(aLong));
            Toast.makeText(MainActivity.this, String.valueOf(aLong), Toast.LENGTH_LONG).show();

            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        }
    }

    public class LoadTask extends AsyncTask<Student, Integer, Integer> {
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Wait...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected Integer doInBackground(Student... params) {
            DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);

            int count = 0;

            for (Student s : params) {
                if (!isCancelled()) {
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    dataBaseHelper.insertStudent(s);
                    count++;
                    publishProgress(count, params.length);
                }
            }
            return params.length;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressDialog.setMessage(String.format("Saved %s students from %s", values[0], values[1]));
        }

        @Override
        protected void onPostExecute(Integer aLong) {
            super.onPostExecute(aLong);

//            Button btn = (Button) findViewById(R.id.button1);
//            btn.setText(String.valueOf(aLong));
//            Toast.makeText(MainActivity.this, String.valueOf(aLong), Toast.LENGTH_LONG).show();

            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        }
    }
}
