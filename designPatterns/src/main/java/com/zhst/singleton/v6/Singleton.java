package com.zhst.singleton.v6;

import java.io.PipedReader;

/**
 * 内部类实现，写法最完美的单例
 */
public class Singleton {

    private Singleton() {

    }

    private static class SingletonChildren {
        private static final Singleton INTSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonChildren.INTSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton.getInstance().hashCode());
            }).start();

        }
    }

}
