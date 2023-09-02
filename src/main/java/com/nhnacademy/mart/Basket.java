package com.nhnacademy.mart;

import java.util.ArrayList;

/**
 * 이 클래스는 FoodStand에서 가져온 것을 추가하는 클래스이다. -> 장바구니 or 카트
 */
public class Basket {
    private final ArrayList<Food> foods = new ArrayList<>();

    public void add(Food food) {
        foods.add(food);
    }

    public ArrayList<Food> getItem() {
        return foods;
    }
}
