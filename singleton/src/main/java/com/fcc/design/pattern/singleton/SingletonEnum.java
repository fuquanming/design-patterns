package com.fcc.design.pattern.singleton;

/**
 * @author 傅泉明
 * @title: 枚举单例
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/19 10:50
 */
public enum SingletonEnum {

    singleton;
    private Object data;
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public static SingletonEnum getInstance(){
        return singleton;
    }

}
