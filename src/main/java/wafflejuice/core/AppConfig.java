package wafflejuice.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wafflejuice.core.discount.DiscountPolicy;
import wafflejuice.core.discount.FixDiscountPolicy;
import wafflejuice.core.member.MemberRepository;
import wafflejuice.core.member.MemberService;
import wafflejuice.core.member.MemberServiceImpl;
import wafflejuice.core.member.MemoryMemberRepository;
import wafflejuice.core.order.OrderService;
import wafflejuice.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
