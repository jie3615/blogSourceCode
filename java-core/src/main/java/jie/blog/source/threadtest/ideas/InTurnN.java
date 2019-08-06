package jie.blog.source.threadtest.ideas;

/**
 * @Auther: wyj
 * @Date: 2019/8/6
 * @Description:实现两个线程交替执行N次
 */
public class InTurnN {
    /**
     * 线程1,2分别执行10次，使用wait/notify
     *
     * 这种方式实现比较low，不过也先留着吧，最初的想法，有漏洞，wait不加等待时间的话，最终两个线程中有一个总是在睡眠状态；
     * 程序无法正常结束，加了时间又无法保证等待期间对方能够执行完逻辑
      * @param args
     */
    public static void main(String[] args){

        //两个线程的通信桥梁
        Object waiter = new Object();
         new Thread(()->{
             //先所在waiter上
             synchronized (waiter) {
                 int j = 0;
                 while (j<5) {
                     j++;
                     for (int i = 0; i < 10; i++) {
                         try {
                             Thread.sleep(10);
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
                         System.out.println(Thread.currentThread().getName()+i);
                     }
                         try {
                             waiter.notify();
                             waiter.wait(1000);
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                     }
                 }

             }

         },"线程一").start();

        new Thread(()->{
            synchronized (waiter) {
                int j =0;
                while (j<5) {
                    j++;
                    for (int i = 0; i < 5; i++) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+i);
                    }
                        try {
                            waiter.notify();
                            waiter.wait(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                    }
                }

            }

        },"线程二").start();

    }

}