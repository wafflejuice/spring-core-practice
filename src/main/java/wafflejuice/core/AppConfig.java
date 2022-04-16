package wafflejuice.core;

import wafflejuice.core.discount.DiscountPolicy;
import wafflejuice.core.discount.FixDiscountPolicy;
import wafflejuice.core.member.MemberRepository;
import wafflejuice.core.member.MemberService;
import wafflejuice.core.member.MemberServiceImpl;
import wafflejuice.core.member.MemoryMemberRepository;
import wafflejuice.core.order.OrderService;
import wafflejuice.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
