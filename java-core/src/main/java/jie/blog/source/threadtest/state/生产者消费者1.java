package jie.blog.source.threadtest.state;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: wyj
 * @Date: 2019/8/5
 * @Description:
 */
public class 生产者消费者1 {
    public static void main(String[] args) {
        MyQueue<Goods> myQueue = new MyQueue<Goods>(1);
        Thread thread0 = new Thread(new Producer(myQueue), "线程0");
//        Thread thread1 = new Thread(new Producer(myQueue), "线程1");
        Thread thread2 = new Thread(new Consumer(myQueue),"线程2");
        Thread thread3 = new Thread(new Consumer(myQueue),"线程3");
        Thread thread4 = new Thread(new Consumer(myQueue),"线程4");
//        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread0.start();
    }
}
    //货物类
    class Goods {
        //编号
        private int code;
        //名称
        private String name;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Goods{" +
                    "code=" + code +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    //装货队列，使用linklist实现
     class MyQueue<T> {
        /**
         *默认大小
         */
        final int DEFAULT_SIZE = 10;
        Object lock = new Object();
        /**
         *实际大小
         */

        int realSize;
        LinkedList<T> linkedList = new LinkedList<>();

        public MyQueue(int realSize) {
            this.realSize = realSize <= 0 ? DEFAULT_SIZE : realSize;
        }

        public synchronized void put(T t) throws InterruptedException {

                if (linkedList.size() >= realSize) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                linkedList.add(t);
                Thread.sleep(100);
                System.out.println("生产者："+Thread.currentThread().getName()+t.toString());
                lock.notifyAll();
            }



        public synchronized void get() {
                if (linkedList.size() <= 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                T t = linkedList.pollFirst();
                System.out.println("消费者：" + Thread.currentThread().getName() + t.toString());
                lock.notifyAll();//消费完一个可以唤醒生产者继续生产
        }


    }

     class Producer implements Runnable{

        MyQueue myQueue;

        public Producer(MyQueue myQueue) {
            this.myQueue = myQueue;
        }

        @Override
        public void run() {

            AtomicInteger atomicInteger = new AtomicInteger(0);
            while (true) {
                Goods goods = new Goods();
                goods.setCode(atomicInteger.incrementAndGet());
                goods.setName("商品" + atomicInteger.get());
                try {
                    myQueue.put(goods);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable{

        MyQueue myQueue;

        public Consumer(MyQueue myQueue) {
            this.myQueue = myQueue;
        }

        @Override
        public void run() {
            while (true) {
                myQueue.get();
            }
        }
    }
