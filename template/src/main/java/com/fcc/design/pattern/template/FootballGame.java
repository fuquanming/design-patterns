package com.fcc.design.pattern.template;

/**
 * @author 傅泉明
 * @title: FootballGame
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/20 10:03
 */
public class FootballGame extends Game {
    @Override
    void init() {
        System.out.println("football init...");
    }

    @Override
    void startPlay() {
        System.out.println("football startPlay...");
    }

    @Override
    void endPlay() {
        System.out.println("football endPlay...");
    }
}
