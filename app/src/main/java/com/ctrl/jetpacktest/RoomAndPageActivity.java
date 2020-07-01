package com.ctrl.jetpacktest;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RoomAndPageActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    LiveData<PagedList<Student>> liveData;

    private MyPageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        pageAdapter = new MyPageAdapter();
        recyclerView = findViewById(R.id.content_Rcy);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(pageAdapter);

        StudentDataBase studentDataBase = StudentDataBase.getInstance(getApplicationContext());
        final StudentDao studentDao = studentDataBase.getStudentDao();
        liveData = new LivePagedListBuilder<>(studentDao.getAllStudents(), 20).build();

        liveData.observe(this, new Observer<PagedList<Student>>() {
            @Override
            public void onChanged(PagedList<Student> students) {
                pageAdapter.submitList(students);
            }
        });


        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        Student[] students = new Student[1000];
                        for (int i = 0; i < 1000; i++) {
                            Student student = new Student();
                            student.setStudentNumber(i);
                            students[i] = student;

                        }

                        studentDao.insertStudents(students);


                    }
                }).start();

            }
        });

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        studentDao.deleteAllStudents();
                    }
                }).start();

            }
        });

    }
}