package wafflejuice.core;

import wafflejuice.core.discount.FixDiscountPolicy;
import wafflejuice.core.member.MemberService;
import wafflejuice.core.member.MemberServiceImpl;
import wafflejuice.core.member.MemoryMemberRepository;
import wafflejuice.core.order.OrderService;
import wafflejuice.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
