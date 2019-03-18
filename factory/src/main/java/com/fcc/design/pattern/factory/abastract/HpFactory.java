package com.fcc.design.pattern.factory.abastract;

import com.fcc.design.pattern.factory.HpMouse;
import com.fcc.design.pattern.factory.Mouse;

/**
 * @author 傅泉明
 * @title: HpFactory
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/18 17:28
 */
public class HpFactory implements PcFactory {
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }

    @Override
    public Host createHost() {
        return new HpHost();
    }
}
