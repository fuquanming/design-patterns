package com.fcc.design.pattern.strategy;

/**
 * @author 傅泉明
 * @title: WeCharPay
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/19 17:41
 */
public class WeCharPay implements Pay {
    @Override
    public double pay(double money) {
        System.out.println("WeCharPay...");
        return money + 1.0;
    }
}
