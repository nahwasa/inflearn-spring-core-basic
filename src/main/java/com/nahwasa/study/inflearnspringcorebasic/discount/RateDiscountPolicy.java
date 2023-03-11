package com.nahwasa.study.inflearnspringcorebasic.discount;

import com.nahwasa.study.inflearnspringcorebasic.member.Grade;
import com.nahwasa.study.inflearnspringcorebasic.member.Member;

/**
 * 추가 요구사항 - 정률% 할인 추가
 */
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(final Member member, final int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }
        return 0;
    }
}
