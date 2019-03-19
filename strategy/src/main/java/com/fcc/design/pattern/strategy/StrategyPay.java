package com.fcc.design.pattern.strategy;

/**
 * @author 傅泉明
 * @title: StrategyPay
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/19 17:42
 */
public class StrategyPay {

    private Pay pay;

    public void pay(double money) {
        System.out.println("支付金额：" + pay.pay(money));
    }

    public Pay getPay() {
        return pay;
    }

    public void setPay(Pay pay) {
        this.pay = pay;
    }

    public static void main(String[] args) {
        StrategyPay strategyPay = new StrategyPay();
        strategyPay.setPay(new WeCharPay());
        strategyPay.pay(1);

        strategyPay.setPay(new AliPay());
        strategyPay.pay(1);

    }
}
