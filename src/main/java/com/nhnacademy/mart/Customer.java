package com.nhnacademy.mart;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 처음에 고객이란 객체를 만들어주는 클래스이다.
 */
public class Customer {
    private final Logger logger = LoggerFactory.getLogger(Customer.class);

    // 고객 구매 목록
    private final BuyList buyList;

    // 고객 장바구니
    private Basket basket;

    public Customer(BuyList buyList) {
        this.buyList = buyList;
    }

    // 장바구니 챙기기
    public void bring(Basket basket) {
        this.basket = basket;
    }

    // 물건 담기
    // TODO pickFoods 메서드 구현

    /**
     * buylist에서의 물품이름이 foodstand에 있으면 basket에 추가하는 메서드이다.
     */
    public void pickFoods(FoodStand foodStand) {

        ArrayList<BuyList.Item> list = buyList.getItems();
        for (BuyList.Item item : list) {
            foodStand.search(item.getName());
            for (int i = 0; i < item.getAmount(); i++) {
                basket.add(foodStand.delete(item.getName()));

            }
        }
    }

    // TODO payTox 메서드 구현

    /**
     * 총 가격과 잔액을 출력해주는 메서드 이다.
     */
    public void payTox(Counter counter) {

        logger.info("총 가격은 " + counter.total(basket) + "원 입니다.");
        logger.info("고객님 결제 후 잔액은 : " + counter.pay(basket));

    }
}
