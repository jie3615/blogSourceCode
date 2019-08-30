package jie.blog.source.springcore.bean;

/**
 * @author: wyj
 * @date: 2019/8/30
 * @description:
 */
public class Car {
    private String name;
    private int price;

    public Car() {
        System.out.println("car 的构造器");
    }

    public void init() {
        System.out.println("car 初始化");
    }

    public void destory() {
        System.out.println("car 销毁");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}