package jie.blog.source.currenttest;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Auther: wyj
 * @Date: 2019/8/19
 * @Description:自旋锁，存在aba问题
 */
public class MySpinLock {

    AtomicReference<Thread> atomicReference = new AtomicReference<>(null);

    public void lock() {
        System.out.println(Thread.currentThread().getName()+"开始获取自旋锁");
        while (!atomicReference.compareAndSet(null, Thread.currentThread())) {

        }
        System.out.println(Thread.currentThread().getName()+"获取自旋锁成功");
    }

    public void unLock() {
        System.out.println(Thread.currentThread().getName()+"开始解锁");
        atomicReference.compareAndSet(Thread.currentThread(), null);
        System.out.println(Thread.currentThread().getName()+"解锁成功");

    }
    public static void main(String[] args){

        MySpinLock mySpinLock = new MySpinLock();
        new Thread(()->{
            mySpinLock.lock();
            System.out.println(Thread.currentThread().getName()+"执行逻辑");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mySpinLock.unLock();
        },"t1").start();

        new Thread(()->{
            mySpinLock.lock();
            System.out.println(Thread.currentThread().getName()+"执行逻辑");
            mySpinLock.unLock();
        },"t2").start();

    }

}