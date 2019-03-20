package com.fcc.design.pattern.decorator;

/**
 * @author 傅泉明
 * @title: Milkshake
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/20 11:35
 */
public class Milkshake implements Food {
    private Food food;
    public Milkshake(Food food) {
        this.food = food;
    }
    @Override
    public String getName() {
        return food.getName() + "，add Milkshake";
    }

    @Override
    public double getPrice() {
        return food.getPrice() + 0.5;
    }
}
