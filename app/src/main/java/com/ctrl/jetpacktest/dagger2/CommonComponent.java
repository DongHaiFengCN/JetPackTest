package com.ctrl.jetpacktest.dagger2;

import dagger.Component;

/**
 * 业务组件，依赖于顶级的网络
 */
@BaseScope
@Component(modules = {TestRepository.class},dependencies = BaseComponent.class)
interface CommonComponent {
    void inject(MainActivity mainActivity);
}
