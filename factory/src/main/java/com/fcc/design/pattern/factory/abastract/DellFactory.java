package com.fcc.design.pattern.factory.abastract;

import com.fcc.design.pattern.factory.DellMouse;
import com.fcc.design.pattern.factory.Mouse;

/**
 * @author 傅泉明
 * @title: DellFactory
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/18 17:28
 */
public class DellFactory implements PcFactory {
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }

    @Override
    public Host createHost() {
        return new DellHost();
    }
}
