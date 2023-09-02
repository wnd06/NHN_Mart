package com.nhnacademy.mart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Basket에 추가한 물품들을 계산해주는 클래스이다.
 */
public class Counter {
    private static final Logger logger = LoggerFactory.getLogger(Counter.class);

    private int customerPay = 20000; // 20000원 보유
    private int result = 0;

    // TODO pay 메서드 구현 (카운터에서 계산 처리 메서드)

    /**
     * customerPay를 물품 가격의 총합에서 빼주는 메서드이다.
     */
    public int pay(Basket basket) {
        for (int i = 0; i < basket.getItem().size(); i++) {
            customerPay -= basket.getItem().get(i).getPrice();
        }
        return customerPay;
    }

    /**
     * 물품 가격의 총합을 알려주는 메서드이다.
     */
    public int total(Basket basket) {
        for (int i = 0; i < basket.getItem().size(); i++) {
            result += basket.getItem().get(i).getPrice();
        }
        if (result > customerPay) {
            logger.error("가격을 초과 하면 에러가 나옵니다.");
            throw new IllegalArgumentException("가격을 초과 하였습니다.");
        }
        return result;
    }
}
