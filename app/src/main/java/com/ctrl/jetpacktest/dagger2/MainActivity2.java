package com.ctrl.jetpacktest.dagger2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;

import com.ctrl.jetpacktest.App;
import com.ctrl.jetpacktest.R;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {
    @Inject
    TestRepository testRepository1;
    @Inject
    TestRepository testRepository2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
       // ((App) getApplication()).getBaseComponent().inject(this);

        DaggerTestComponent.builder()
                .baseComponent(((App) getApplication()).getBaseComponent())
                .build()
                .inject(this);

        Log.d("DOAING_2", testRepository1.toString());
        Log.d("DOAING_2", testRepository2.toString());

        testRepository1.getTestData().observe(this, s -> Log.d("DOAING---A", s));
        testRepository2.getTestData().observe(this, s -> Log.d("DOAING---A", s));

       // DaggerCommonComponent.builder().baseComponent((((App)getApplication()).getBaseComponent())).build().inject(this);
/*

        testRepository2.getTestData().observe(this, s -> {

        });
*/

    }
}