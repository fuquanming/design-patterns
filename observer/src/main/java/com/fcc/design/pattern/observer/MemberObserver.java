package com.fcc.design.pattern.observer;

/**
 * @author 傅泉明
 * @title: MemberObserver
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/20 11:56
 */
public class MemberObserver extends Observer {
    @Override
    void update(Subject subject, Object obj) {
        System.out.println("MemberObserver，收到：" + subject.getName() + "的通知：" + obj);
    }
}
