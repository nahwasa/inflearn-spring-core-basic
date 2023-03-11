package com.nahwasa.study.inflearnspringcorebasic.order;

import com.nahwasa.study.inflearnspringcorebasic.discount.DiscountPolicy;
import com.nahwasa.study.inflearnspringcorebasic.member.Member;
import com.nahwasa.study.inflearnspringcorebasic.member.MemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(final Long memberId, final String  itemName, final int itemPrice) {
        Member member = memberRepository.findById(memberId);
        final int discountPrice = this.discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
