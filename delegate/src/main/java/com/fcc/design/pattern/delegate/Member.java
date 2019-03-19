package com.fcc.design.pattern.delegate;

/**
 * @author 傅泉明
 * @title: Member
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/19 17:07
 */
public class Member implements Task {
    @Override
    public void doTask() {
        System.out.println("Member is doTask...");
    }
}
