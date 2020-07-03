package com.ctrl.jetpacktest.dagger2;


import javax.inject.Singleton;

import dagger.Component;

/**
 * 顶级的依赖，主要让别的业务component来依赖的,module里用的Singleton，这里也要标记。
 */
@Singleton
@Component(modules = {NetWorkModule.class})
public
interface BaseComponent {

    //声明一下需要对外提供的对象，这里是网络例子
    WebService providerWebService();
}
