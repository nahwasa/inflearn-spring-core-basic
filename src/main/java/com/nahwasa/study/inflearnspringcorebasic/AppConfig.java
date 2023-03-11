package com.nahwasa.study.inflearnspringcorebasic;

import com.nahwasa.study.inflearnspringcorebasic.discount.FixDiscountPolicy;
import com.nahwasa.study.inflearnspringcorebasic.member.MemberService;
import com.nahwasa.study.inflearnspringcorebasic.member.MemberServiceImpl;
import com.nahwasa.study.inflearnspringcorebasic.member.MemoryMemberRepository;
import com.nahwasa.study.inflearnspringcorebasic.order.OrderService;
import com.nahwasa.study.inflearnspringcorebasic.order.OrderServiceImpl;

/**
 * 구현 객체를 생성하고, 연결하는 책임을 가지는 별도의 설정 클래스임.
 */
public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    private static FixDiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
