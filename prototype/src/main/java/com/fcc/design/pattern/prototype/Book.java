package com.fcc.design.pattern.prototype;

import java.util.Date;

/**
 * @author 傅泉明
 * @title: Book
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/19 14:58
 */
public class Book {
    private String name;
    private String author;
    private Date createDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    // 浅克隆，原对象中的引用类型地址值是一样的
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Book book = new Book();
        book.setAuthor(this.author);
        book.setCreateDate(this.createDate);
        book.setName(this.name);
        return book;
    }
}
