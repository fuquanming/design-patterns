package com.fcc.design.pattern.template;

/**
 * @author 傅泉明
 * @title: Game
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/20 10:01
 */
public abstract class Game {

    abstract void init();
    abstract void startPlay();
    abstract void endPlay();

    public final void play() {
        this.init();
        this.startPlay();
        this.endPlay();
    }

    public static void main(String[] args) {
        Game game = new FootballGame();
        game.play();

        game = new BasketballGame();
        game.play();
    }

}
