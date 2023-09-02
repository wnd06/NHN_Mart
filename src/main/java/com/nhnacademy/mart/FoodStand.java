package com.nhnacademy.mart;

import java.util.ArrayList;
import java.util.Iterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FoodStand는 물품 진열대이다.
 * 여기서 물품을 고르고 가져갈 수 있고 뺄 수 도 있다.
 */
public class FoodStand {
    private final Logger logger = LoggerFactory.getLogger(FoodStand.class);

    private final ArrayList<Food> foods = new ArrayList<>();

    private String name;


    public FoodStand() {
    }

    // TODO add 메서드 구현
    public void add(Food food) {
        foods.add(food);
    }

    // TODO 장바구니에 담은 Food 삭제 구현

    /**
     * 이 메서드에서는 Food타입으로 반환하며 메서드를 사용하면 foods리스트의 있는 값이 빠진다.
     */
    public Food delete(String foodToRemove) {

        Iterator<Food> iterator = foods.iterator();
        int listNum = 0;

        while (iterator.hasNext()) {
            String names = iterator.next().getName();
            if (names.equals(foodToRemove)) {
                return foods.remove(listNum);
            }
            listNum++;
        }
        logger.error("물품이 모두 떨어졌습니다.");
        throw new IllegalArgumentException("재고 없음");
    }

    /**
     * buylist의 물품 이름과 foodstand의 물품 이름을 비교하는 메서드이다.
     */
    public void search(String foodname) {
        Iterator<Food> iterator = foods.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getName().contains(foodname)) {
                return;
            }
        }
        logger.warn("buylist와 foodstand의 물품이 다릅니다.");
        throw new IllegalArgumentException("찾으시는 물건이 없습니다.");
    }

    public int size() {
        return foods.size();
    }

    public ArrayList<Food> getItem() {
        return foods;
    }


    public String getName() {
        return name;
    }

    public FoodStand(String name) {
        this.name = name;
    }
}
