package com.nhnacademy.mart;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class CounterTest {
    private final FoodStand foodStand = new FoodStand();

    public void prepareMart() {
        fillFoodStand();
    }

    // 음식 세팅
    private void fillFoodStand() {
        for (int i = 0; i < 2; i++) {
            foodStand.add(new Food("양파", 1_000));
        }
        for (int i = 0; i < 5; i++) {
            foodStand.add(new Food("계란", 5_000));
        }
        for (int i = 0; i < 10; i++) {
            foodStand.add(new Food("파", 500));
        }
        for (int i = 0; i < 20; i++) {
            foodStand.add(new Food("사과", 2_000));
        }
    }

    @Test
    @DisplayName("장바구니의 갯수 테스트 : add")
    public void sizeTest() {
        Food food = new Food("양파", 1000);
        Basket basket = new Basket();
        basket.add(food);
        Assertions.assertEquals(basket.getItem().size(), 1);
    }

    @Test
    @DisplayName("진열대 갯수 테스트 : delete")
    public void sizeTest2() {
        prepareMart();
        foodStand.delete("양파");
        foodStand.delete("사과");
        Assertions.assertEquals(35, foodStand.size());
    }

    @Test
    @DisplayName("총 합계 테스트")
    public void totalTest() {
        prepareMart();

        Counter counter = new Counter();
        Basket basket = new Basket();
        basket.add(foodStand.delete("양파"));
        basket.add(foodStand.delete("사과"));

        Assertions.assertEquals(3000, counter.total(basket));
    }

    @Test
    @DisplayName("총 합계가 초과 테스트")
    public void overTotlaTest() {
        prepareMart();
        BuyList.Item item = new BuyList.Item("계란", 5);
        Basket basket = new Basket();

        for (int i = 0; i < item.getAmount(); i++) {
            basket.add(foodStand.delete(item.getName()));
        }

        Counter counter = new Counter();
        Assertions.assertThrows(IllegalArgumentException.class, () -> counter.total(basket));
    }

    @Test
    @DisplayName("양파 3개를 delete 했을 경우 테스트")
    public void overOnionTest() {
        prepareMart();
        BuyList.Item item = new BuyList.Item("양파", 2);
        Basket basket = new Basket();

        for (int i = 0; i < item.getAmount(); i++) {
            basket.add(foodStand.delete(item.getName()));
        }
        Assertions.assertThrows(IllegalArgumentException.class, () -> basket.add(foodStand.delete(item.getName())));
    }

    @Test
    @DisplayName("buylist와 foodstand의 물품이 같지 않을 경우 테스트")
    public void notCompareTest() {
        prepareMart();
        BuyList.Item item = new BuyList.Item("과자", 2);

        Assertions.assertThrows(IllegalArgumentException.class, () -> foodStand.search(item.getName()));
    }
}
