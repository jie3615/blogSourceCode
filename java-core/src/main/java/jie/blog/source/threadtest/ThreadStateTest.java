package jie.blog.source.threadtest;

import sun.misc.IOUtils;
import sun.nio.ch.IOUtil;

import java.util.Scanner;

import static java.lang.Thread.*;

/**
 * @Auther: wyj
 * @Date: 2019/8/1
 * @Description:
 */
public class ThreadStateTest {
    public static void main(String[] args){
           final Scanner inio = new Scanner(System.in);
            // 创建一个名为“输入输出”的线程t
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 命令行中的阻塞读
                        String input = inio.nextLine();
                        System.out.println(input);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        inio.close();
                    }
                }
            }, "输入输出"); // 线程的名字

            // 启动
            t.start();

            // 确保run已经得到执行
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 状态为RUNNABLE
            System.out.println(currentThread().getState());
        }
}