package com.fcc.design.pattern.factory.method;

import com.fcc.design.pattern.factory.HpMouse;
import com.fcc.design.pattern.factory.Mouse;

/**
 * @author 傅泉明
 * @title: HpMouseFactory
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/18 17:16
 */
public class HpMouseFactory implements MouseFactory {
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }
}
