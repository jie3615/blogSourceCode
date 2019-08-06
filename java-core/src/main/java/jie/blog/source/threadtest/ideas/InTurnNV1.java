package jie.blog.source.threadtest.ideas;

/**
 * @Auther: wyj
 * @Date: 2019/8/6
 * @Description:实现两个交替打印奇数偶数的线程
 */
public class InTurnNV1 {

    public static void main(String[] args) {


        //先各自干自己的，再加入通信机制
        // 加锁

        Object object  = new Object();
        Runnable runnable1 = new Runnable() {
            @Override
            public  void run() {
                synchronized(object){
                    for (int i = 0; i < 100; i=i+2) {
                        System.out.println(Thread.currentThread().getName()+i);
                        object.notify();
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public  void run() {
                synchronized(object){
                    for (int i = 1; i < 100; i=i+2) {
                        System.out.println(Thread.currentThread().getName()+i);
                        object.notify();
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        };


        new Thread(runnable1,"线程一偶数").start();
        new Thread(runnable2,"线程二奇数").start();

    }

}