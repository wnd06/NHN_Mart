package com.nhnacademy.mart;

/**
 * Food의 객체를 만들어주는 클래스이다.
 */
public class Food {

    private final String name;
    private final int price;


    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Food(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
