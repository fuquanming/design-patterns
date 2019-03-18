package com.fcc.design.pattern.factory.abastract;

import com.fcc.design.pattern.factory.Mouse;

/**
 * @author 傅泉明
 * @title: PcFactory
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/18 17:27
 */
public interface PcFactory {

    Mouse createMouse();

    Host createHost();

}
