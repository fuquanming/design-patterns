package com.fcc.design.pattern.factory.simple;

import com.fcc.design.pattern.factory.DellMouse;
import com.fcc.design.pattern.factory.HpMouse;
import com.fcc.design.pattern.factory.Mouse;

/**
 * @author 傅泉明
 * @title: SimpleFactory
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/18 17:00
 */
public class SimpleFactory {

    public static Mouse getMouse(Class<? extends Mouse> clazz) {
        if (clazz != null) {
            try {
                return clazz.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static <T> T getClass(Class<? extends T> clazz) {
        if (clazz != null) {
            try {
                return clazz.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Mouse dellMouse = SimpleFactory.getMouse(DellMouse.class);
        dellMouse.onClick();

        Mouse hpMouse = SimpleFactory.getMouse(HpMouse.class);
        hpMouse.onClick();

        Mouse dellMouse1 = SimpleFactory.getClass(DellMouse.class);
        dellMouse1.onClick();

        Mouse hpMouse1 = SimpleFactory.getClass(HpMouse.class);
        hpMouse1.onClick();

    }

}
