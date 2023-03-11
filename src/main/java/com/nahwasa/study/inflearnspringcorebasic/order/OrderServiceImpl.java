package com.nahwasa.study.inflearnspringcorebasic.order;

import com.nahwasa.study.inflearnspringcorebasic.discount.DiscountPolicy;
import com.nahwasa.study.inflearnspringcorebasic.discount.FixDiscountPolicy;
import com.nahwasa.study.inflearnspringcorebasic.member.Member;
import com.nahwasa.study.inflearnspringcorebasic.member.MemberRepository;
import com.nahwasa.study.inflearnspringcorebasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(final Long memberId, final String itemName, final int itemPrice) {
        Member member = memberRepository.findById(memberId);
        final int discountPrice = this.discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
