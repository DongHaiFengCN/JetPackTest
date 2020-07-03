package com.ctrl.jetpacktest.dagger2;

import dagger.Component;

//自定义的BaseScope 基础依赖是单例不写会报错，被BaseScope标记的在作用域内都是单例
@BaseScope
@Component(modules = {TestModule.class}, dependencies = BaseComponent.class)
interface TestComponent {
    void inject(MainActivity mainActivity);
    void inject(MainActivity2 mainActivity);

}
