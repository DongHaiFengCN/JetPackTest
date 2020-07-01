package com.ctrl.jetpacktest.dagger2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.ctrl.jetpacktest.App;
import com.ctrl.jetpacktest.R;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Inject
    TestRepository testRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        DaggerCommonComponent.builder()
                .baseComponent((((App) getApplication()).getBaseComponent()))
                .build()
                .inject(this);


        testRepository.getTestData().observe(this, s -> Log.d("DOAING---A", s));


    }
/*
    @Inject
    public void getTestRepository(TestRepository testRepository) {
        this.testRepository = testRepository;
    }*/
}