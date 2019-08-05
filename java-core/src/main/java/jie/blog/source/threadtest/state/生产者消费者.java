package jie.blog.source.threadtest.state;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Auther: wyj
 * @Date: 2019/8/2
 * @Description:
 */
public class 生产者消费者 {

    static class Producer implements Runnable {
        LinkedBlockingQueue<Integer> linkedBlockingQueue ;

        public Producer(LinkedBlockingQueue<Integer> linkedBlockingQueue) {
            this.linkedBlockingQueue = linkedBlockingQueue;
        }
        @Override
        public void run() {
            int i=0;
            try {
                while (true) {
                    linkedBlockingQueue.put(++i);
//                    Thread.sleep(100);
                    System.out.println("生产者线程"+Thread.currentThread().getName()+"#####"+i);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    static class Consumer implements Runnable{
        LinkedBlockingQueue<Integer> linkedBlockingQueue ;
        public Consumer(LinkedBlockingQueue<Integer> linkedBlockingQueue) {
            this.linkedBlockingQueue = linkedBlockingQueue;
        }
        @Override
        public void run() {
            int i = 0;
            while (true) {

                try {

                    i = linkedBlockingQueue.take().intValue();
//                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费者线程"+Thread.currentThread().getName()+"#####"+i);
            }

        }
    }

    public static void main(String[] args){
       LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>(10);
        Producer producer = new Producer(linkedBlockingQueue);
        Consumer consumer = new Consumer(linkedBlockingQueue);
        Thread t1 = new Thread(producer, "1");
        Thread t2 = new Thread(consumer, "2");
        t1.start();
        t2.start();
    }

}