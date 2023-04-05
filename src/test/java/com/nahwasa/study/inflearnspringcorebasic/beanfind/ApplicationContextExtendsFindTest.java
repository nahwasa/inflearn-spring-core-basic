package com.nahwasa.study.inflearnspringcorebasic.beanfind;

import com.nahwasa.study.inflearnspringcorebasic.discount.DiscountPolicy;
import com.nahwasa.study.inflearnspringcorebasic.discount.FixDiscountPolicy;
import com.nahwasa.study.inflearnspringcorebasic.discount.RateDiscountPolicy;
import com.nahwasa.study.inflearnspringcorebasic.member.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationContextExtendsFindTest {
    /**
     * 상위 타입으로 조회 시 하위 타입은 모두 조회된다.
     * 즉, Object로 조회시 전부 나온다.
     */

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig.class);

    @Configuration
    static class TestConfig {

        @Bean
        public DiscountPolicy rateDisctounPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDiscountPolicy() {
            return new FixDiscountPolicy();
        }
    }

    @Test
    @DisplayName("부모 타입으로 조회시 자식이 둘 이상 있으면 중복 오류가 발생한다.")
    void findBeanByParentTypeDuplicate() {

        assertThatThrownBy(() -> {
                    final DiscountPolicy bean = applicationContext.getBean(DiscountPolicy.class);
        }).isInstanceOf(NoUniqueBeanDefinitionException.class);
    }

    @Test
    @DisplayName("부모 타입으로 조회시 자식이 둘 이상 있으면, 빈 이름을 지정하면 된다.")
    void findBeanByName() {
        final DiscountPolicy rateDiscountPolicy = applicationContext.getBean("rateDisctounPolicy", DiscountPolicy.class);

        assertThat(rateDiscountPolicy).isInstanceOf(DiscountPolicy.class);
    }

    @Test
    @DisplayName("특정 하위 타입으로 조회하기")
    void findAllBeanBySubType() {
        final RateDiscountPolicy bean = applicationContext.getBean(RateDiscountPolicy.class);

        assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기")
    void findAllBeanByParentType() {
        final Map<String, DiscountPolicy> beansOfType = applicationContext.getBeansOfType(DiscountPolicy.class);

        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
        Assertions.assertThat(beansOfType.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Object로 모두 조회하기")
    void findAllBeanByObjectType() {
        final Map<String, Object> beansOfType = applicationContext.getBeansOfType(Object.class);

        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
    }
}
