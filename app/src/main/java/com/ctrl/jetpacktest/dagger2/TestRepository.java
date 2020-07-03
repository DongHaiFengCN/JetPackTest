package com.ctrl.jetpacktest.dagger2;

import android.util.Log;

import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


class TestRepository {


    public WebService webservice;

    //如果被标记了注入就会自动装填到仓库，不能手动写的@Component
    public TestRepository(WebService webservice) {
        this.webservice = webservice;
    }

    public LiveData<String> getTestData() {


        Log.d("DOAING", webservice.toString());


        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();

        webservice.mainPage().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


                try {
                    mutableLiveData.setValue(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                // event.setValue(t);

            }
        });

        return mutableLiveData;

    }

    public void setStrings(@Size(min = 1) String[] strings) {

        Log.d("DOAING",strings.length+"");


    }


    public void setAlpha(@IntRange(from = 0,to = 255) int i) {

        Log.d("DOAING",Thread.currentThread().toString());


    }
}
