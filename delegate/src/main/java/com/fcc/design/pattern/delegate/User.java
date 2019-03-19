package com.fcc.design.pattern.delegate;

/**
 * @author 傅泉明
 * @title: User
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/19 17:07
 */
public class User implements Task {
    @Override
    public void doTask() {
        System.out.println("User is doTask...");
    }
}
