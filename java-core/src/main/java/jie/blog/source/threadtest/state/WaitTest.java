package jie.blog.source.threadtest.state;


import org.junit.jupiter.api.Test;

/**
 * @Auther: wyj
 * @Date: 2019/8/2
 * @Description:
 */
public class WaitTest {
//    Object object = new Object();


  /*  @Test
    void testWaitting() {
        System.out.println("test");
        Thread t1 = new Thread(task, "线程1");
        Thread t2 = new Thread(task, "线程2");
        t1.start();
        t2.start();
    }*/

    public synchronized  void testSyn(){
    }

  static synchronized   void doSomeThing() {
      System.out.println(Thread.currentThread().getName()+"做一些事情。。。");
      try {
          Thread.sleep(60*1000*30);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
      System.out.println("睡眠结束");
  }
    public static void main(String[] args){
        Runnable task = new Runnable() {
            @Override
            public void run() {

                doSomeThing();
            }
        };


        System.out.println("test");
        Thread t1 = new Thread(task, "线程1");
        Thread t2 = new Thread(task, "线程2");
        t1.start();
        t2.start();
    }
    /** 线程状态
     * "线程2" #14 prio=5 os_prio=0 tid=0x000000001d919800 nid=0x8584 waiting for monitor entry [0x000000001e75f000]
     java.lang.Thread.State: BLOCKED (on object monitor)
     at jie.blog.source.threadtest.state.WaitTest.doSomeThing(WaitTest.java:24)
     - waiting to lock <0x000000076b00a4e8> (a java.lang.Class for jie.blog.source.threadtest.state.WaitTest)
     at jie.blog.source.threadtest.state.WaitTest$1.run(WaitTest.java:37)
     at java.lang.Thread.run(Thread.java:748)

     "线程1" #13 prio=5 os_prio=0 tid=0x000000001d919000 nid=0x3f2c waiting on condition [0x000000001e65f000]
     java.lang.Thread.State: TIMED_WAITING (sleeping)
     at java.lang.Thread.sleep(Native Method)
     at jie.blog.source.threadtest.state.WaitTest.doSomeThing(WaitTest.java:26)
     - locked <0x000000076b00a4e8> (a java.lang.Class for jie.blog.source.threadtest.state.WaitTest)
     at jie.blog.source.threadtest.state.WaitTest$1.run(WaitTest.java:37)
     at java.lang.Thread.run(Thread.java:748)
     */
}