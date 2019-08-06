package jie.blog.source.threadtest.state;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: wyj
 * @Date: 2019/8/6
 * @Description:
 */
public class OneLockTwoMethod {
    Lock object = new ReentrantLock();

    public  void m1() {
        synchronized (object){
            System.out.println(Thread.currentThread().getName()+"方法一");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public  void m2() {
        synchronized (object){
            System.out.println(Thread.currentThread().getName()+"方法二");
        }

    }

    public void m3() {
        object.lock();
        System.out.println(Thread.currentThread().getName() + "线程三");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        object.unlock();

    }
    public void m4() {
        object.lock();
        System.out.println(Thread.currentThread().getName() + "线程四");
        object.unlock();

    }

   public static void main(String[] args){
       OneLockTwoMethod oneLockTwoMethod = new OneLockTwoMethod();

       new Thread(()->{
            oneLockTwoMethod.m1();
        },"线程一").start();

       new Thread(()->{
           oneLockTwoMethod.m2();
       },"线程二").start();

       new Thread(()->{
           oneLockTwoMethod.m3();
       },"线程三").start();
       new Thread(()->{
           oneLockTwoMethod.m4();
       },"线程四").start();

   }

}