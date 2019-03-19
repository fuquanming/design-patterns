package com.fcc.design.pattern.prototype;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 傅泉明
 * @title: PrototypeTest
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/19 15:21
 */
public class PrototypeTest {

    public static void main(String[] args) throws Exception {
        Book book = new Book();
        book.setName("原型模式");
        book.setCreateDate(new Date());
        book.setAuthor("张三");
        // 浅克隆
        Book book1 = (Book) book.clone();
        System.out.println(book == book1);
        System.out.println(book.getName() == book1.getName());
        System.out.println(book.getCreateDate() == book1.getCreateDate());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(book.getCreateDate()) + "," + format.format(book1.getCreateDate()));
        System.out.println("-------------------");
        // 深克隆
        SerializationBook b2 = new SerializationBook();
        b2.setName("原型模式");
        b2.setCreateDate(new Date());
        b2.setAuthor("张三");
        SerializationBook b3 = (SerializationBook) b2.clone();
        System.out.println(b2 == b3);
        System.out.println(b2.getCreateDate() == b3.getCreateDate());
        System.out.println(format.format(b2.getCreateDate()) + "," + format.format(b3.getCreateDate()));
    }

}
