package com.fcc.design.pattern.decorator;

/**
 * @author 傅泉明
 * @title: Sugar
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/20 11:33
 */
public class Sugar implements Food {
    private Food food;
    public Sugar(Food food) {
        this.food = food;
    }

    @Override
    public String getName() {
        return food.getName() + "，add Sugar";
    }

    @Override
    public double getPrice() {
        return food.getPrice() + 1;
    }
}
