package com.ctrl.jetpacktest.dagger2;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.io.IOException;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Module
class TestRepository {

    private final WebService webservice;

    @Inject
    public TestRepository(WebService webservice) {
        this.webservice = webservice;
    }

    @Provides
    public LiveData<String> getTestData() {


        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();

        Log.d("DOAING1---webService", webservice.toString());

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


            }
        });

        return mutableLiveData;

    }

}
