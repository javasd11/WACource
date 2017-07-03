package com.vados.wacource.homework09;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import com.vados.wacource.homework09.adapters.RecyclerStudentAdaptor;
import com.vados.wacource.homework09.models.Student;

import java.util.ArrayList;
import java.util.Random;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);


        students = new ArrayList<>();


        Random random = new Random();

        for (int i = 0; i < 1001; i++) {
            students.add(new Student("Ivan" + i, "Petrov" + i, 22 + i));
        }

        final RecyclerStudentAdaptor adaptor = new RecyclerStudentAdaptor(
                this,
                students,
                R.layout.child_item);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setAdapter(adaptor);

        adaptor.setOnClickListener(new RecyclerStudentAdaptor.OnClickListener() {
            @Override
            public void onClick(Student student) {
                Toast.makeText(getApplicationContext(), student.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        ItemTouchHelper.SimpleCallback itemTouchCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                final int fromPos = viewHolder.getAdapterPosition();
                final int toPos = target.getAdapterPosition();

                Student student = students.get(fromPos);
                students.remove(fromPos);
                students.add(toPos, student);

                adaptor.notifyItemMoved(fromPos, toPos);
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                final int fromPos = viewHolder.getAdapterPosition();
                students.remove(fromPos);
                adaptor.notifyItemRemoved(fromPos);
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}
