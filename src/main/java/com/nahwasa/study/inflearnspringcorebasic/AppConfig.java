package com.nahwasa.study.inflearnspringcorebasic;

import com.nahwasa.study.inflearnspringcorebasic.discount.FixDiscountPolicy;
import com.nahwasa.study.inflearnspringcorebasic.member.MemberService;
import com.nahwasa.study.inflearnspringcorebasic.member.MemberServiceImpl;
import com.nahwasa.study.inflearnspringcorebasic.member.MemoryMemberRepository;
import com.nahwasa.study.inflearnspringcorebasic.order.OrderService;
import com.nahwasa.study.inflearnspringcorebasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 구현 객체를 생성하고, 연결하는 책임을 가지는 별도의 설정 클래스임.
 */

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public static FixDiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
