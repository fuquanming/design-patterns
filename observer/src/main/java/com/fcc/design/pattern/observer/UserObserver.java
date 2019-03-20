package com.fcc.design.pattern.observer;

/**
 * @author 傅泉明
 * @title: UserObserver
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/20 11:49
 */
public class UserObserver extends Observer {
    @Override
    void update(Subject subject, Object obj) {
        System.out.println("UserObserver，收到：" + subject.getName() + "的通知：" + obj);
    }
}
