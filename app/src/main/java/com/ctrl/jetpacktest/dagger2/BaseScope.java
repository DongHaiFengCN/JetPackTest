package com.ctrl.jetpacktest.dagger2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Scope 标注是Scope
 * @Retention(RUNTIME) 运行时级别
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
@interface BaseScope {
}
