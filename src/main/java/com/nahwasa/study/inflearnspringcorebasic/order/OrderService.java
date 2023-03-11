package com.nahwasa.study.inflearnspringcorebasic.order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);
}
