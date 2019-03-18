package com.fcc.design.pattern.factory.abastract;

/**
 * @author 傅泉明
 * @title: AbastractFactory
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/18 17:29
 */
public class AbastractFactory {

    public static void main(String[] args) {
        PcFactory pcFactory = new DellFactory();
        pcFactory.createMouse().onClick();
        pcFactory.createHost().getName();

        pcFactory = new HpFactory();
        pcFactory.createMouse().onClick();
        pcFactory.createHost().getName();
    }

}
