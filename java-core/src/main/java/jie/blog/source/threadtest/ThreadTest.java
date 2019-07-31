package jie.blog.source.threadtest;

/**
 * @Auther: wyj
 * @Date: 2019/7/30
 * @Description:
 */
public class ThreadTest {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            public void run() {
                System.out.println("runnable -> " + Thread.currentThread().getName());
            }
        }) {
            public void run() {
                System.out.println("thread -> " + Thread.currentThread().getName());
            }
        }.start();
    }
}