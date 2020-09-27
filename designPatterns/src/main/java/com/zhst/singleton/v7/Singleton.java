package com.zhst.singleton.v7;

/**
 * 最佳写法，枚举
 */
public enum Singleton {
    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton.INSTANCE.hashCode());
            }).start();
        }
    }
}
