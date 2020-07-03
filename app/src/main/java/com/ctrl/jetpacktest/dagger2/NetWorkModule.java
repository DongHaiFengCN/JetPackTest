package com.ctrl.jetpacktest.dagger2;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
class NetWorkModule {

    // 默认超时时间 单位/秒
    private static final int DEFAULT_TIME_OUT = 10;

    //这个方法只会被执行一次
    @Provides
    @Singleton
    public WebService providerWebService() {
        HttpLoggingInterceptor logInterceptor
                = new HttpLoggingInterceptor(message -> Log.e("NetworkHandleLog", message));
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder ok = new OkHttpClient.Builder()
                .addNetworkInterceptor(logInterceptor)
                .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);

        return new Retrofit.Builder()
                .baseUrl("http://124.128.249.98:8181/whby/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(ok.build())
                .build()
                .create(WebService.class);
    }

}
