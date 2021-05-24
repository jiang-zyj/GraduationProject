package com.zyj.DI;

/**
 * @ClassName Book
 * @Auther: YaJun
 * @Date: 2021 - 03 - 16 - 17:05
 * @Description: com.zyj.DI
 * @version: 1.0
 */
public class Book {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
