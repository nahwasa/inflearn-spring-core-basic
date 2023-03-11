package com.nahwasa.study.inflearnspringcorebasic.order;

import com.nahwasa.study.inflearnspringcorebasic.member.Grade;
import com.nahwasa.study.inflearnspringcorebasic.member.Member;
import com.nahwasa.study.inflearnspringcorebasic.member.MemberService;
import com.nahwasa.study.inflearnspringcorebasic.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    @DisplayName("주문 생성 테스트")
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}