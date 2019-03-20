package com.fcc.design.pattern.observer;

/**
 * @author 傅泉明
 * @title: News
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/20 11:52
 */
public class News extends Subject {
    @Override
    String getName() {
        return "新闻";
    }

    public static void main(String[] args) {
        Subject subject = new News();
        subject.addObserver(new UserObserver());
        subject.addObserver(new MemberObserver());

        subject.release("今天天气：晴");

    }
}
