package com.fcc.design.pattern.observer;

/**
 * @author 傅泉明
 * @title: 观察者
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/20 11:44
 */
public abstract class Observer {

    protected Subject subject;
    abstract void update(Subject subject, Object obj);

}
