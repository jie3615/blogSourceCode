package jie.blog.source.currenttest;

/**
 * @Auther: wyj
 * @Date: 2019/8/19
 * @Description:可见性
 */
public class SeeOkTest {
    int state = 0;

    public static void main(String[] args){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end-start));
    }
}