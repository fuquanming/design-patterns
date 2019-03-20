package com.fcc.design.pattern.template;

/**
 * @author 傅泉明
 * @title: BasketballGame
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/20 10:04
 */
public class BasketballGame extends Game {
    @Override
    void init() {
        System.out.println("basketball init...");
    }

    @Override
    void startPlay() {
        System.out.println("basketball startPlay...");
    }

    @Override
    void endPlay() {
        System.out.println("basketball endPlay...");
    }
}
