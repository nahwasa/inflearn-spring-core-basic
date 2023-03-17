package com.nahwasa.study.inflearnspringcorebasic.order;

import com.nahwasa.study.inflearnspringcorebasic.member.Grade;
import com.nahwasa.study.inflearnspringcorebasic.member.Member;
import com.nahwasa.study.inflearnspringcorebasic.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OrderServiceTest {
    @Autowired private MemberService memberService;
    @Autowired private OrderService orderService;

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