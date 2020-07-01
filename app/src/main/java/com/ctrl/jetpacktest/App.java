package com.ctrl.jetpacktest;

import android.app.Application;

import com.ctrl.jetpacktest.dagger2.BaseComponent;
import com.ctrl.jetpacktest.dagger2.DaggerBaseComponent;


public class App extends Application {
    private BaseComponent baseComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        baseComponent = DaggerBaseComponent.create();

    }
    public BaseComponent getBaseComponent() {
        return baseComponent;
    }
}
