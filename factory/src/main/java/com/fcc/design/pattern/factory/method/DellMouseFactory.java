package com.fcc.design.pattern.factory.method;

import com.fcc.design.pattern.factory.DellMouse;
import com.fcc.design.pattern.factory.Mouse;

/**
 * @author 傅泉明
 * @title: DellMouseFactory
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/18 17:15
 */
public class DellMouseFactory implements MouseFactory {
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }
}
