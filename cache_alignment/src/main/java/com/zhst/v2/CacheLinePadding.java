package com.zhst.v2;

/**
 * @ClassName CacheLinePadding
 * @Description 测试缓存行对齐
 * @Author cyj
 * @Date 2020/10/11
 */
public class CacheLinePadding {

    /**
     * 定义一个长度为2的long型数组，一个long型是8个字节，这个数据的最大长度就是16个字节
     */
    private static volatile long[] longArr = new long[16];

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(()->{
            for (long i = 0; i < 100000000L; i++) {
                longArr[0] = i;
            }
        });
        Thread t2 = new Thread(()->{
            for (long i = 0; i < 100000000L; i++) {
                longArr[8] = i;
            }
        });
        final long start = System.nanoTime();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println((System.nanoTime() - start)/1000000);
    }

}
