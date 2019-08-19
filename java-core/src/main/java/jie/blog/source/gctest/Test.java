package jie.blog.source.gctest;

import jdk.internal.org.objectweb.asm.Handle;

import java.util.HashMap;

/**
 * @Auther: wyj
 * @Date: 2019/8/7
 * @Description:
 */
public class Test {

    public static void main(String[] args){

      /*  new Thread(()->{
            while (true) {
                System.out.println("test");
            }
        },"线程一").start();*/
        HashMap map = new HashMap();
        int i=0;

        new Thread(()->{
            while (true) {
//                System.out.println("哈哈");
//                Object object = new Object();
                ClassLoader classLoader  = new ClassLoader() {
                    @Override
                    public Class<?> loadClass(String name) throws ClassNotFoundException {
                        return super.loadClass(name);
                    }
                };
                map.put(i, classLoader);
                //                    Thread.sleep(100);
            }

        }).start();
    }
}