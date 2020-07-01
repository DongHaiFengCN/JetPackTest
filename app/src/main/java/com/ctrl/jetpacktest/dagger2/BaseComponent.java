package com.ctrl.jetpacktest.dagger2;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 顶级的依赖，主要让别的业务component来依赖的
 */
@Singleton
@Component(modules = NetWorkModule.class)
public
interface BaseComponent {
    WebService getWebService();
}
