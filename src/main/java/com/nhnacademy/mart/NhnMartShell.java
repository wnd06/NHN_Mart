package com.nhnacademy.mart;

import java.util.ArrayList;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 이 클래스는  main문이며 여기서 코드가 시작된다.
 */
public class NhnMartShell {
    private static final Logger logger = LoggerFactory.getLogger(NhnMartShell.class);

    /**
     * 이 메소드는 main문이다.
     */
    public static void main(String[] args) {
        NhnMart mart = new NhnMart();
        mart.prepareMart();
        logger.info("NHN 마트에 오신 것을 환영합니다. 사고 싶은 물건을 골라주세요");

        BuyList buyList = inputBuyListFromShell();


        // TODO 본인이름 영어로 변수명 작성!
        // 본인이름을 각자 맞게 영어로 변경
        // 홍길동 학생
        // -> hongGilDong or gilDong
        Customer leejungmin = new Customer(buyList);

        // 장바구니를 챙긴다. -> 새로운 장바구니를 챙긴다.
        leejungmin.bring(mart.provideBasket());

        // 식품을 담는다.
        leejungmin.pickFoods(mart.getFoodStand());

        // 카운터에서 계산한다.
        leejungmin.payTox(mart.getCounter());


    }

    /**
     * 이 메소드는 몇개를 입력 할지 scanner로 받은 뒤
     * 그 수큼 buylist(메모지)에 추가하는 함수이다.
     */
    private static BuyList inputBuyListFromShell() {

        // TODO Scanner 입력을 받아 buyList 만들기
        Scanner sc = new Scanner(System.in);
        ArrayList<BuyList.Item> list = new ArrayList<>();

        // 사용자로부터 입력 받을 항목의 개수를 먼저 입력받을 수 있습니다.
        logger.info("항목의 개수를 입력하세요: ");
        int itemCount = sc.nextInt();

        for (int i = 0; i < itemCount; i++) {
            String itemName = sc.next();
            int itemAmount = Integer.parseInt(sc.next());

            list.add(new BuyList.Item(itemName, itemAmount));
        }

        BuyList buyList = new BuyList();
        for (int i = 0; i < list.size(); i++) {
            buyList.add(list.get(i));
        }

        return buyList;

    }
}
