package com.nahwasa.study.inflearnspringcorebasic.discount;

import com.nahwasa.study.inflearnspringcorebasic.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
