package com.ctrl.jetpacktest.dagger2;

import android.util.Log;

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

    @Singleton
    @Provides
    public WebService providerWebService(OkHttpClient ok) {

       // Log.d("DOAING---ok", ok.toString());

        return new Retrofit.Builder()
                .baseUrl("http://124.128.249.98:8181/whby/")
                .client(ok)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(WebService.class);
    }

    @Singleton
    @Provides
    public HttpLoggingInterceptor providerHttpLoggingInterceptor() {
        HttpLoggingInterceptor logInterceptor
                = new HttpLoggingInterceptor(message -> Log.e("NetworkHandleLog", message));
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return logInterceptor;

    }

    @Singleton
    @Provides
    public OkHttpClient providerOkHttpClientBuilder(HttpLoggingInterceptor logInterceptor) {

       // Log.d("DOAING---logInterceptor",logInterceptor.toString());
        OkHttpClient.Builder ok = new OkHttpClient.Builder()
                .addNetworkInterceptor(logInterceptor)
                .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);
        return ok.build();

    }
}
