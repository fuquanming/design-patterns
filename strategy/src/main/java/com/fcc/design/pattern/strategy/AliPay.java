package com.fcc.design.pattern.strategy;

/**
 * @author 傅泉明
 * @title: AliPay
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/19 17:41
 */
public class AliPay implements Pay {
    @Override
    public double pay(double money) {
        System.out.println("AliPay...");
        return money + 0.5;
    }
}
