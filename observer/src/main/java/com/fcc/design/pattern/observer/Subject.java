package com.fcc.design.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 傅泉明
 * @title: 主题
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/20 11:44
 */
public abstract class Subject {

    private List<Observer> observers = new ArrayList<Observer>();
    private String msg;
    abstract String getName();

    public final void addObserver(Observer observer) {
        observers.add(observer);
    }

    public final void release(String msg) {
        this.msg = msg;
        notifyObservers();
    }

    public final void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this, msg);
        }
    }

}
