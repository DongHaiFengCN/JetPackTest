package com.ctrl.jetpacktest.dagger2;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

public interface WebService {
    @GET("discover/mainPage")
    Call<ResponseBody> mainPage();
}
