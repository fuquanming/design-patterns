package com.fcc.design.pattern.decorator;

/**
 * @author 傅泉明
 * @title: MochaCoffee
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/20 11:30
 */
public class MochaCoffee implements Coffee {
    @Override
    public String getName() {
        return "MochaCoffee";
    }

    @Override
    public double getPrice() {
        return 10;
    }

    public static void main(String[] args) {
        Coffee coffee = new MochaCoffee();

        Food sugar = new Sugar(coffee);
        Food sugar1 = new Sugar(sugar);

        Food milkshake = new Milkshake(sugar1);

        System.out.println(milkshake.getName());
        System.out.println(milkshake.getPrice());
    }
}
