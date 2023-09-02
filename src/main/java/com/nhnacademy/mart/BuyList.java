package com.nhnacademy.mart;

import java.util.ArrayList;

/**
 * 이 클래스는 무엇을 살지 미리 정하는 클래스이다.
 * 이 클래스에서는 FoodStand에 없는 물품도 작성 가능하다.
 */
public class BuyList {

    private final ArrayList<Item> items = new ArrayList<>();

    // TODO add 메서드 생성
    public void add(Item item) {
        items.add(item);
    }

    /**
     * getItems클래스는 buylist애 있는 내용을 주는 메서드이다.
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    public int size() {
        return items.size();
    }

    /**
     * 물품의 이름과 수량을 적는 메사드이다.
     */
    public static class Item {
        private final String name;
        private final int amount;

        public Item(String name, int amount) {
            this.name = name;
            this.amount = amount;
        }

        public String getName() {
            return name;
        }

        public int getAmount() {
            return amount;
        }
    }
}
