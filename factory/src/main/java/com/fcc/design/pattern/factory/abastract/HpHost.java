package com.fcc.design.pattern.factory.abastract;

/**
 * @author 傅泉明
 * @title: HpHost
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/18 17:27
 */
public class HpHost implements Host {
    @Override
    public void getName() {
        System.out.println("HostName is Hp...");
    }
}
