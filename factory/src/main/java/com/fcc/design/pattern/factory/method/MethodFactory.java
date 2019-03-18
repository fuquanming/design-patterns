package com.fcc.design.pattern.factory.method;

/**
 * @author 傅泉明
 * @title: MethodFactory
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/18 17:17
 */
public class MethodFactory {

    public static void main(String[] args) {
        MouseFactory mf = new DellMouseFactory();
        mf.createMouse().onClick();

        mf = new HpMouseFactory();
        mf.createMouse().onClick();
    }

}
