package com.fcc.design.pattern.factory.abastract;

/**
 * @author 傅泉明
 * @title: DellHost
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/18 17:26
 */
public class DellHost implements Host {
    @Override
    public void getName() {
        System.out.println("HostName is Dell...");
    }
}
