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
    WebService webService1;

    @Inject
    WebService webService2;

    @Inject
    TestRepository testRepository1;
    @Inject
    TestRepository testRepository2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        DaggerTestComponent.builder()
                .baseComponent(((App) getApplication()).getBaseComponent())
                .build()
                .inject(this);
     /*   Log.d("DOAING_1", testRepository1.toString());
        Log.d("DOAING_1", testRepository2.toString());*/
        //全局的存储区与当前组件做关联
        //((App) getApplication()).getBaseComponent().inject(this);
        testRepository1.setAlpha(1);

    /*    testRepository1.setStrings(null);
        // Log.d("DOAING", testRepository1.toString());
        testRepository1.getTestData().observe(this, s -> Log.d("DOAING---A", s));
        testRepository2.getTestData().observe(this, s -> Log.d("DOAING---A", s));
        startActivity(new Intent(MainActivity.this,MainActivity2.class));
*/
    }
/*
    @Inject
    public void getTestRepository(TestRepository testRepository) {
        this.testRepository = testRepository;
    }*/
}