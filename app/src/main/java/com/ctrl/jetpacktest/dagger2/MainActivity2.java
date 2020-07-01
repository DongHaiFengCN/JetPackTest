package com.ctrl.jetpacktest.dagger2;

import androidx.appcompat.app.AppCompatActivity;

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
    WebService webService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
       // DaggerCommonComponent.builder().baseComponent((((App)getApplication()).getBaseComponent())).build().inject(this);

        Log.d("DOAING2---webService",webService.toString());
        webService.mainPage().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

              /*  try {
                    Log.e("DOAING",response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                };*/
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}