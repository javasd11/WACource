package com.vados.wacource.lec12;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.ArrayList;

/**
 * Created by vadim on 27.06.2017.
 */

public class StudentLoader extends AsyncTaskLoader<ArrayList<Student>> {
    Context context;

    public StudentLoader(Context context) {
        super(context);
        this.context = context;
    }

    public ArrayList<Student> loadInBackground() {
        return new DataBaseHelper(context).getStudents();
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

}
