package com.nahwasa.study.inflearnspringcorebasic.discount;

import com.nahwasa.study.inflearnspringcorebasic.member.Grade;
import com.nahwasa.study.inflearnspringcorebasic.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;
    @Override
    public int discount(final Member member, final int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }
        return 0;
    }
}
