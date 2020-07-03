package com.ctrl.jetpacktest.dagger2;

import androidx.annotation.Size;

import dagger.Module;
import dagger.Provides;

@Module
class TestModule {




    //提供对象的也要加上BaseScope，不然报错。
    @Provides
    @BaseScope
    public TestRepository get(WebService webService) {
        return new TestRepository(webService);
    }

}
